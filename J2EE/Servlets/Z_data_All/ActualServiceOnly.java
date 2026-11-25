import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class ActualServiceOnly extends HttpServlet
{

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
    {
        super.service(req, res);
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<html><body>");
        out.println("Actual  service");
        out.println("</body></html>");
    }

}
