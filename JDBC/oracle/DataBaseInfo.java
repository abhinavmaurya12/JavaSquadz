import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class DataBaseInfo
{
  public static void main(String[] args) throws Exception {
    Class.forName("oracle.jdbc.driver.OracleDriver");

    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
    "system", "mca6");

    DatabaseMetaData mtdt = conn.getMetaData();
    System.out.println("URL in use: " + mtdt.getURL());
    System.out.println("User name: " + mtdt.getUserName());
    System.out.println("DBMS name: " + mtdt.getDatabaseProductName());
    System.out.println("DBMS version: " + mtdt.getDatabaseProductVersion());
    System.out.println("Driver name: " + mtdt.getDriverName());
    System.out.println("Driver version: " + mtdt.getDriverVersion());
    System.out.println("supp. SQL Keywords: " + mtdt.getSQLKeywords());

    conn.close();
  }

}
