import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class LoginServlet extends HttpServlet
{
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        out.println("<html><body>");
        String name = req.getParameter("name");
        String pass = req.getParameter("pass");
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "mca6");
            Statement s = c.createStatement();
            String s1 = "select * from emp101  where  name='" + name + "'  and pass='" + pass + "'";
            //out.println(s1);
            ResultSet rs = s.executeQuery(s1);
            if (rs.next())
                out.println("User is Valid");
            else
                out.println("User is InValid");
        } catch (Exception e) { out.println(e); }

        out.println("</body></html>");

    }

}
