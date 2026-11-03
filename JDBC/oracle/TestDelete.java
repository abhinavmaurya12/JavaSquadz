import java.sql.*;
import java.util.*;
class TestDelete
{
    public static void main(String []ss)
    {
        try{
            System.setProperty("jdbc.drivers","oracle.jdbc.driver.OracleDriver");
            Properties dbProp = new Properties();
            dbProp.put("user", "system");
            dbProp.put("password", "mca6");
            Connection c= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
            dbProp);
            String t5="10004";
            Statement s = c.createStatement();
            int a=s.executeUpdate("delete from emp101 where name='"+t5+"'");
            System.out.println(a);
            ResultSet result1=s.executeQuery("select * from emp101");

            while(result1.next())
            {
                System.out.println( result1.getString(1));
                System.out.println( result1.getString(2));

            }

        }catch(SQLException e)
        {
            System.out.println(e);
        }
        catch(Exception i){System.out.println(i);}
    }
}