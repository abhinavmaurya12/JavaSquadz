import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class ConfigServlet extends HttpServlet
{
    ServletConfig con;
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException,
    IOException
    {

        con = getServletConfig();
        //Enumeration e=con.getInitParameterNames();
        String image = con.getInitParameter("image");
        String driver = con.getInitParameter("driver");
        //String image=getInitParameter("image");
        //String driver=getInitParameter("driver");

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<HTML> <BODY background=" + image + ">");
        out.println(driver);

        out.println("</body></html>");

    }
}
