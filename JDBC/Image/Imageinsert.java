import java.io.*;
import java.sql.*;
public class Imageinsert
{
public static void main(String args[]) throws Exception
{
//Class.forName("com.mysql.jdbc.Driver");
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system",
"mca6");
//Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/appsquadz56",
//"appsquadz56", "appsquadz56");
Statement st=conn.createStatement();
st.executeUpdate("drop table image18");
st.executeUpdate("create table image18(name varchar(15),image blob)");
File file=new File("baby.gif");
FileInputStream fis=new FileInputStream(file);
PreparedStatement ps=conn.prepareStatement("insert into image18 values(?,?)");
ps.setString(1,"baby");
ps.setBinaryStream(2,fis,(int)file.length());
ps.execute();
ps.close();
fis.close();
}
}
