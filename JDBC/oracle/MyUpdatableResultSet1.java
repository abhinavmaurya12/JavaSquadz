import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyUpdatableResultSet1
{

    public static void main(String a[])
    {

        Statement st = null;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "mca6");
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                     ResultSet.CONCUR_UPDATABLE);

            rs = st.executeQuery("select accno, bal from bank1");

            while (rs.next())
            {

                if (rs.getInt(1) == 1001) {
                    rs.updateDouble(2, 400);
                    rs.updateRow();
                    System.out.println("Record updated!!!");
                }

            }

        } catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
