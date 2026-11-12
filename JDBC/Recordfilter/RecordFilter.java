import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.awt.event.*;
import java.util.*;

public class RecordFilter extends JFrame implements KeyListener
{
    // ---- Oracle connection settings (change here only) ----
    static final String URL  = "jdbc:oracle:thin:@localhost:1521:xe";
    static final String USER = "system";
    static final String PASS = "mca6";

    JLabel lid;
    JTextField tb;
    JTable ta;
    Connection cn;
    int columns;
    JScrollPane sp;
    DefaultTableModel model;

    public RecordFilter()
    {
        setTitle("Record Filter");
        setSize(500, 400);
        setResizable(true);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lid = new JLabel("Enter ID/Phone:");
        lid.setBounds(100, 50, 100, 27);
        add(lid);

        tb = new JTextField();
        tb.setBounds(210, 50, 150, 27);
        add(tb);
        tb.addKeyListener(this);

        model = new DefaultTableModel();
        ta = new JTable(model);
        sp = new JScrollPane(ta);
        sp.setBounds(50, 100, 400, 150);
        add(sp);

        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            cn = DriverManager.getConnection(URL, USER, PASS);

            // Read only the column names, no rows
            try (Statement st = cn.createStatement();
                 ResultSet rst = st.executeQuery("select * from Employee where 1=0"))
            {
                ResultSetMetaData md = rst.getMetaData();
                columns = md.getColumnCount();
                for (int i = 1; i <= columns; i++)
                    model.addColumn(md.getColumnName(i));
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "DB error: " + ex.getMessage());
        }

        setVisible(true);
    }

    public void keyPressed(KeyEvent ke) {}
    public void keyTyped(KeyEvent ke) {}

    public void keyReleased(KeyEvent ke)
    {
        String str = tb.getText().trim();
        clearTable();
        if (str.isEmpty() || cn == null) return;

        // TO_CHAR lets LIKE work even if eid/phone are NUMBER columns in Oracle
        String sql = "select * from Employee "
                   + "where to_char(eid) like ? or to_char(phone) like ?";
        try (PreparedStatement ps = cn.prepareStatement(sql))
        {
            ps.setString(1, str + "%");
            ps.setString(2, str + "%");
            try (ResultSet rst = ps.executeQuery())
            {
                while (rst.next())
                {
                    Vector<Object> row = new Vector<>();
                    for (int i = 1; i <= columns; i++)
                        row.add(rst.getString(i));
                    model.addRow(row);
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    void clearTable()
    {
        model.setRowCount(0);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(RecordFilter::new);
    }
}