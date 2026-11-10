import java.io.*;
import java.sql.*;
public class Imageretrieve
{
public static void main(String args[]) throws Exception
{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system",
"mca6");
PreparedStatement ps=conn.prepareStatement("select image from image18  where name=?");
ps.setString(1,"baby");
ResultSet rs=ps.executeQuery();
rs.next();
InputStream f=rs.getBinaryStream("image");
FileOutputStream f1=new FileOutputStream("abc6.gif");
int i=0;
while((i=f.read())!=-1)
f1.write(i);
}
}
