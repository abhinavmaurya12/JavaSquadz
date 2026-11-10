import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;

// ============================================================================
// Main Application / Form Event Handling Class
// Contains lines ~299 - ~499 as shown in the editor slides
// ============================================================================
class QueryEventHandler implements ActionListener {
    CreateFirstForm cff;
    int[] sel = new int[100];

    QueryEventHandler(CreateFirstForm cff) {
        this.cff = cff;
    }

    public void actionPerformed(ActionEvent ae) {
        // --- Lines ~299 - 320: Handling JList selection / removal & jb4 reset ---
        int count = 0; // count stores no of elements in jlist2[cite: 3]
        count = Connect.fieldNames.size();[cite: 3]
        System.out.println(" ## " + count);[cite: 3]

        for (int i = 0; i < count; i++) { // find which indices are selected in jlist2[cite: 3]
            if (cff.jlist2.isSelectedIndex(i) == true) {[cite: 3]
                sel[i] = 1;[cite: 3]
            }
        }

        for (int i = 0; i < count; i++) { // remove selected indices from jlist2[cite: 3]
            if (sel[i] == 1) {[cite: 3]
                Connect.fieldNames.remove(i);[cite: 3]
            }
        }

        cff.jlist2.setListData(Connect.fieldNames); // will set column names into jlist2[cite: 3]
        // System.out.println(" ~~ "+sel[0]+" "+sel[1]+" "+sel[2]+" "+sel[3]+" "+sel[4]+" "+sel[5]+" "+sel[6]+" "+sel[7]+" "+sel[8]+" "+sel[9]+" "+" ~~ ");[cite: 3]

        ////////////////////////////////////////////////////////////////////////////////[cite: 3]
        ////////////////////////////////////////////////////////////////////////////////[cite: 3]
        if (ae.getSource() == cff.jb4) {[cite: 3]
            Connect.fieldNames.removeAllElements();[cite: 3]
            cff.jlist2.setListData(Connect.fieldNames); // will set column names into jlist2[cite: 3]
        }[cite: 3]

        // --- Lines ~323 - 340: Execute Query Button (jb5) & Construct Query (jb6) ---
        ////////////////////////////////////////////////////////////////////////////////[cite: 8]
        ////////////////////////////////////////////////////////////////////////////////[cite: 8]
        if (ae.getSource() == cff.jb5) {[cite: 8]
            new TableResult(cff.strQuery);[cite: 8]
        }[cite: 8]

        ////////////////////////////////////////////////////////////////////////////////[cite: 8]
        ////////////////////////////////////////////////////////////////////////////////[cite: 8]
        if (ae.getSource() == cff.jb6) {[cite: 8]
            if (cff.createQueryStatus == 0) {[cite: 8]
                int colCount = Connect.fieldNames.size();[cite: 8]

                for (int i = 0; i < colCount; i++) { // adding col names to query[cite: 8]
                    StringBuffer buf = new StringBuffer(Connect.fieldNames.elementAt(i).toString());[cite: 8]
                    if (i < colCount - 1) {[cite: 8]
                        cff.strQuery.append(buf.append(", "));[cite: 8]
                    } else {[cite: 8]
                        cff.strQuery.append(buf);[cite: 8]
                    }
                }[cite: 8]

                // --- Lines ~341 - 361: SELECT/FROM Clause & Initial WHERE Criteria ---
                if (cff.strQuery.toString().equals("select ")) {[cite: 11]
                    cff.strQuery.append("*");[cite: 11]
                }
                cff.strQuery.append(" from " + cff.jcom1.getSelectedItem()); // adding table names to query[cite: 11]

                // System.out.println(" $$"+cff.criteriaBuffer+"$$ ");[cite: 11]
                if (cff.criteriaBuffer.toString().equals(" ") == true) {[cite: 11]
                    // System.out.print(" &&& ");[cite: 11]
                    if ((cff.jcom2.getSelectedItem().equals("---None---") == false)[cite: 11]
                            && (cff.jcom3.getSelectedItem().equals("---None---") == false)[cite: 11]
                            && (cff.jtf1.getText().equals("Enter Value") == false)) {[cite: 11]
                        cff.criteriaBuffer.append("where ");[cite: 11]
                        cff.criteriaBuffer.append(cff.jcom2.getSelectedItem().toString());[cite: 11]
                        cff.criteriaBuffer.append(" " + cff.jcom3.getSelectedItem().toString());[cite: 11]
                        cff.criteriaBuffer.append(" " + cff.jtf1.getText());[cite: 11]
                    }[cite: 11]
                }[cite: 11]

                cff.createQueryStatus = 1;[cite: 10, 11]
            } else {[cite: 10]
                // System.out.print(" @@@ ");[cite: 10]
            }[cite: 10]

            // --- Lines ~368 - 384: Append Criteria, ORDER BY & Exit Button (jb7) ---
            cff.strQuery.append(cff.criteriaBuffer); // now append criteria clause to Query[cite: 10]
            cff.strQuery.append(cff.orderbyBuffer);  // now append orderby clause to Query[cite: 10]
            cff.orderbyBuffer = new StringBuffer(" ");[cite: 10]
            cff.criteriaBuffer = new StringBuffer(" ");[cite: 10]

            System.out.println(cff.strQuery);[cite: 10]
            // cff.strQuery = new StringBuffer(" ");[cite: 10]
        }[cite: 10]

        ////////////////////////////////////////////////////////////////////////////////[cite: 5, 10]
        ////////////////////////////////////////////////////////////////////////////////[cite: 5, 10]
        if (ae.getSource() == cff.jb7) {[cite: 5, 10]
            System.exit(0);[cite: 5]
        }[cite: 5]

        // --- Lines ~385 - 398: Criteria Radio Buttons (jrb1 / jrb2) ---
        ////////////////////////////////////////////////////////////////////////////////[cite: 5]
        ////////////////////////////////////////////////////////////////////////////////[cite: 5]
        if (ae.getSource() == cff.jrb1 || ae.getSource() == cff.jrb2) {[cite: 5]
            if (cff.criteriaBuffer.toString().equals(" ")) {[cite: 5]
                cff.criteriaBuffer.append("where ");[cite: 5]
                cff.criteriaBuffer.append(cff.jcom2.getSelectedItem().toString());[cite: 5]
                cff.criteriaBuffer.append(" " + cff.jcom3.getSelectedItem().toString());[cite: 5]
                cff.criteriaBuffer.append(" " + cff.jtf1.getText());[cite: 5]
            }[cite: 5]
            System.out.println(cff.criteriaBuffer);[cite: 5]
            cff.jbtemp.setBounds(450, 400, 60, 25);[cite: 5]
        }[cite: 5]

        // --- Lines ~400 - 418: Temporary Criteria Chaining Button (jbtemp) ---
        ////////////////////////////////////////////////////////////////////////////////[cite: 4]
        ////////////////////////////////////////////////////////////////////////////////[cite: 4]
        if (ae.getSource() == cff.jbtemp) {[cite: 4]
            // cff.criteriaBuffer.append("where ");[cite: 4]
            // cff.criteriaBuffer.append(cff.jcom2.getSelectedItem().toString() );[cite: 4]
            if (cff.jrb1.isSelected()) {[cite: 4]
                cff.criteriaBuffer.append(" AND " + cff.jcom2.getSelectedItem().toString()); // adding table names to query[cite: 4]
            } else {[cite: 4]
                cff.criteriaBuffer.append(" OR " + cff.jcom2.getSelectedItem().toString()); // adding table names to query[cite: 4]
            }
            cff.criteriaBuffer.append(" " + cff.jcom3.getSelectedItem().toString());[cite: 4]
            cff.criteriaBuffer.append(" " + cff.jtf1.getText());[cite: 4]

            System.out.println(cff.criteriaBuffer);[cite: 4]
            cff.jbtemp.setBounds(450, 1000, 60, 25);[cite: 4]
            cff.jrb3.setSelected(true);[cite: 4]
            // cff.jtf1.setVisible(true);[cite: 4]
        }[cite: 4]

        // --- Lines ~420 - 459: Order By Dialog Setup (jcb1) ---
        ////////////////////////////////////////////////////////////////////////////////[cite: 12]
        ////////////////////////////////////////////////////////////////////////////////[cite: 12]
        if (ae.getSource() == cff.jcb1) {[cite: 12]
            cff.jf11 = new JFrame("Order By Options");[cite: 12]
            cff.jf11.setSize(400, 350);[cite: 12]
            cff.jf11.setLocation(150, 130);[cite: 12]
            cff.jf11.setLayout(null);[cite: 12]

            JLabel jl1 = new JLabel("Order by");[cite: 12]
            jl1.setBounds(20, 10, 100, 25);[cite: 12]
            cff.jf11.add(jl1);[cite: 12]

            cff.jcom11 = new JComboBox(Connect.columnNames);[cite: 12]
            cff.jcom11.insertItemAt("---None---", 0);[cite: 12]
            cff.jcom11.setSelectedIndex(0);[cite: 12]
            cff.jcom11.setBounds(150, 40, 200, 25);[cite: 12]
            cff.jf11.add(cff.jcom11);[cite: 12]

            cff.jrb11.setBounds(100, 150, 100, 25);[cite: 12]
            cff.jf11.add(cff.jrb11);[cite: 12]
            cff.jrb12.setBounds(220, 150, 100, 25);[cite: 12]
            cff.jf11.add(cff.jrb12);[cite: 12]

            ButtonGroup bg2 = new ButtonGroup();[cite: 12]
            bg2.add(cff.jrb11);[cite: 12]
            bg2.add(cff.jrb12);[cite: 12]
            cff.jrb11.setSelected(true);[cite: 12]

            cff.jb11.setBounds(150, 200, 100, 25);[cite: 12]
            cff.jf11.add(cff.jb11);[cite: 12]

            cff.jb12.setBounds(150, 240, 100, 25);[cite: 12]
            cff.jf11.add(cff.jb12);[cite: 12]

            cff.jb13.setBounds(150, 280, 100, 25);[cite: 12]
            cff.jf11.add(cff.jb13);[cite: 12]

            cff.jf11.setVisible(true);[cite: 12]

            // --- Lines ~460 - 485: Order By Actions & Adding Clauses (jb11) ---
            cff.jb11.addActionListener(this);[cite: 7]
            cff.jb12.addActionListener(this);[cite: 7]
            cff.jb13.addActionListener(this);[cite: 7]

            cff.orderbyBuffer = new StringBuffer(" ");[cite: 7]
            cff.orderbyBuffer.append("order by ");[cite: 7]
        }[cite: 7]

        ////////////////////////////////////////////////////////////////////////////////[cite: 7]
        ////////////////////////////////////////////////////////////////////////////////[cite: 7]
        if (ae.getSource() == cff.jb11) {[cite: 7]
            if (cff.jcom11.getSelectedItem().toString().equals("---None---") == false) {[cite: 7]
                if (cff.orderbyBuffer.toString().equals(" order by ") == false) {[cite: 7]
                    cff.orderbyBuffer.append(", ");[cite: 7]
                }

                cff.orderbyBuffer.append(cff.jcom11.getSelectedItem().toString());[cite: 7]
                if (cff.jrb11.isSelected()) {[cite: 7]
                    cff.orderbyBuffer.append(" asc ");[cite: 7]
                } else {[cite: 7, 9]
                    cff.orderbyBuffer.append(" desc ");[cite: 7, 9]
                }

                cff.jcom11.setSelectedIndex(0);[cite: 9]
                System.out.println(cff.orderbyBuffer);[cite: 9]
            }[cite: 7, 9]
        }[cite: 7, 9]

        // --- Lines ~486 - 499: Order By Apply (jb12) and Cancel (jb13) ---
        if (ae.getSource() == cff.jb12) {[cite: 9]
            if (cff.orderbyBuffer.toString().equals(" order by ") == true) {[cite: 9]
                cff.orderbyBuffer = new StringBuffer(" ");[cite: 9]
            }
            cff.jf11.dispose();[cite: 9]
        }[cite: 9]

        if (ae.getSource() == cff.jb13) {[cite: 9]
            cff.orderbyBuffer = new StringBuffer(" ");[cite: 9]
            cff.jf11.dispose();[cite: 9]
        }[cite: 9]
    }[cite: 9]
}

