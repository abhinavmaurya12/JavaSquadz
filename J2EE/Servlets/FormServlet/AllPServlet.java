import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class AllPServlet extends HttpServlet
{
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        out.println("<html><body>");
        Enumeration e = req.getParameterNames();
        while (e.hasMoreElements())
        {
            String name = (String) e.nextElement();
            String value = req.getParameter(name);
            out.println(name + "=" + value);
            out.println("<br>");
        }
        out.println("</body></html>");

    }

}
