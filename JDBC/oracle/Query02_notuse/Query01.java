import java.sql.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;


class Query01
{
//  Query01()
//  {
//
//
//  }

    public static void main(String args[])
    {
        Connect con=new Connect();
        //new CreateFirstForm();

        
    }

}

class CreateFirstForm
{
    StringBuffer strQuery=new StringBuffer("select ");// to store prepared query
    StringBuffer orderbyBuffer=new StringBuffer(" ");
    StringBuffer criteriaBuffer=new StringBuffer(" ");
    int createQueryStatus=0;

    JFrame jf1;
    JLabel jl1,jl2,jl3,jl4,jl5;
    JComboBox jcom1,jcom2,jcom3;
    JTextField jtf1;
    JList jlist1,jlist2;
    JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jbtemp;
    JCheckBox jcb1;
    JRadioButton jrb1,jrb2,jrb3;
    JScrollPane jsp1,jsp2;
    ButtonGroup bg1;

    JFrame jf11;
    JButton jb11=new JButton("Add");
    JButton jb12=new JButton("OK");
    JButton jb13=new JButton("Cancel");
    JComboBox jcom11;
    JRadioButton jrb11=new JRadioButton("Ascending");
    JRadioButton jrb12=new JRadioButton("Descending");


    CreateFirstForm()
    {
        jf1=new JFrame("Query Builder");
        jf1.setSize(700,550);
        jf1.setLocation(50,30);
        jf1.setLayout(null);

        jl1=new JLabel("Table to be Queried ");
        jl1.setBounds(40,10,200,25);
        jf1.add(jl1);

        jcom1=new JComboBox(Connect.tableNames);
        jcom1.setBounds(40,40,200,25);
        jf1.add(jcom1);

        jb1=new JButton("Refresh");
        jb1.setBounds(300,40,100,25);
        jf1.add(jb1);

        jlist1=new JList();// add jlist to jscrollpane
        jsp1=new JScrollPane(jlist1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp1.setBounds(40,80,200,200);
        jf1.add(jsp1);

        jb2=new JButton("  >>  ");
        jb2.setBounds(280,120,135,25);
        jf1.add(jb2);

        jb3=new JButton("  <<  ");
        jb3.setBounds(280,160,135,25);
        jf1.add(jb3);

        jb4=new JButton("  <<<  ");
        jb4.setBounds(280,200,135,25);
        jf1.add(jb4);

        jcb1=new JCheckBox("Order By");
        jcb1.setBounds(300,250,135,30);       jf1.add(jcb1);

        jlist2=new JList();// add jlist to jscrollpane
        jsp2=new JScrollPane(jlist2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp2.setBounds(450,80,200,200);
        jf1.add(jsp2);

        jl2=new JLabel("Criteria ");              jl2.setBounds(40,350,200,25);    jf1.add(jl2);
        jl3=new JLabel("Fields        :");        jl3.setBounds(40,400,200,25);    jf1.add(jl3);
        jl4=new JLabel("Operators :");            jl4.setBounds(40,435,200,25);    jf1.add(jl4);
        jl5=new JLabel("Value         :");        jl5.setBounds(40,470,200,25);    jf1.add(jl5);

        jcom2=new JComboBox();  jcom2.addItem("---None---");
        jcom2.setBounds(150,400,200,25);
        jf1.add(jcom2);

        Vector temp=new Vector(0,1);          /* ****************************** */
        temp.add("---None---");
        temp.add("=");
        temp.add("!=");
        temp.add(">");
        temp.add(">=");
        temp.add("<");
        temp.add("<=");
        temp.add("like");
        temp.add("soundex");
        temp.add("between");
        temp.add("in");


        jcom3=new JComboBox(temp);
        jcom3.setBounds(150,435,200,25);
        jf1.add(jcom3);


        jtf1=new JTextField("Enter Value");
        jtf1.setBounds(150,470,200,25);
        jf1.add(jtf1);

        jrb1=new JRadioButton("AND");
        jrb1.setBounds(380,400,60,25);
        jf1.add(jrb1);

        jrb2=new JRadioButton("OR");
        jrb2.setBounds(380,435,60,25);
        jf1.add(jrb2);

        jrb3=new JRadioButton("None");
        jrb3.setBounds(380,470,60,25);
        jf1.add(jrb3);

        bg1=new ButtonGroup();
        bg1.add(jrb1);  bg1.add(jrb2);  bg1.add(jrb3);
        jrb3.setSelected(true);

        jb5=new JButton("Go");
        jb5.setBounds(580,410,100,25);
        jf1.add(jb5);

        jb6=new JButton("Query");
        jb6.setBounds(580,440,100,25);
        jf1.add(jb6);

        jb7=new JButton("Exit");
        jb7.setBounds(580,470,100,30);
        jf1.add(jb7);

        jbtemp=new JButton("OK");
        jbtemp.setBounds(470,1000,60,25);
        jf1.add(jbtemp);



        jf1.setVisible(true);

        QueryEvent qev=new QueryEvent(this);///////////////
        jb1.addActionListener(qev);
        jcom1.addActionListener(qev);
        jb2.addActionListener(qev);
        jb3.addActionListener(qev);
        jb4.addActionListener(qev);
        jb5.addActionListener(qev);
        jb6.addActionListener(qev);
        jb7.addActionListener(qev);

        jrb1.addActionListener(qev);
        jrb2.addActionListener(qev);
        jbtemp.addActionListener(qev);

        jcb1.addActionListener(qev);
    }
}



class QueryEvent implements ActionListener
{
    CreateFirstForm cff;
    QueryEvent(CreateFirstForm cff1)
    {
        cff=cff1;
    }
    public void actionPerformed(ActionEvent ae)
    {
        int numberOfColumns=0;

        if(ae.getSource()==cff.jb1 || ae.getSource()==cff.jcom1)
        {
            if (cff.jcom1.getSelectedItem() == null ||
                "---None---".equals(cff.jcom1.getSelectedItem().toString())) {
                Connect.columnNames.clear();
                Connect.fieldNames.clear();
                cff.jlist1.setListData(Connect.columnNames);
                cff.jlist2.setListData(Connect.fieldNames);
                return;
            }

            cff.orderbyBuffer=new StringBuffer(" ");
            cff.criteriaBuffer=new StringBuffer(" ");

            cff.jrb3.setSelected(true);
            cff.createQueryStatus=0;
            cff.strQuery=new StringBuffer("select ");

            Connect.fieldNames=new Vector(0,1);       // to blank jlist2
            cff.jlist2.setListData(Connect.fieldNames); //will set column names into jlist2


            try
            {
                String tableName = cff.jcom1.getSelectedItem().toString();
                String sql = "SELECT * FROM " + Connect.owner + "." + tableName + " WHERE 1=0";

                try (Connection c = Connect.getConnection();
                     Statement s = c.createStatement();
                     ResultSet rs = s.executeQuery(sql))
                {
                    ResultSetMetaData rsmd = rs.getMetaData();
                    numberOfColumns = rsmd.getColumnCount();

                    Connect.columnNames = new Vector(0,1);
                    for(int i=1; i<=numberOfColumns; i++)
                        Connect.columnNames.add(rsmd.getColumnName(i));

                    cff.jlist1.setListData(Connect.columnNames);
                }
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(cff.jf1,
                    "Could not read columns for the selected table.\\n" + e.getMessage(),
                    "Oracle SQL Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
                return;
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(cff.jf1, e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
                return;
            }


            /* */   cff.jf1.remove(cff.jcom2);  // refreshing jcom2
            /* */
            /* */   Vector temp=new Vector(0,1);    temp.add("---None---");
            /* */   for(int i=0;i<numberOfColumns;i++)
            /* */       temp.add(Connect.columnNames.elementAt(i));
            /* */
            /* */   cff.jcom2=new JComboBox(temp);
            /* */   cff.jcom2.setBounds(150,400,200,25);
            /* */   cff.jf1.add(cff.jcom2);



            cff.jcom2.showPopup();  cff.jcom2.hidePopup();
            cff.jcom3.setSelectedIndex(0);
        //  cff.jcom3.showPopup();  cff.jcom3.hidePopup();
            cff.jtf1.setText("Enter Value");



            cff.jf1.setVisible(true);
        }
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
        if(ae.getSource()==cff.jb2)
        {
            int sel[]=new int[10];
            for(int i=0;i<10;i++)
                sel[i]=0;

            int count=0;            // count stores no of elements in jlist1
            count=Connect.columnNames.size();

            for(int i=0;i<count;i++) // find which indices are selected in jlist1
                if(cff.jlist1.isSelectedIndex(i)==true)
                    sel[i]=1;

            for(int i=0;i<count;i++) // add selected indices of jlist1 to jlist2
                if(sel[i]==1)
                    if(Connect.fieldNames.contains(Connect.columnNames.elementAt(i))==false)
                        Connect.fieldNames.add(Connect.columnNames.elementAt(i));

          
            cff.jlist2.setListData(Connect.fieldNames); //will set column names into jlist2
            cff.jlist1.clearSelection();

            //System.out.println(" ~~ "+sel[0]+" "+sel[1]+" "+sel[2]+" "+sel[3]+" "+sel[4]+" "+sel[5]+" "+sel[6]+" "+sel[7]+" "+sel[8]+" "+sel[9]+" "+" ~~ ");
        }
        else
        {
            cff.jlist1.clearSelection();
        }
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
        if(ae.getSource()==cff.jb3)
        {
            int sel[]=new int[10];
            for(int i=0;i<10;i++)
                sel[i]=0;

            int count=0;            // count stores no of elements in jlist2
            count=Connect.fieldNames.size();
            System.out.println(" "+count);   // CHECK: some characters unreadable in photo

            for(int i=0;i<count;i++) // find which indices are selected in jlist2
                if(cff.jlist2.isSelectedIndex(i)==true)
                    sel[i]=1;

            for(int i=0;i<count;i++) // remove selected indices from jlist2
                if(sel[i]==1)
                    Connect.fieldNames.remove(i);

            cff.jlist2.setListData(Connect.fieldNames); //will set column names into jlist2
            //System.out.println(" ~~ "+sel[0]+" "+sel[1]+" "+sel[2]+" "+sel[3]+" "+sel[4]+" "+sel[5]+" "+sel[6]+" "+sel[7]+" "+sel[8]+" "+sel[9]+" "+" ~~ ");
        }
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
        if(ae.getSource()==cff.jb4)
        {
            Connect.fieldNames.removeAllElements();
            cff.jlist2.setListData(Connect.fieldNames); //will set column names into jlist2
        }
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
        if(ae.getSource()==cff.jb5)
        {
            new TableResult(cff.strQuery);
        }
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
        if(ae.getSource()==cff.jb6)
        {
            if(cff.createQueryStatus==0)
            {
                int count=Connect.fieldNames.size();

                for(int i=0;i<count;i++)// adding col names to query
                {
                    StringBuffer buf=new StringBuffer(Connect.fieldNames.elementAt(i).toString());
                    if(i<count-1)           cff.strQuery.append(buf.append(", "));
                    else                    cff.strQuery.append(buf);
                }
                if(cff.strQuery.toString().equals("select "))
                    cff.strQuery.append("*");
                cff.strQuery.append(" from " + Connect.owner + "." +
                    cff.jcom1.getSelectedItem());

            //  System.out.println(" $$"+cff.criteriaBuffer+"$$ ");
                if(cff.criteriaBuffer.toString().equals(" ")==true)
                {
                //  System.out.print("  &&&  ");
                    if(     (cff.jcom2.getSelectedItem().equals("---None---")==false)
                        &&  (cff.jcom3.getSelectedItem().equals("---None---")==false)
                        &&  (cff.jtf1.getText().equals("Enter Value")==false)        )/////////
                    {
                        cff.criteriaBuffer.append("where ");
                        cff.criteriaBuffer.append(cff.jcom2.getSelectedItem().toString() );
                        cff.criteriaBuffer.append(" "+cff.jcom3.getSelectedItem().toString()
                        );
                        cff.criteriaBuffer.append(" "+cff.jtf1.getText() );
                    }
                }



                cff.createQueryStatus=1;
            }
            else
            {


                //System.out.print(" @@@ ");
            }

            cff.strQuery.append(cff.criteriaBuffer);// now append criteria clause to Query
            cff.strQuery.append(cff.orderbyBuffer); // now append orderby  clause to Query
            cff.orderbyBuffer=new StringBuffer(" ");
            cff.criteriaBuffer=new StringBuffer(" ");



            System.out.println(cff.strQuery);
        //  cff.strQuery=new StringBuffer(" ");

        }
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
        if(ae.getSource()==cff.jb7)
        {
            System.exit(0);
        }
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
        if(ae.getSource()==cff.jrb1 || ae.getSource()==cff.jrb2)
        {
            if(cff.criteriaBuffer.toString().equals(" "))
            {
                cff.criteriaBuffer.append("where ");
                cff.criteriaBuffer.append(cff.jcom2.getSelectedItem().toString() );
                cff.criteriaBuffer.append(" "+cff.jcom3.getSelectedItem().toString() );
                cff.criteriaBuffer.append(" "+cff.jtf1.getText() );
            }
            System.out.println(cff.criteriaBuffer);
            cff.jbtemp.setBounds(450,400,60,25);
        }

////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
        if(ae.getSource()==cff.jbtemp)
        {

            //cff.criteriaBuffer.append("where ");
            //cff.criteriaBuffer.append(cff.jcom2.getSelectedItem().toString() );
            if(cff.jrb1.isSelected())
                cff.criteriaBuffer.append(" AND "+cff.jcom2.getSelectedItem().toString() );
                // adding table names to query
            else
                cff.criteriaBuffer.append(" OR "+cff.jcom2.getSelectedItem().toString() );
                // adding table names to query
            cff.criteriaBuffer.append(" "+cff.jcom3.getSelectedItem().toString() );
            cff.criteriaBuffer.append(" "+cff.jtf1.getText() );

            System.out.println(cff.criteriaBuffer);
            cff.jbtemp.setBounds(450,1000,60,25);
            cff.jrb3.setSelected(true);
            //cff.jf1.setVisible(true);

        }
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////


        if(ae.getSource()==cff.jcb1)
        {
            cff.jf11=new JFrame("Order By Options");
            cff.jf11.setSize(400,350);
            cff.jf11.setLocation(150,130);
            cff.jf11.setLayout(null);

            JLabel jl11=new JLabel("Order by");
            jl11.setBounds(20,10,100,25);
            cff.jf11.add(jl11);

            cff.jcom11=new JComboBox(Connect.columnNames);
            cff.jcom11.insertItemAt("---None---",0);
            cff.jcom11.setSelectedIndex(0);
            cff.jcom11.setBounds(150,40,200,25);
            cff.jf11.add(cff.jcom11);


            cff.jrb11.setBounds(100,150,100,25);        cff.jf11.add(cff.jrb11);
            cff.jrb12.setBounds(220,150,100,25);        cff.jf11.add(cff.jrb12);

            ButtonGroup bg2=new ButtonGroup();
            bg2.add(cff.jrb11);
            bg2.add(cff.jrb12);
            cff.jrb11.setSelected(true);

            cff.jb11.setBounds(150,200,100,25);
            cff.jf11.add(cff.jb11);

            cff.jb12.setBounds(150,240,100,25);
            cff.jf11.add(cff.jb12);

            cff.jb13.setBounds(150,280,100,25);
            cff.jf11.add(cff.jb13);



            cff.jf11.setVisible(true);

            cff.jb11.addActionListener(this);
            cff.jb12.addActionListener(this);
            cff.jb13.addActionListener(this);

            cff.orderbyBuffer=new StringBuffer(" ");
            cff.orderbyBuffer.append("order by ");
        }
////////////////////////////////////////////////////////////////////////////////
        if(ae.getSource()==cff.jb11)
        {
            if(cff.jcom11.getSelectedItem().toString().equals("---None---")==false)
            {
                if(cff.orderbyBuffer.toString().equals(" order by ") == false )
                    cff.orderbyBuffer.append(", ");

                cff.orderbyBuffer.append(cff.jcom11.getSelectedItem().toString());
                if(cff.jrb11.isSelected())
                    cff.orderbyBuffer.append(" asc ");
                else
                    cff.orderbyBuffer.append(" desc ");
            }

            cff.jcom11.setSelectedIndex(0);
            System.out.println(cff.orderbyBuffer);
        }
        if(ae.getSource()==cff.jb12)
        {
            if(cff.orderbyBuffer.toString().equals(" order by ") == true )
                cff.orderbyBuffer=new StringBuffer(" ");
            cff.jf11.dispose();
        }
        if(ae.getSource()==cff.jb13)
        {
            cff.orderbyBuffer=new StringBuffer(" ");
            cff.jf11.dispose();
        }
    }
}



class TableResult
{

    Vector rowDataTemp=new Vector(0,1);
    Vector rowDataMain=new Vector(0,1);
    Vector columnNames=new Vector(0,1);



    Connection c;
    Statement s;
    ResultSet rs;
    ResultSetMetaData rsmd;

    TableResult(StringBuffer sb)
    {
        try
        {
                c=Connect.getConnection();
                s=c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);


                String str=sb.toString();
                rs=s.executeQuery(str);
                rsmd = rs.getMetaData();

        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                "Oracle SQL Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        createForm();
        if (rs != null && rsmd != null)
            showTable();

    }

    JFrame jf;
    JButton jb1,jb2;
    JScrollPane jsp;
    JTable jt;
    void createForm()
    {
        jf=new JFrame("Display Table Data");
        jf.setSize(500,400);
        jf.setLayout(null);



        jb1=new JButton("Back");
        jb1.setBounds(100,80,150,30);
        jf.add(jb1);

        jb2=new JButton("Exit");
        jb2.setBounds(300,80,100,30);
        jf.add(jb2);

        jt=new JTable(5,3);
//      jt.setBounds(0,0,500,500);
//      jt.doLayout();

        jsp=new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.setBounds(50,150,400,200);
        jf.add(jsp);

        jf.setVisible(true);

        TableEvent tabev=new TableEvent(this);
        jb1.addActionListener(tabev);
        jb2.addActionListener(tabev);
    }

    void showTable()
    {
        try
        {
                int numberOfColumns = rsmd.getColumnCount();

                int numberOfRows=0;

                columnNames.removeAllElements();
                for(int i=1;i<=numberOfColumns;i++)
                {
                    columnNames.add(rsmd.getColumnName(i));
                }

                int j=0;
                rowDataMain=new Vector(0,1);

                rs.beforeFirst();
                while(rs.next())
                {
                    numberOfRows+=1;
                    rowDataTemp=new Vector(0,1);

                    for(int i=1;i<=numberOfColumns;i++)
                    {
                        rowDataTemp.add(rs.getString(i));
                    }

                    rowDataMain.add(rowDataTemp);


                //  System.out.print(tdb.rowDataTemp+" @@ "+tdb.rowDataTemp.size()+" "+tdb.rowDataTemp.capacity());
                //  System.out.println(" ~~ "+tdb.rowDataMain+" ~~ "+tdb.rowDataMain.size()+"  "+tdb.rowDataMain.capacity());

                }
        }
        catch(SQLException e)   {   System.out.println(" TableResult Table does not Exist");}
        catch(Exception e)      {   System.out.println(" TableResult Simple Exception");     }

        jf.remove(jsp);
        jt=new JTable(rowDataMain,columnNames);
        jsp=new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.setBounds(50,150,400,200);
        jf.add(jsp);
    }

}

class TableEvent implements ActionListener
{
    TableResult tr;
    TableEvent(TableResult trl)
    {
        tr=trl;
    }
    public void actionPerformed(ActionEvent ae)
    {

        if(ae.getSource()==tr.jb1)
        {
            tr.jf.dispose();

        }

        if(ae.getSource()==tr.jb2)
        {
            System.exit(0);
        }
    }
}





class Connect
{
    static Vector tableNames = new Vector(0,1);
    static Vector columnNames = new Vector(0,1);
    static Vector fieldNames = new Vector(0,1);

    // Oracle XE 10g Type 4 JDBC settings.
    static String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
    static String username = "system";
    static String password = "";
    static String owner = "SYSTEM";

    JFrame jf;
    JLabel jl1, jl2, jl3;
    JTextField urlField, userField;
    JPasswordField passwordField;
    JButton connectButton, exitButton;

    Connect()
    {
        jf = new JFrame("Oracle JDBC Connection");
        jf.setSize(520, 250);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jl1 = new JLabel("JDBC URL:");
        jl1.setBounds(25, 25, 110, 25);
        jf.add(jl1);

        urlField = new JTextField(jdbcUrl);
        urlField.setBounds(140, 25, 340, 25);
        jf.add(urlField);

        jl2 = new JLabel("Username:");
        jl2.setBounds(25, 65, 110, 25);
        jf.add(jl2);

        userField = new JTextField(username);
        userField.setBounds(140, 65, 200, 25);
        jf.add(userField);

        jl3 = new JLabel("Password:");
        jl3.setBounds(25, 105, 110, 25);
        jf.add(jl3);

        passwordField = new JPasswordField();
        passwordField.setBounds(140, 105, 200, 25);
        jf.add(passwordField);

        connectButton = new JButton("Connect");
        connectButton.setBounds(140, 155, 110, 30);
        jf.add(connectButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(270, 155, 100, 30);
        jf.add(exitButton);

        ConnectEvent event = new ConnectEvent(this);
        connectButton.addActionListener(event);
        exitButton.addActionListener(event);
        jf.setVisible(true);
    }

    static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(jdbcUrl, username, password);
    }

    public void connectOracle()
    {
        try
        {
            jdbcUrl = urlField.getText().trim();
            username = userField.getText().trim();
            password = new String(passwordField.getPassword());

            if (jdbcUrl.isEmpty() || username.isEmpty())
                throw new SQLException("JDBC URL and username are required.");

            owner = username.toUpperCase(Locale.ROOT);
            Class.forName("oracle.jdbc.OracleDriver");

            tableNames.clear();
            columnNames.clear();
            fieldNames.clear();

            try (Connection c = getConnection())
            {
                DatabaseMetaData dbmd = c.getMetaData();

                // Only list tables owned by the connected Oracle user.
                try (ResultSet rs = dbmd.getTables(null, owner, "%",
                        new String[]{"TABLE"}))
                {
                    tableNames.add("---None---");
                    while (rs.next())
                    {
                        String table = rs.getString("TABLE_NAME");
                        if (table != null && !tableNames.contains(table))
                            tableNames.add(table);
                    }
                }

                System.out.println("Connected to: " + c.getMetaData().getDatabaseProductName());
                System.out.println("Schema: " + owner);
                System.out.println("Tables: " + tableNames);
            }

            jf.dispose();
            new CreateFirstForm();
        }
        catch (ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(jf,
                "Oracle JDBC driver not found. Add the ojdbc JAR to your classpath.",
                "Driver Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(jf,
                "Oracle connection/table-list error:\\n" + e.getMessage(),
                "Connection Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}

class ConnectEvent implements ActionListener
{
    Connect con;

    ConnectEvent(Connect con1)
    {
        con = con1;
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == con.connectButton)
            con.connectOracle();

        if (ae.getSource() == con.exitButton)
            System.exit(0);
    }
}