// ============================================================================
// Lines ~500 - 620: Table Display Window (TableResult)
// ============================================================================
class TableResult {[cite: 6]
    Vector rowDataTemp = new Vector(0, 1);[cite: 6]
    Vector rowDataMain = new Vector(0, 1);[cite: 6]
    Vector columnNames = new Vector(0, 1);[cite: 6]

    Connection c;[cite: 6]
    Statement s;[cite: 6]
    ResultSet rs;[cite: 6]
    ResultSetMetaData rsmd;[cite: 6]

    JFrame jf;[cite: 18]
    JButton jb1, jb2;[cite: 18]
    JScrollPane jsp;[cite: 18]
    JTable jt;[cite: 18]

    TableResult(StringBuffer sb) {[cite: 6]
        try {[cite: 6]
            c = DriverManager.getConnection(Connect.dsnName);[cite: 6]
            s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);[cite: 6, 18]

            String str = sb.toString();[cite: 18]
            rs = s.executeQuery(str);[cite: 18]
            rsmd = rs.getMetaData();[cite: 18]

        } catch (SQLException e) {[cite: 18]
            System.out.println(" TableResult Table does not Exist");[cite: 18]
        } catch (Exception e) {[cite: 18]
            System.out.println(" TableResult Simple Exception");[cite: 18]
        }[cite: 18]

