import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Deque (Double-Ended Queue) web app.
 * Menu: Add, Delete, Display, Sort, Reverse, Search, Search & Replace, Exit.
 * Run:  javac DequeServer.java && java DequeServer   ->  http://localhost:8080
 */
public class DequeServer {

    private static final int PORT = 8080;
    private static Path WEB_DIR;
    private static final Deque<String> dq = new ArrayDeque<>();

    /** Finds the folder containing index.html: ./web, ./, or next to the compiled class. */
    private static Path findWebDir() {
        List<Path> candidates = new ArrayList<>();
        Path cwd = Paths.get("").toAbsolutePath();
        candidates.add(cwd.resolve("web"));
        candidates.add(cwd);
        try {
            Path here = Paths.get(DequeServer.class.getProtectionDomain().getCodeSource().getLocation().toURI())
                    .toAbsolutePath();
            Path dir = Files.isDirectory(here) ? here : here.getParent();
            candidates.add(dir.resolve("web"));
            candidates.add(dir);
        } catch (Exception ignored) { }
        for (Path c : candidates) {
            if (Files.isRegularFile(c.resolve("index.html"))) return c.normalize();
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        WEB_DIR = findWebDir();
        if (WEB_DIR == null) {
            System.err.println("ERROR: index.html not found. Put index.html in a folder named 'web' next to DequeServer.java.");
            System.exit(1);
        }
        System.out.println("Serving UI from: " + WEB_DIR);
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
        server.createContext("/api/", DequeServer::handleApi);
        server.createContext("/", DequeServer::handleStatic);
        server.start();
        System.out.println("Deque app running at http://localhost:" + PORT);
    }

    // ---------------------------------------------------------------- API

    private static void handleApi(HttpExchange ex) throws IOException {
        try {
            Map<String, String> p = readParams(ex);
            String op = ex.getRequestURI().getPath().substring("/api/".length());
            String json;
            synchronized (dq) {
                json = switch (op) {
                    case "display" -> ok("Deque displayed.", null);
                    case "add"     -> add(p);
                    case "delete"  -> delete(p);
                    case "sort"    -> sort(p);
                    case "reverse" -> reverse();
                    case "search"  -> search(p);
                    case "replace" -> replace(p);
                    case "exit"    -> exit();
                    default        -> error("Unknown operation: " + op);
                };
            }
            send(ex, 200, "application/json", json.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            send(ex, 500, "application/json", error("Server error: " + e.getMessage()).getBytes(StandardCharsets.UTF_8));
        }
    }

    /** 1. ADD - insert one or more comma separated values at the front or rear. */
    private static String add(Map<String, String> p) {
        String raw = p.getOrDefault("value", "").trim();
        if (raw.isEmpty()) return error("Please enter a value to add.");
        boolean front = "front".equals(p.get("end"));
        List<String> values = new ArrayList<>();
        for (String part : raw.split(",")) {
            String v = part.trim();
            if (!v.isEmpty()) values.add(v);
        }
        if (values.isEmpty()) return error("Please enter a value to add.");
        // Keep the typed order: for FRONT inserts, add from the last value backwards.
        if (front) {
            for (int i = values.size() - 1; i >= 0; i--) dq.addFirst(values.get(i));
        } else {
            for (String v : values) dq.addLast(v);
        }
        int count = values.size();
        return ok("Added " + count + " item(s) at the " + (front ? "FRONT" : "REAR") + ".", null);
    }

    /** 2. DELETE - remove from the front or rear. */
    private static String delete(Map<String, String> p) {
        if (dq.isEmpty()) return error("Deque is empty (underflow) - nothing to delete.");
        boolean front = "front".equals(p.get("end"));
        String removed = front ? dq.removeFirst() : dq.removeLast();
        return ok("Deleted \"" + removed + "\" from the " + (front ? "FRONT" : "REAR") + ".", null);
    }

    /** 4. SORT - numeric if every item is a number, otherwise alphabetical. */
    private static String sort(Map<String, String> p) {
        if (dq.size() < 2) return error("Need at least 2 items to sort.");
        List<String> list = new ArrayList<>(dq);
        boolean numeric = list.stream().allMatch(DequeServer::isNumber);
        Comparator<String> cmp = numeric
                ? Comparator.comparingDouble(Double::parseDouble)
                : String.CASE_INSENSITIVE_ORDER;
        boolean desc = "desc".equals(p.get("order"));
        list.sort(desc ? cmp.reversed() : cmp);
        dq.clear();
        dq.addAll(list);
        return ok("Sorted " + (desc ? "descending" : "ascending") + " (" + (numeric ? "numeric" : "alphabetical") + ").", null);
    }

    /** 5. REVERSE */
    private static String reverse() {
        if (dq.size() < 2) return error("Need at least 2 items to reverse.");
        List<String> list = new ArrayList<>(dq);
        java.util.Collections.reverse(list);
        dq.clear();
        dq.addAll(list);
        return ok("Deque reversed.", null);
    }

    /** 6. SEARCH - case-insensitive exact match, returns 1-based positions from the front. */
    private static String search(Map<String, String> p) {
        String target = p.getOrDefault("value", "").trim();
        if (target.isEmpty()) return error("Please enter a value to search.");
        List<Integer> hits = new ArrayList<>();
        int i = 0;
        for (String s : dq) {
            if (s.equalsIgnoreCase(target)) hits.add(i);
            i++;
        }
        String msg = hits.isEmpty()
                ? "\"" + target + "\" not found."
                : "Found \"" + target + "\" " + hits.size() + " time(s) at position(s) "
                  + hits.stream().map(h -> String.valueOf(h + 1)).reduce((a, b) -> a + ", " + b).get() + ".";
        return build(!hits.isEmpty(), msg, hits);
    }

    /** 7. SEARCH & REPLACE - replaces every occurrence (case-insensitive) of old with new. */
    private static String replace(Map<String, String> p) {
        String oldV = p.getOrDefault("old", "").trim();
        String newV = p.getOrDefault("new", "").trim();
        if (oldV.isEmpty() || newV.isEmpty()) return error("Enter both the value to find and its replacement.");
        List<String> list = new ArrayList<>(dq);
        List<Integer> hits = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equalsIgnoreCase(oldV)) {
                list.set(i, newV);
                hits.add(i);
            }
        }
        if (hits.isEmpty()) return error("\"" + oldV + "\" not found - nothing replaced.");
        dq.clear();
        dq.addAll(list);
        return build(true, "Replaced " + hits.size() + " occurrence(s) of \"" + oldV + "\" with \"" + newV + "\".", hits);
    }

