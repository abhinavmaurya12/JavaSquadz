import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class GetDate {
  public static void main(String[] args) throws Exception
  {
   Class.forName("oracle.jdbc.driver.OracleDriver");

    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
    "system", "mca6");
    Statement st = conn.createStatement();
    st.executeUpdate("drop table survey16");
    st.executeUpdate("create table survey16(id number(3),myDate DATE  DEFAULT (sysdate))");
    String INSERT_RECORD = "insert into survey16(id, myDate) values(?, ?)";

    PreparedStatement pstmt = conn.prepareStatement(INSERT_RECORD);
    pstmt.setInt(1,1);
    System.out.println(new java.util.Date().getTime());
    java.sql.Date  sqlDate = new java.sql.Date(new java.util.Date().getTime());
    pstmt.setDate(2, sqlDate);

    pstmt.executeUpdate();

    ResultSet rs = st.executeQuery("SELECT * FROM survey16");

  while (rs.next())
  {
        System.out.print(rs.getDate(2));
  }

    rs.close();
    st.close();
    conn.close();
  }

  }
