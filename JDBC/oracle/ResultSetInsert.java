import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetInsert {

    public static void main(String a[])
    {
        Statement st = null;
        ResultSet rs = null;
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "mca6");
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                     ResultSet.CONCUR_UPDATABLE);

            rs = st.executeQuery("select accno, bal from bank1");

            while (rs.next())
            {

                System.out.print(rs.getInt(1) + "=");
                System.out.print(rs.getInt(2));
                System.out.println("  ");
            }
            rs.moveToInsertRow();
            rs.updateInt(1, 1007);
            rs.updateInt(2, 75000);
            rs.insertRow();

            rs.beforeFirst();
            rs = st.executeQuery("select accno, bal from bank1");
            System.out.println("after insertion of new Record");
            while (rs.next())
            {
                System.out.print(rs.getInt(1) + "=");
                System.out.print(rs.getInt(2));
                System.out.println("  ");
            }
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
