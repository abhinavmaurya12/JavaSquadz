import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;

public class FormServlet extends HttpServlet
{
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
    {
        ServletOutputStream out = res.getOutputStream();
        res.setContentType("text/html");
        out.println("<html><head><title>Basic Form Processor Output</title></head>");
        out.println("<body>");
        out.println("<h1>Here is your Form Data</h1>");
        //extract the form data here
        String title = req.getParameter("title");
        String name = req.getParameter("name");
        String city = req.getParameter("city");
        String country = req.getParameter("country");
        String tel = req.getParameter("tel");
        String age = req.getParameter("age");
        // extracting data from the checkbox field
        String[] interests = req.getParameterValues("interests");
        //output the data into a web page
        out.println("Your title is " + title);
        out.println("<br>Your name is " + name);
        out.println("<br>Your city is " + city);
        out.println("<br>Your country is " + country);
        out.println("<br>Your tel is " + tel);
        out.println("<br>Your interests include<ul> ");
        for (int i = 0; i < interests.length; i++) {
            out.println("<li>" + interests[i]);
        }
        out.println("</ul>");
        out.println("<br>Your age is " + age);
        out.println("</body></html>");
    }
}
