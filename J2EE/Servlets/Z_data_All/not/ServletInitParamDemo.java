import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
    urlPatterns = {"/initparam"},
    initParams = {
        @WebInitParam (name = "email", value = "abc@gmail.com"),
        @WebInitParam (name = "phone", value = "123456")
    }
)

public class ServletInitParamDemo extends HttpServlet {


    private String email = "", phone = "";

    public ServletInitParamDemo()
    {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        email = config.getInitParameter("email");
        phone = config.getInitParameter("phone");
    }
    protected void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        String html = "<h2>Access data using @WebInitParam</h2>";
        PrintWriter out = response.getWriter();
        html += "<h3>Email : " + email + "<br/>Phone No. : " + phone + "</h3>";
        out.println(html);
    }

}
