import java.sql.*;

class TestInsert1
{
    public static void main(String []ss)
    {
        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system",
            "mca6");
            String t1="MGHector";
            int t2=1003;
            Statement s = c.createStatement();
            s.executeUpdate("drop table emp55" );
            s.executeUpdate("create table emp55(name varchar2(10),id number)" );

            int x=s.executeUpdate("insert into emp55 values('"+t1+"',"+t2+")");
            System.out.println(x);
            ResultSet result1=s.executeQuery("select * from emp55");

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