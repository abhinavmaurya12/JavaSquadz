import java.sql.*;
import java.io.*;
class Oracle
{
    public static void main(String []ss)
    {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mca6");

            int t1=123;
            String t2="lalu";

            Statement s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            s.executeUpdate("drop table emp66" );
            s.executeUpdate("create table emp66(id number,name varchar(20))" );
            s.close();
            PreparedStatement ps=c.prepareStatement("insert into emp66 values(?,?)",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //PreparedStatement ps=c.prepareStatement("insert into emp66  values(?,?)");
            ps.setInt(1,t1);
            ps.setString(2,t2);

            ps.executeUpdate();
            ps.close();
            ps=c.prepareStatement("select * from emp66 where id=?");
            ps.setInt(1,t1);
            ResultSet result1=ps.executeQuery();

            while(result1.next())
            {
                System.out.println( result1.getInt(1));
                System.out.println( result1.getString(2));

            }

        }catch(SQLException e)
        {
            System.out.println(e);
        }
        catch(Exception i)
        {
            System.out.println(i);
        }
    }
}
//C:\oraclexe\app\oracle\product\10.2.0\server\jdbc\lib\ojdbc14.jar
