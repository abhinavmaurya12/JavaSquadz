import java.sql.*;
import java.io.*;
class Sequence
{
    public static void main(String []ss)
    {
        try{
        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
        "system","mca6");
Statement s = c.createStatement();
//s.executeUpdate("create sequence seq5 increment by 1 start with 100 ");
//s.executeUpdate("drop table emp22");
//s.executeUpdate("create table emp22(id  number)" );
s.executeUpdate("insert into emp22 values(seq5.nextval)");
s.close();
}catch(Exception e){System.out.println(e); }
}
}