        createForm();[cite: 18]
        showTable();[cite: 18]
    }[cite: 18]

    void createForm() {[cite: 18]
        jf = new JFrame("Query Results");
        jf.setSize(500, 450);
        jf.setLayout(null);

        jb1 = new JButton("Close");
        jb1.setBounds(100, 360, 100, 25);
        jf.add(jb1);

        jb2 = new JButton("Exit");
        jb2.setBounds(250, 360, 100, 25);
        jf.add(jb2);

        // jt.doLayout();[cite: 14]

        jsp = new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);[cite: 14]
        jsp.setBounds(50, 50, 400, 280);[cite: 14]
        jf.add(jsp);[cite: 14]

        jf.setVisible(true);[cite: 14]

        TableEvent tabev = new TableEvent(this);[cite: 14]
        jb1.addActionListener(tabev);[cite: 14]
        jb2.addActionListener(tabev);[cite: 14]
    }[cite: 14]

    void showTable() {[cite: 14]
        try {[cite: 14]
            int numberOfColumns = rsmd.getColumnCount();[cite: 14]
            int numberOfRows = 0;[cite: 14]

            columnNames.removeAllElements();[cite: 14, 19]
            for (int i = 1; i <= numberOfColumns; i++) {[cite: 19]
                columnNames.add(rsmd.getColumnName(i));[cite: 19]
            }[cite: 19]

            int j = 0;[cite: 19]
            rowDataMain = new Vector(0, 1);[cite: 19]

            rs.beforeFirst();[cite: 19]
            while (rs.next()) {[cite: 19]
                numberOfRows += 1;[cite: 19]
                rowDataTemp = new Vector(0, 1);[cite: 19]

                for (int i = 1; i <= numberOfColumns; i++) {[cite: 19]
                    rowDataTemp.add(rs.getString(i));[cite: 19]
                }[cite: 19]

                rowDataMain.add(rowDataTemp);[cite: 19, 21]
            }[cite: 21]

            // System.out.print(tdb.rowDataTemp+" @@ "+tdb.rowDataTemp.size()+" "+tdb.rowDataTemp.capacity());[cite: 21]
            // System.out.println(" ~~ "+tdb.rowDataMain+" ~~ "+tdb.rowDataMain.size()+" "+tdb.rowDataMain.capacity());[cite: 21]

        } catch (SQLException e) {[cite: 21]
            System.out.println(" TableResult Table does not Exist");[cite: 21]
        } catch (Exception e) {[cite: 21]
            System.out.println(" TableResult Simple Exception");[cite: 21]
        }[cite: 21]

        jf.remove(jsp);[cite: 21]
        jt = new JTable(rowDataMain, columnNames);[cite: 21]
        jsp = new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);[cite: 21]
        jsp.setBounds(50, 50, 400, 280);[cite: 21]
        jf.add(jsp);[cite: 21]
    }[cite: 21]
}[cite: 21]

