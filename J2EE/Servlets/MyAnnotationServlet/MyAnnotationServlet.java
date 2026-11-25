import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "MyAnnotationServlet", urlPatterns = {"/hello"})
public class MyAnnotationServlet extends HttpServlet
{
    public void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Hello World Servlet Annotation Example</h2>");
        out.close();
    }
}
