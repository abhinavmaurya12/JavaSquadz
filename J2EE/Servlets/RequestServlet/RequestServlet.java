
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class RequestServlet extends HttpServlet {

    private static final String URL =
        "jdbc:oracle:thin:@localhost:1521:xe";

    private static final String USER = "system";
    private static final String PASSWORD = "mca6";

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();

        String name = req.getParameter("name");
        String pass = req.getParameter("pass");

        out.println("<html><body>");

        if (name == null || pass == null ||
                name.trim().length() == 0 ||
                pass.trim().length() == 0) {

            out.println("<h3>Please enter name and password.</h3>");
            out.println("</body></html>");
            return;
        }

        String insertSQL =
            "INSERT INTO emp101 (name, pass) VALUES (?, ?)";

        Connection c = null;
        PreparedStatement ps = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            c = DriverManager.getConnection(URL, USER, PASSWORD);

            ps = c.prepareStatement(insertSQL);
            ps.setString(1, name);
            ps.setString(2, pass);

            int rows = ps.executeUpdate();

            out.println("<h3>" + rows +
                " record inserted successfully!</h3>");

            st = c.createStatement();
            rs = st.executeQuery("SELECT * FROM emp101");

            ResultSetMetaData rsmd = rs.getMetaData();
            int columns = rsmd.getColumnCount();

            out.println("<table bgcolor='yellow' border='1'>");
            out.println("<tr>");

            for (int i = 1; i <= columns; i++) {
                out.println("<th>" + rsmd.getColumnName(i) + "</th>");
            }

            out.println("</tr>");

            while (rs.next()) {
                out.println("<tr>");

                for (int i = 1; i <= columns; i++) {
                    out.println("<td>" + rs.getString(i) + "</td>");
                }

                out.println("</tr>");
            }

            out.println("</table>");

            if ("codesquadz".equals(name) &&
                    "codesquadz".equals(pass)) {
                out.println("<h3>User is POST valid</h3>");
            } else {
                out.println("<h3>User is POST invalid</h3>");
            }

        } catch (Exception e) {
            out.println("<h3>Database Error: " +
                e.getMessage() + "</h3>");
            e.printStackTrace();

        } finally {

            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (st != null) st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (c != null) c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();

        String name = req.getParameter("name");
        String pass = req.getParameter("pass");

        out.println("<html><body>");

        if ("codesquadz".equals(name) &&
                "codesquadz".equals(pass)) {
            out.println("<h3>User is valid through GET</h3>");
        } else {
            out.println("<h3>User is invalid through GET</h3>");
        }

        out.println("</body></html>");
    }
}