// ============================================================================
// Lines ~621 - 642: Table Result Action Listener (TableEvent)
// ============================================================================
class TableEvent implements ActionListener {[cite: 17]
    TableResult tr;[cite: 17]

    TableEvent(TableResult tr1) {[cite: 17]
        tr = tr1;[cite: 17]
    }[cite: 17]

    public void actionPerformed(ActionEvent ae) {[cite: 17]
        if (ae.getSource() == tr.jb1) {[cite: 17]
            tr.jf.dispose();[cite: 17]
        }[cite: 17]

        if (ae.getSource() == tr.jb2) {[cite: 17]
            System.exit(0);[cite: 17]
        }[cite: 17]
    }[cite: 17]
}[cite: 17]

// ============================================================================
// Lines ~646 - 726: Connection Window and Metadata Fetching (Connect)
// ============================================================================
class Connect {[cite: 15]
    static Vector tableNames = new Vector(0, 1);[cite: 15]
    static Vector columnNames = new Vector(0, 1);[cite: 15]
    static Vector fieldNames = new Vector(0, 1);[cite: 15]
    // static Vector tempSelectedNames = new Vector(0, 1);[cite: 15]

    static String dsnName = "";[cite: 15]

    JFrame jf;[cite: 15]
    JLabel jl;[cite: 15]
    JTextField jtf;[cite: 15]
    JButton jb01, jb02;[cite: 15]

