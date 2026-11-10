import java.sql.*;
class BatchUpdate
{
    public static void main(String []ss)
    {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mca6");
            Statement s = c.createStatement();
            String s1="update emp101 set name='up1' where pass='up'";
            String s2="insert into emp101 values('2nov','2nov')";
            String s3="delete from emp101 where pass='10aug'";
            s.addBatch(s1);
            s.addBatch(s2);
            s.addBatch(s3);
            s.executeBatch();
            ResultSet result1=s.executeQuery("select * from emp101");
            while(result1.next())
            {
                System.out.println("name"+result1.getString(1));
                System.out.println("pass" + result1.getString(2));

            }

        }catch(Exception e){ System.out.println(e);}

    }
}
