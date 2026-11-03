import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FetchSize
{
  public static void main(String[] argv) throws Exception {

    Class.forName("oracle.jdbc.driver.OracleDriver");

    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
    "system", "mca6");

    // Get the fetch size of a statement
    Statement stmt = conn.createStatement ();
    int fetchSize = stmt.getFetchSize();
    System.out.println(fetchSize);

    // Set the fetch size on the statement
    stmt.setFetchSize(100);
    fetchSize = stmt.getFetchSize();
    System.out.println(fetchSize);
    // Create a result set
    ResultSet resultSet = stmt.executeQuery("SELECT * FROM bank1");
    fetchSize = resultSet.getFetchSize();
    System.out.println(fetchSize+"via resultset before");
    // Change the fetch size on the result set
    resultSet.setFetchSize(200);
    fetchSize = resultSet.getFetchSize();
    System.out.println(fetchSize+"via resultset after");
    stmt.setFetchSize(500);
    fetchSize = resultSet.getFetchSize();
    System.out.println(fetchSize+"via resultset after changing in statement");

  }
}