    Connect() {[cite: 15]
        jf = new JFrame("Connection Builder");[cite: 15]
        jf.setSize(400, 150);[cite: 15, 22]
        jf.setLocation(300, 250);[cite: 22]
        jf.setLayout(null);[cite: 22]

        jl = new JLabel("Enter DSN Name : ");[cite: 22]
        jl.setBounds(20, 20, 120, 25);[cite: 22]
        jf.add(jl);[cite: 22]

        jtf = new JTextField("dsn1");[cite: 22]
        jtf.setBounds(150, 20, 120, 25);[cite: 22]
        jf.add(jtf);[cite: 22]

        jb01 = new JButton("OK");[cite: 22]
        jb01.setBounds(50, 80, 100, 25);[cite: 22]
        jf.add(jb01);[cite: 22]

        jb02 = new JButton("Exit");[cite: 22]
        jb02.setBounds(180, 80, 100, 25);[cite: 22]
        jf.add(jb02);[cite: 22, 23]

        jf.setVisible(true);[cite: 22, 23]

        ConnectEvent conev = new ConnectEvent(this);[cite: 23]
        jb01.addActionListener(conev);[cite: 23]
        jb02.addActionListener(conev);[cite: 23]
    }[cite: 23]

    public void connectDSN() {[cite: 23]
        try {[cite: 23]
            dsnName = new String("jdbc:odbc:" + dsnName);[cite: 23]
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");[cite: 23]
            Connection c = DriverManager.getConnection(dsnName);[cite: 23]
            Statement s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);[cite: 2, 23]

            // now find table names[cite: 2]
            DatabaseMetaData dbmd = c.getMetaData();[cite: 2]
            ResultSet rs = dbmd.getTables(null, null, null, new String[]{"TABLE"});[cite: 2]

            int numberOfTables = 0;[cite: 2]

            tableNames.add("---None---");[cite: 2]
            while (rs.next()) {[cite: 2]
                numberOfTables += 1;[cite: 2]
                tableNames.add(rs.getString(3));[cite: 2]
            }[cite: 2]
            System.out.println(tableNames + " " + numberOfTables);[cite: 2]

        } catch (SQLException e) {[cite: 2]
            System.out.println(" Table does not Exist");[cite: 2]
        } catch (Exception e) {[cite: 2]
            System.out.println(" Simple Exception");[cite: 2]
        }[cite: 2]
    }[cite: 2]
}

// ============================================================================
// Lines ~727 - 747: Connect Event Listener (ConnectEvent)
// ============================================================================
class ConnectEvent implements ActionListener {[cite: 13]
    Connect con;[cite: 13]

    ConnectEvent(Connect con1) {[cite: 13]
        con = con1;[cite: 13]
    }[cite: 13]

