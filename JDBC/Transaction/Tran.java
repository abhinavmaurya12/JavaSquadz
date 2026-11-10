import java.sql.*;
import java.io.*;
class Tran
{
    public static void main(String []ss)
    {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
            "system","mca6");

Statement s = c.createStatement();

c.setAutoCommit(false);
int x=s.executeUpdate("update emp101 set name='appsquadz' where pass='up' ");


ResultSet result1=s.executeQuery("select * from emp101 where pass='up' ");

        while(result1.next())
        {
System.out.println("name" + result1.getString(1));
System.out.println("pass" + result1.getString(2));
    }
c.commit();
}catch(Exception e){ System.out.println(e);}

}
}