    /** 8. EXIT - clears the session. */
    private static String exit() {
        dq.clear();
        return ok("Session ended. Goodbye!", null);
    }

    // ------------------------------------------------------------ helpers

    private static boolean isNumber(String s) {
        try { Double.parseDouble(s); return true; } catch (NumberFormatException e) { return false; }
    }

    private static String ok(String msg, List<Integer> hl)    { return build(true, msg, hl); }
    private static String error(String msg)                   { return build(false, msg, null); }

    private static String build(boolean ok, String msg, List<Integer> highlight) {
        StringBuilder sb = new StringBuilder("{");
        sb.append("\"ok\":").append(ok).append(",");
        sb.append("\"message\":\"").append(esc(msg)).append("\",");
        sb.append("\"size\":").append(dq.size()).append(",");
        sb.append("\"items\":[");
        Iterator<String> it = dq.iterator();
        while (it.hasNext()) {
            sb.append("\"").append(esc(it.next())).append("\"");
            if (it.hasNext()) sb.append(",");
        }
        sb.append("],\"highlight\":[");
        if (highlight != null) {
            for (int i = 0; i < highlight.size(); i++) {
                sb.append(highlight.get(i));
                if (i < highlight.size() - 1) sb.append(",");
            }
        }
        sb.append("]}");
        return sb.toString();
    }

    private static String esc(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '"'  -> sb.append("\\\"");
                case '\\' -> sb.append("\\\\");
                case '\n' -> sb.append("\\n");
                case '\r' -> sb.append("\\r");
                case '\t' -> sb.append("\\t");
                default   -> sb.append(c < 0x20 ? String.format("\\u%04x", (int) c) : String.valueOf(c));
            }
        }
        return sb.toString();
    }

    private static Map<String, String> readParams(HttpExchange ex) throws IOException {
        Map<String, String> map = new HashMap<>();
        String query = ex.getRequestURI().getRawQuery();
        String body;
        try (InputStream in = ex.getRequestBody()) {
            body = new String(in.readAllBytes(), StandardCharsets.UTF_8);
        }
        for (String src : new String[]{query, body}) {
            if (src == null || src.isEmpty()) continue;
            for (String pair : src.split("&")) {
                int eq = pair.indexOf('=');
                if (eq < 0) continue;
                map.put(URLDecoder.decode(pair.substring(0, eq), StandardCharsets.UTF_8),
                        URLDecoder.decode(pair.substring(eq + 1), StandardCharsets.UTF_8));
            }
        }
        return map;
    }

    // ------------------------------------------------------- static files

    private static void handleStatic(HttpExchange ex) throws IOException {
        String path = ex.getRequestURI().getPath();
        if (path.equals("/")) path = "/index.html";
        Path file = WEB_DIR.resolve(path.substring(1)).normalize();
        if (!file.startsWith(WEB_DIR) || !Files.isRegularFile(file)) {
            send(ex, 404, "text/plain", "Not found".getBytes(StandardCharsets.UTF_8));
            return;
        }
        String type = path.endsWith(".html") ? "text/html; charset=utf-8"
                : path.endsWith(".css") ? "text/css"
                : path.endsWith(".js") ? "application/javascript"
                : "application/octet-stream";
        send(ex, 200, type, Files.readAllBytes(file));
    }

    private static void send(HttpExchange ex, int code, String type, byte[] data) throws IOException {
        ex.getResponseHeaders().set("Content-Type", type);
        ex.sendResponseHeaders(code, data.length);
        try (OutputStream os = ex.getResponseBody()) {
            os.write(data);
        }
    }
}
