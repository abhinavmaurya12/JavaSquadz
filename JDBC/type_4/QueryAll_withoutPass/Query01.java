import java.sql.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;


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

    // wrap text values in single quotes (numbers and already-quoted values are left alone)
    static String quote(String v)
    {
        v=v.trim();
        if(v.startsWith("'") || v.startsWith("\""))   return v;
        if(v.matches("-?\\d+(\\.\\d+)?"))            return v;
        return "'"+v.replace("'","''")+"'";
    }

    // builds one condition, e.g.  name = 'abhi'
    static String cond(String col,String op,String val)
    {
        val=val.trim();
        if(op.equals("between") || op.equals("in"))     // user types: 1 and 5   /   (1,2,3)
            return col+" "+op+" "+val;
        if(op.equals("soundex"))
            return "soundex("+col+") = soundex("+quote(val)+")";
        return col+" "+op+" "+quote(val);
    }
    // current Fields/Operators/Value boxes as one condition, or null if not filled in
    String currentCond()
    {
        Object f=cff.jcom2.getSelectedItem();
        Object o=cff.jcom3.getSelectedItem();
        String v=cff.jtf1.getText();
        if(f==null || o==null)                                  return null;
        if(f.equals("---None---") || o.equals("---None---"))    return null;
        if(v.trim().length()==0 || v.equals("Enter Value"))     return null;
        return cond(f.toString(),o.toString(),v);
    }

    // builds the whole query from scratch every time (no leftovers from earlier clicks)
    boolean buildQuery()
    {
        Object table=cff.jcom1.getSelectedItem();
        if(table==null || table.equals("---None---"))
        {
            JOptionPane.showMessageDialog(cff.jf1,"Select a table and press Refresh first.");
            return false;
        }

        StringBuffer q=new StringBuffer("select ");
        int count=(Connect.fieldNames==null) ? 0 : Connect.fieldNames.size();
        for(int i=0;i<count;i++)
        {
            q.append(Connect.fieldNames.elementAt(i));
            if(i<count-1)   q.append(", ");
        }
        if(count==0)        q.append("*");
        q.append(" from ").append(table);

        String where=cff.criteriaBuffer.toString().trim();      // built by AND / OR + OK
        if(where.length()==0)                                   // single condition from the boxes
        {
            String c=currentCond();
            if(c!=null)     where="where "+c;
        }
        if(where.length()>0)    q.append(" ").append(where);

        String ob=cff.orderbyBuffer.toString().trim();
        if(ob.length()>0 && !ob.equals("order by"))
            q.append(" ").append(ob);

        cff.strQuery=q;
        return true;
    }

    public void actionPerformed(ActionEvent ae)
    {
        int numberOfColumns=0;

        if(ae.getSource()==cff.jb1)
        {
            cff.orderbyBuffer=new StringBuffer(" ");
            cff.criteriaBuffer=new StringBuffer(" ");

            cff.jrb3.setSelected(true);
            cff.createQueryStatus=0;
            cff.strQuery=new StringBuffer("select ");

            Connect.fieldNames=new Vector(0,1);       // to blank jlist2
            cff.jlist2.setListData(Connect.fieldNames); //will set column names into jlist2


            try
            {

                Connection c=Connect.getConn();
                Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

                // now find column names
                String str=cff.jcom1.getSelectedItem().toString();
                ResultSet rs=s.executeQuery("select * from "+str);


                ResultSetMetaData rsmd = rs.getMetaData();
                numberOfColumns = rsmd.getColumnCount();

                Connect.columnNames=new Vector(0,1);
                for(int i=1;i<=numberOfColumns;i++)
                {
                    Connect.columnNames.add(rsmd.getColumnName(i));
                }
                //System.out.println(Connect.columnNames+"    "+numberOfColumns);
                cff.jlist1.setListData(Connect.columnNames); //will set column names into list

            }
            catch(SQLException e)   {   System.out.println(" Query Event Table does not Exist");    }
            catch(Exception e)      {   System.out.println(" Query Event Simple Exception");        }


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
            int count=Connect.columnNames.size();   // count stores no of elements in jlist1
            int sel[]=new int[count];

            for(int i=0;i<count;i++) // find which indices are selected in jlist1
                if(cff.jlist1.isSelectedIndex(i)==true)
                    sel[i]=1;

            for(int i=0;i<count;i++) // add selected indices of jlist1 to jlist2
                if(sel[i]==1)
                    if(Connect.fieldNames.contains(Connect.columnNames.elementAt(i))==false)
                        Connect.fieldNames.add(Connect.columnNames.elementAt(i));

            // (the 'else' below belongs to if(ae.getSource()==cff.jb2))
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
            int count=Connect.fieldNames.size();    // count stores no of elements in jlist2
            int sel[]=new int[count];

            for(int i=0;i<count;i++) // find which indices are selected in jlist2
                if(cff.jlist2.isSelectedIndex(i)==true)
                    sel[i]=1;

            for(int i=count-1;i>=0;i--) // remove selected indices (from the end so indices don't shift)
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
        if(ae.getSource()==cff.jb5)             // Go: always rebuild, then run
        {
            if(buildQuery())
                new TableResult(cff.strQuery);
        }
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
        if(ae.getSource()==cff.jb6)             // Query: rebuild and print
        {
            if(buildQuery())
                System.out.println(cff.strQuery);
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
            if(cff.criteriaBuffer.toString().trim().length()==0)
            {
                String c=currentCond();
                if(c==null)
                {
                    JOptionPane.showMessageDialog(cff.jf1,"Select a field and an operator and enter a value first.");
                    cff.jrb3.setSelected(true);
                    return;
                }
                cff.criteriaBuffer=new StringBuffer("where "+c);
            }
            System.out.println(cff.criteriaBuffer);
            cff.jbtemp.setBounds(450,400,60,25);
        }

////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
        if(ae.getSource()==cff.jbtemp)
        {
            String c=currentCond();
            if(c==null)
            {
                JOptionPane.showMessageDialog(cff.jf1,"Select a field and an operator and enter a value first.");
                return;
            }
            cff.criteriaBuffer.append(cff.jrb1.isSelected() ? " AND " : " OR ");
            cff.criteriaBuffer.append(c);

            System.out.println(cff.criteriaBuffer);
            cff.jbtemp.setBounds(450,1000,60,25);
            cff.jrb3.setSelected(true);
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
                c=Connect.getConn();
                s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);


                String str=sb.toString();
                rs=s.executeQuery(str);
                rsmd = rs.getMetaData();

        }
        catch(SQLException e)
        {
            System.out.println(" TableResult SQL Error: "+e.getMessage());
            JOptionPane.showMessageDialog(null,"Query failed:\n"+e.getMessage()+"\n\nSQL: "+sb);
            return;                     // nothing to show
        }
        catch(Exception e)
        {
            System.out.println(" TableResult Error: "+e);
            return;
        }

        createForm();
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
    static Vector tableNames=new Vector(0,1);
    static Vector columnNames=new Vector(0,1);
    static Vector fieldNames=new Vector(0,1);
    static Vector dbList=new Vector(0,1);       // databases / schemas shown in chooser

    static String dsnName="";   // JDBC url (for ODBC: jdbc:odbc:<dsn>)
    static String dbUser="";
    static String dbPass="";
    static int dbType=0;        // 0=ODBC DSN, 1=MySQL, 2=Oracle, 3=PostgreSQL
    static String host="",port="",oracleSchema="";

    // ---- saved login details, read from db.properties (same folder as the program) ----
    static Properties props=new Properties();
    static String keyPrefix[]={"odbc","mysql","oracle","postgres"};
    static String dbKey[]={"dsn","database","sid","database"};   // name of the "Database" key per type

    static
    {
        try
        {
            FileInputStream fis=new FileInputStream("db.properties");
            props.load(fis);
            fis.close();
        }
        catch(IOException e)
        {
            // no db.properties file -> fields just use the normal defaults
        }
    }

    // every part of the program gets its connection from here
    static Connection getConn() throws SQLException
    {
        Connection c;
        if(dbType==0)
            c=DriverManager.getConnection(dsnName);
        else
            c=DriverManager.getConnection(dsnName,dbUser,dbPass);

        if(dbType==2 && oracleSchema.length()>0)    // Oracle: work inside chosen schema
        {
            Statement st=c.createStatement();
            st.execute("ALTER SESSION SET CURRENT_SCHEMA=\""+oracleSchema+"\"");
            st.close();
        }
        return c;
    }

    String types[]={"select database","MySQL","Oracle","PostgreSQL"};
    String labels[]={"Host :","Port :","Database :","User :","Password :"};
    String dbLabel[]={"DSN Name :","Database :","SID / Service :","Database :"};
    // default values for: host, port, database, user (one row per type)
    String defs[][]={
        {"",          "",     "dsn1",     ""},
        {"localhost", "3305", "test",     "root"},
        {"localhost", "1521", "xe",       "system"},
        {"localhost", "5432", "postgres", "postgres"}
    };

    JFrame jf;
    JLabel jlType;
    JComboBox jcomType;
    JLabel jl[]=new JLabel[labels.length];
    JTextField jtf[]=new JTextField[labels.length];
    JButton jb01,jb02;

    Connect()
    {
        int n=labels.length;
        int by=55+n*35+10;                      // y position of the buttons

        jf=new JFrame("Connection Builder");
        jf.setSize(400,by+80);
        jf.setLocation(300,250);
        jf.setLayout(null);

        jlType=new JLabel("Database Type :");
        jlType.setBounds(20,20,120,25);
        jf.add(jlType);

        jcomType=new JComboBox(types);
        jcomType.setBounds(150,20,200,25);
        jf.add(jcomType);

        for(int i=0;i<n;i++)
        {
            jl[i]=new JLabel(labels[i]);
            jl[i].setBounds(20,55+i*35,120,25);
            jf.add(jl[i]);

            if(i==n-1)
                jtf[i]=new JPasswordField();
            else
                jtf[i]=new JTextField();
            jtf[i].setBounds(150,55+i*35,200,25);
            jf.add(jtf[i]);
        }

        jb01=new JButton("OK");
        jb01.setBounds(50,by,100,25);
        jf.add(jb01);

        jb02=new JButton("Exit");
        jb02.setBounds(180,by,100,25);
        jf.add(jb02);

        applyType();                            // fill defaults for first type

        jf.setVisible(true);

        ConnectEvent conev=new ConnectEvent(this);
        jcomType.addActionListener(conev);
        jb01.addActionListener(conev);
        jb02.addActionListener(conev);
    }

    // called when the database type is changed
    void applyType()
    {
        int t=jcomType.getSelectedIndex();
        for(int i=0;i<4;i++)
            jtf[i].setText(defs[t][i]);
        jtf[4].setText("");

        // override defaults with values saved in db.properties (if present)
        String p=keyPrefix[t]+".";
        jtf[0].setText(props.getProperty(p+"host",defs[t][0]));
        jtf[1].setText(props.getProperty(p+"port",defs[t][1]));
        jtf[2].setText(props.getProperty(p+dbKey[t],defs[t][2]));
        jtf[3].setText(props.getProperty(p+"user",defs[t][3]));
        jtf[4].setText(props.getProperty(p+"password",""));

        jl[2].setText(dbLabel[t]);

        boolean on=(t!=0);                      // ODBC DSN needs only the DSN name
        jtf[0].setEnabled(on);
        jtf[1].setEnabled(on);
        jtf[3].setEnabled(on);
        jtf[4].setEnabled(on);
    }

    String val(int i)
    {
        return jtf[i].getText().trim();
    }

    // Step 1: connect to the server. ODBC -> loads tables directly.
    //         MySQL/Oracle/PostgreSQL -> loads list of databases for the chooser.
    public boolean connectDB()
    {
        try
        {
            int t=jcomType.getSelectedIndex();
            dbType=t;
            oracleSchema="";
            String driver="";

            if(t==0)                            // ODBC DSN
            {
                dsnName="jdbc:odbc:"+val(2);
                dbUser="";
                dbPass="";
                driver="sun.jdbc.odbc.JdbcOdbcDriver";
            }
            else
            {
                host=val(0);
                port=val(1);
                dbUser=val(3);
                dbPass=new String(((JPasswordField)jtf[4]).getPassword());

                if(t==1)                        // MySQL (no database -> server level)
                {
                    dsnName="jdbc:mysql://"+host+":"+port+"/";
                    driver="com.mysql.cj.jdbc.Driver";
                }
                else if(t==2)                   // Oracle
                {
                    dsnName="jdbc:oracle:thin:@"+host+":"+port+":"+val(2);
                    driver="oracle.jdbc.OracleDriver";
                }
                else                            // PostgreSQL (connect to given db to list others)
                {
                    String first=val(2).length()>0 ? val(2) : "postgres";
                    dsnName="jdbc:postgresql://"+host+":"+port+"/"+first;
                    driver="org.postgresql.Driver";
                }
            }

            Class.forName(driver);
            Connection c=getConn();

            if(t==0)
            {
                loadTables(c,null,null);
            }
            else
            {
                dbList=new Vector(0,1);
                if(t==1)                        // MySQL: all databases
                {
                    ResultSet rs=c.getMetaData().getCatalogs();
                    while(rs.next())
                        dbList.add(rs.getString(1));
                    rs.close();
                }
                else
                {
                    Statement st=c.createStatement();
                    ResultSet rs;
                    if(t==2)                    // Oracle: schemas (users)
                        rs=st.executeQuery("select username from all_users order by username");
                    else                        // PostgreSQL: databases
                        rs=st.executeQuery("select datname from pg_database where datistemplate=false order by datname");
                    while(rs.next())
                        dbList.add(rs.getString(1));
                    rs.close();
                    st.close();
                }
            }
            c.close();
            return true;
        }
        catch(ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(jf,"JDBC driver not found: "+e.getMessage()+"\nAdd the driver jar to the classpath.");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(jf,"Connection failed: "+e.getMessage());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(jf,"Error: "+e);
        }
        return false;
    }

    // Step 2: user picked a database/schema in the chooser -> load its tables
    static boolean openDatabase(String name,JFrame parent)
    {
        try
        {
            String cat=null,schema=null;
            if(dbType==1)
            {
                dsnName="jdbc:mysql://"+host+":"+port+"/"+name;
                cat=name;
            }
            else if(dbType==2)
            {
                oracleSchema=name;
                schema=name;
            }
            else if(dbType==3)
            {
                dsnName="jdbc:postgresql://"+host+":"+port+"/"+name;
                schema="public";
            }
            Connection c=getConn();
            loadTables(c,cat,schema);
            c.close();
            return true;
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(parent,"Cannot open '"+name+"': "+e.getMessage());
        }
        return false;
    }

    static void loadTables(Connection c,String cat,String schema) throws SQLException
    {
        DatabaseMetaData dbmd=c.getMetaData();
        ResultSet rs=dbmd.getTables(cat,schema,null,new String[]{"TABLE"});
        tableNames=new Vector(0,1);
        tableNames.add("---None---");
        while(rs.next())
            tableNames.add(rs.getString(3));
        rs.close();
        System.out.println(tableNames);
    }
}

