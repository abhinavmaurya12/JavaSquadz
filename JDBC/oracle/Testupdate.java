import java.sql.*;
import java.util.*;
class Testupdate
{
    public static void main(String []ss)
    {
        try{
            Driver d=new oracle.jdbc.driver.OracleDriver();
            Properties dbProp = new Properties();
            dbProp.put("user", "system");
            dbProp.put("password", "mca6");
            Connection c=d.connect("jdbc:oracle:thin:@localhost:1521:xe",dbProp );
            String z="bmwx4";
            String t4="10004";
			// String t4 = "Abhinav";
            Statement s = c.createStatement();
            int z1=s.executeUpdate("update emp101 set pass='"+z+"'where name='"+t4+"'");
            System.out.println(z1);
            ResultSet result1=s.executeQuery("select * from emp101  where name='"+t4+"'");

            while(result1.next())
            {
                System.out.println( result1.getString(1));
                System.out.println( result1.getString(2));
				
				// System.out.println(result1.getString("pass"));

            }

        }catch(SQLException e)
        {
            System.out.println(e);
        }
        catch(Exception i){System.out.println(i);}
    }
}