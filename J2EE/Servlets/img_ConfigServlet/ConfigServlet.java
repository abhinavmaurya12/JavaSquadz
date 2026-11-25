
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ConfigServlet extends HttpServlet {

    public void doGet(HttpServletRequest req,
                      HttpServletResponse res)
                      throws ServletException, IOException {

        res.setContentType("text/html");

        ServletConfig config = getServletConfig();

        String driver = config.getInitParameter("driver");
        String image = config.getInitParameter("image");

        PrintWriter out = res.getWriter();

        String imagePath = req.getContextPath() + "/" + image;

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");

        out.println("<title>Servlet Image Display</title>");

        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");

        out.println("<style>");

        out.println("* { margin:0; padding:0; box-sizing:border-box; }");

        out.println("html, body {");
        out.println("width:100%;");
        out.println("height:100%;");
        out.println("overflow:hidden;");
        out.println("}");

        out.println("body { background:black; }");

        out.println(".container {");
        out.println("position:fixed;");
        out.println("top:0;");
        out.println("left:0;");
        out.println("width:100vw;");
        out.println("height:100vh;");
        out.println("display:grid;");
        out.println("grid-template-columns:repeat(auto-fill,minmax(150px,1fr));");
        out.println("grid-auto-rows:150px;");
        out.println("overflow:hidden;");
        out.println("gap:0;");
        out.println("}");

        out.println(".container img {");
        out.println("width:100%;");
        out.println("height:100%;");
        out.println("object-fit:cover;");
        out.println("display:block;");
        out.println("}");

        out.println(".overlay {");
        out.println("position:fixed;");
        out.println("top:15px;");
        out.println("left:15px;");
        out.println("z-index:10;");
      out.println("color:black;");
        out.println("font-family:Arial,sans-serif;");
        out.println("}");

        out.println(".overlay h2 { margin-bottom:5px; }");

        out.println("</style>");
        out.println("</head>");

        out.println("<body>");

        out.println("<div class='container'>");

        for (int i = 1; i <= 100; i++) {
            out.println("<img src='" + imagePath + "'>");
        }

        out.println("</div>");

        out.println("<div class='overlay'>");
        out.println("<h2>Servlet Image Display</h2>");
        out.println("<p>Driver: " + driver + "</p>");
        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}