class ConnectEvent implements ActionListener
{
    Connect con;
    ConnectEvent(Connect con1)
    {
        con=con1;
    }
    public void actionPerformed(ActionEvent ae)
    {
        boolean auto=false;
        if(ae.getSource()==con.jcomType)
        {
            con.applyType();
            // MySQL / Oracle / PostgreSQL with a saved password -> connect and show all databases at once
            if(con.jcomType.getSelectedIndex()!=0 && con.jtf[4].getText().length()>0)
                auto=true;
        }
        if(ae.getSource()==con.jb01 || auto)
        {
            if(con.connectDB())
            {
                if(Connect.dbType==0)           // ODBC: straight to query builder
                {
                    con.jf.dispose();
                    new CreateFirstForm();
                }
                else                            // others: show databases first
                {
                    con.jf.setVisible(false);
                    new DatabaseChooser(con);
                }
            }
        }
        if(ae.getSource()==con.jb02)
        {
            System.exit(0);
        }
    }
}

// ---------- shows databases of the selected server before Query Builder ----------
class DatabaseChooser
{
    Connect con;
    JFrame jf;
    JLabel jl;
    JList jlist;
    JScrollPane jsp;
    JButton jbOpen,jbBack,jbExit;

    DatabaseChooser(Connect c)
    {
        con=c;
        String what=(Connect.dbType==2) ? "Schemas" : "Databases";

        jf=new JFrame("Select Database");
        jf.setSize(400,420);
        jf.setLocation(300,200);
        jf.setLayout(null);

        jl=new JLabel("Available "+what+" on "+con.types[Connect.dbType]+" ("+Connect.host+")");
        jl.setBounds(20,10,350,25);
        jf.add(jl);

        jlist=new JList(Connect.dbList);
        jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jsp=new JScrollPane(jlist,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.setBounds(20,45,345,250);
        jf.add(jsp);

        jbOpen=new JButton("Open");
        jbOpen.setBounds(20,320,100,28);
        jf.add(jbOpen);

        jbBack=new JButton("Back");
        jbBack.setBounds(140,320,100,28);
        jf.add(jbBack);

        jbExit=new JButton("Exit");
        jbExit.setBounds(260,320,100,28);
        jf.add(jbExit);

        jf.setVisible(true);

        DatabaseEvent dev=new DatabaseEvent(this);
        jbOpen.addActionListener(dev);
        jbBack.addActionListener(dev);
        jbExit.addActionListener(dev);
    }
}

class DatabaseEvent implements ActionListener
{
    DatabaseChooser dc;
    DatabaseEvent(DatabaseChooser d)
    {
        dc=d;
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==dc.jbOpen)
        {
            Object sel=dc.jlist.getSelectedValue();
            if(sel==null)
            {
                JOptionPane.showMessageDialog(dc.jf,"Please select a database first.");
                return;
            }
            if(Connect.openDatabase(sel.toString(),dc.jf))
            {
                dc.jf.dispose();
                dc.con.jf.dispose();
                new CreateFirstForm();          // query tab opens only now
            }
        }
        if(ae.getSource()==dc.jbBack)
        {
            dc.jf.dispose();
            dc.con.jf.setVisible(true);         // back to connection form
        }
        if(ae.getSource()==dc.jbExit)
        {
            System.exit(0);
        }
    }
}
