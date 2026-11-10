import java.sql.*;
import java.io.*;
class Min
{
    public static void main(String []ss)
    {
        try{
Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
        "system","mca6");
Statement s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//ResultSet result1=s.executeQuery("SELECT MIN(employee.empSalary) FROM Employee employee" );
ResultSet result1=s.executeQuery("SELECT MAX(employee.empSalary) FROM Employee employee" );
while(result1.next())
{
System.out.println( result1.getString(1));


}

}catch(SQLException e)
        {
            System.out.println(e);
        }
        catch(Exception i){System.out.println(i);}
    }
}
//C:\oraclexe\app\oracle\product\10.2.0\server\jdbc\lib\ojdbc14.jar