    public void actionPerformed(ActionEvent ae) {[cite: 13]
        if (ae.getSource() == con.jb01) {[cite: 13]
            Connect.dsnName = con.jtf.getText();[cite: 13]
            con.connectDSN();[cite: 13]
            con.jf.dispose();[cite: 13]
            new CreateFirstForm();[cite: 13]
        }[cite: 13]
        if (ae.getSource() == con.jb02) {[cite: 13]
            System.exit(0);[cite: 13]
        }[cite: 13]
    }[cite: 13]
}[cite: 13]

// ============================================================================
// Main UI Form Class Referenced by the Event Handlers (CreateFirstForm)
// ============================================================================
class CreateFirstForm {
    JFrame jf11;
    JList jlist2 = new JList();
    JButton jb4 = new JButton("Reset");
    JButton jb5 = new JButton("Execute");
    JButton jb6 = new JButton("Build Query");
    JButton jb7 = new JButton("Exit");
    JButton jbtemp = new JButton("Add Criteria");
    JButton jb11 = new JButton("Add Order");
    JButton jb12 = new JButton("Apply");
    JButton jb13 = new JButton("Cancel");
    JButton jcb1 = new JButton("Order By Options");

    JComboBox jcom1 = new JComboBox(Connect.tableNames);
    JComboBox jcom2 = new JComboBox(Connect.columnNames);
    JComboBox jcom3 = new JComboBox(new String[]{"---None---", "=", ">", "<", ">=", "<=", "<>"});
    JComboBox jcom11 = new JComboBox();

    JTextField jtf1 = new JTextField("Enter Value");

    JRadioButton jrb1 = new JRadioButton("AND");
    JRadioButton jrb2 = new JRadioButton("OR");
    JRadioButton jrb3 = new JRadioButton();
    JRadioButton jrb11 = new JRadioButton("ASC");
    JRadioButton jrb12 = new JRadioButton("DESC");

    StringBuffer strQuery = new StringBuffer("select ");
    StringBuffer criteriaBuffer = new StringBuffer(" ");
    StringBuffer orderbyBuffer = new StringBuffer(" ");
    int createQueryStatus = 0;

    CreateFirstForm() {
        JFrame mainFrame = new JFrame("Query Builder");
        mainFrame.setSize(600, 500);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        QueryEventHandler handler = new QueryEventHandler(this);

        jb4.addActionListener(handler);
        jb5.addActionListener(handler);
        jb6.addActionListener(handler);
        jb7.addActionListener(handler);
        jbtemp.addActionListener(handler);
        jcb1.addActionListener(handler);
        jrb1.addActionListener(handler);
        jrb2.addActionListener(handler);

        // Add components to layout
        jcom1.setBounds(50, 30, 150, 25);
        mainFrame.add(jcom1);

        jlist2.setBounds(50, 70, 150, 120);
        mainFrame.add(jlist2);

        jb4.setBounds(50, 200, 80, 25);
        mainFrame.add(jb4);

        jcom2.setBounds(220, 30, 120, 25);
        mainFrame.add(jcom2);

        jcom3.setBounds(350, 30, 90, 25);
        mainFrame.add(jcom3);

        jtf1.setBounds(450, 30, 100, 25);
        mainFrame.add(jtf1);

        jrb1.setBounds(220, 70, 70, 25);
        mainFrame.add(jrb1);

        jrb2.setBounds(300, 70, 70, 25);
        mainFrame.add(jrb2);

        jcb1.setBounds(220, 120, 160, 25);
        mainFrame.add(jcb1);

        jb6.setBounds(220, 170, 120, 25);
        mainFrame.add(jb6);

        jb5.setBounds(350, 170, 100, 25);
        mainFrame.add(jb5);

        jb7.setBounds(460, 170, 80, 25);
        mainFrame.add(jb7);

        jbtemp.setBounds(450, 1000, 110, 25);
        mainFrame.add(jbtemp);

        mainFrame.setVisible(true);
    }
}

// ============================================================================
// Main Execution Entry Point
// ============================================================================
public class Query02 {
    public static void main(String[] args) {
        new Connect();
    }
}