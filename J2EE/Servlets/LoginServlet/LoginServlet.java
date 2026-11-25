
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class LoginServlet extends HttpServlet
{
    public void doPost(HttpServletRequest req,
                       HttpServletResponse res)
                       throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String name = req.getParameter("name");
        String pass = req.getParameter("pass");

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        out.println("<html><body>");

        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            c = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "system",
                "mca6"
            );

            String sql =
                "SELECT * FROM emp101 WHERE name=? AND pass=?";

            ps = c.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pass);

            rs = ps.executeQuery();

            if (rs.next())
                out.println("<h2>User is Valid</h2>");
            else
                out.println("<h2>User is Invalid</h2>");
        }
        catch (Exception e)
        {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
        finally
        {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (c != null) c.close(); } catch (Exception e) {}
        }

        out.println("</body></html>");
    }
}
