import java.sql.*;

class TestInsert
{
    public static void main(String []ss)
    {
        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system",
            "mca6");
            String t1="10004";
            String t2="hector";
            Statement s = c.createStatement();
            int x=s.executeUpdate("insert into emp102 values('"+t1+"','"+t2+"')");
            System.out.println(x);
            ResultSet result1=s.executeQuery("select * from emp102");

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