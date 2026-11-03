import java.sql.*;
import java.io.*;
import java.util.*;
class TestRetrive2
{
    public static void main(String []ss)
    {
        try{
            FileInputStream fn = new FileInputStream("db.properties");
            Properties pr = new Properties();
            pr.load(fn);
            String driver = pr.getProperty("driver");
            String url = pr.getProperty("url");
            String user = pr.getProperty("user");
            String pass = pr.getProperty("pass");
            Class.forName(driver);

            Connection c = DriverManager.getConnection(url,user,pass);
            Statement s = c.createStatement();

            ResultSet result1=s.executeQuery("select * from emp101");

            while(result1.next())
            {
                System.out.println( result1.getString("name")+"="+ result1.getString(2));
            }

        }catch(SQLException e)
        {
            System.out.println(e);
        }
        catch(Exception i){System.out.println(i);}
    }
}
//C:\oraclexe\app\oracle\product\10.2.0\server\jdbc\lib\ojdbc14.jar