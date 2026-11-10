import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Nullable
{

   public static void main(String[] args) throws Exception {
 Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"
           , "system", "mca6");
  String sql = "CREATE TABLE users11(id NUMBER(11) NOT NULL, username  VARCHAR2(64)  )";
    Statement statement = conn.createStatement();
// statement.execute("drop table users11");
statement.execute(sql);
    ResultSet resultSet = statement.executeQuery("SELECT id, username FROM users11");
    ResultSetMetaData metadata = resultSet.getMetaData();
    int nullability = metadata.isNullable(1);

    if (nullability == ResultSetMetaData.columnNullable) {
      System.out.println("Columns ID or name can have a null value");
    } else if (nullability == ResultSetMetaData.columnNoNulls) {
      System.out.println("Columns ID does not allowed to have a null value");
    } else if (nullability == ResultSetMetaData.columnNullableUnknown) {
      System.out.println("Nullability unknown");
    }
  }
}
