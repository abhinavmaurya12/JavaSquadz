import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;

public class GetTableName
{
  public static void main(String[] args) throws Exception
  {
    Class.forName("oracle.jdbc.driver.OracleDriver");

    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
    "system", "mca6");

//Class.forName("com.mysql.jdbc.Driver");

//Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/appsquadz104",
//"appsquadz104", "appsquadz104");
    Statement st = conn.createStatement();
    getTables(conn);
      st.close();
    conn.close();
  }
  public static void getTables(Connection conn) throws Exception {
    String TABLE_NAME = "TABLE_NAME";
    String TABLE_SCHEMA = "TABLE_SCHEM";
    //String[] TABLE_TYPES = {"VIEW"};
String[] TABLE_TYPES = {"TABLE","VIEW"};
    DatabaseMetaData dbmd = conn.getMetaData();

    ResultSet tables = dbmd.getTables(null, null, null, TABLE_TYPES);
ResultSetMetaData rsmd=tables.getMetaData();
int count=rsmd.getColumnCount();
System.out.println(count);
for(int i=1;i<=count;i++)
{
System.out.println(rsmd.getColumnName(i));
System.out.println(rsmd.getColumnTypeName(i));

}
    while (tables.next())
{
     // System.out.println(tables.getString(TABLE_NAME));

     System.out.println(tables.getString(3));
     //System.out.println(tables.getString(TABLE_SCHEMA)+"schema");
    }
  }


}
