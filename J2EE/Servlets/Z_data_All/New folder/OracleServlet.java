import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class OracleServlet extends HttpServlet
{

public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
 {
  res.setContentType("text/html");
  ServletContext ctx=getServletContext();
  PrintWriter out = res.getWriter();
out.println("<html><body>");
//Enumeration e=ctx.getInitParameterNames();
String driver=ctx.getInitParameter("driver");
String url=ctx.getInitParameter("url");
String user=ctx.getInitParameter("user");
String pass=ctx.getInitParameter("pass");
try
{
Class.forName(driver);
Connection c = DriverManager.getConnection(url,user,pass);

Statement s = c.createStatement();
ResultSet rs=s.executeQuery("select * from emp101");
while(rs.next())
{
out.println(rs.getString(1));
out.println(rs.getString(2));
out.println("<br>");
}
}catch(Exception e){System.out.println(e); }
out.println("</body></html>");
}

}
