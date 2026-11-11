import java.sql.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.text.JTextComponent;


class Query01_mysql
{
//  Query01()
//  {
//
//
//  }

    public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable(){ public void run(){ new Connect(); } });
    }

}

class CreateFirstForm
{
    StringBuffer strQuery=new StringBuffer("select ");// to store prepared query
    StringBuffer orderbyBuffer=new StringBuffer(" ");
    StringBuffer criteriaBuffer=new StringBuffer(" ");
    int createQueryStatus=0;

    JFrame jf1;
    JLabel jl1,jl2,jl3,jl4,jl5,jldb;
    JComboBox jcom1,jcom2,jcom3,jcomdb;
    JComboBox jtf1;                         // editable combo: shows the values of the selected field
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

    boolean loading=false;                  // true while combo boxes are being refilled
    String currentDb="";                    // label ("db1 - name") of the open database


    CreateFirstForm()
    {
        currentDb=Connect.currentLabel;

        jf1=new JFrame("MySQL Query Builder - "+Connect.realName(currentDb));
        jf1.setSize(700,550);
        jf1.setLocation(50,30);
        jf1.setLayout(null);
        jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jldb=new JLabel("MySQL Database:");
        jldb.setBounds(40,10,120,25);
        jf1.add(jldb);

        jcomdb=new JComboBox(Connect.dbLabels);
        jcomdb.setSelectedItem(currentDb);
        jcomdb.setBounds(150,10,200,25);
        jf1.add(jcomdb);

        jl1=new JLabel("Table to be Queried");
        jl1.setBounds(40,45,200,25);
        jf1.add(jl1);

        jcom1=new JComboBox();
        jcom1.setBounds(40,70,200,25);
        jf1.add(jcom1);

        jb1=new JButton("Refresh");
        jb1.setBounds(300,70,100,25);
        jf1.add(jb1);

        jlist1=new JList();// add jlist to jscrollpane
        jsp1=new JScrollPane(jlist1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp1.setBounds(40,110,200,200);
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
        jsp2.setBounds(450,110,200,200);
        jf1.add(jsp2);

        jl2=new JLabel("Criteria:");              jl2.setBounds(40,350,200,25);    jf1.add(jl2);
        jl3=new JLabel("Fields:");                jl3.setBounds(40,400,200,25);    jf1.add(jl3);
        jl4=new JLabel("Operators:");             jl4.setBounds(40,435,200,25);    jf1.add(jl4);
        jl5=new JLabel("Value:");                 jl5.setBounds(40,470,200,25);    jf1.add(jl5);

        jcom2=new JComboBox();  jcom2.addItem("---None---");
        jcom2.setBounds(150,400,200,25);
        jf1.add(jcom2);

        Vector temp=new Vector(0,1);
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

        jtf1=new JComboBox();
        jtf1.setEditable(true);
        jtf1.addItem("Select Value");
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

        // table selected -> its columns load automatically
        jcom1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ if(!loading) loadColumns(); }
        });
        // field selected -> its values load into the value box
        jcom2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ if(!loading) loadFieldValues(); }
        });
        // another database selected -> its tables load
        jcomdb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(loading) return;
                Object o=jcomdb.getSelectedItem();
                if(o==null || o.toString().equals(currentDb)) return;
                if(Connect.openDatabase(Connect.realName(o.toString()),jf1))
                {
                    currentDb=o.toString();
                    jf1.setTitle("MySQL Query Builder - "+Connect.realName(currentDb));
                    fillTables();
                }
                else
                {
                    loading=true;  jcomdb.setSelectedItem(currentDb);  loading=false;   // go back to the old one
                }
            }
        });

        jf1.setVisible(true);

        // let the window paint first, then load tables and columns
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){ fillTables(); }
        });
    }

    // puts Connect.tableNames into the table combo and opens the first table
    void fillTables()
    {
        loading=true;
        jcom1.removeAllItems();
        for(int i=0;i<Connect.tableNames.size();i++)
            jcom1.addItem(Connect.tableNames.elementAt(i));
        loading=false;

        if(jcom1.getItemCount()>1)
            jcom1.setSelectedIndex(1);          // fires loadColumns()
        else
            clearColumns();
    }

    void clearColumns()
    {
        Connect.columnNames=new Vector(0,1);
        Connect.fieldNames=new Vector(0,1);
        jlist1.setListData(Connect.columnNames);
        jlist2.setListData(Connect.fieldNames);
        loading=true;
        jcom2.removeAllItems();  jcom2.addItem("---None---");
        jtf1.removeAllItems();   jtf1.addItem("Select Value");
        loading=false;
    }

    // same work the old Refresh button did: read column names of the selected table
    void loadColumns()
    {
        orderbyBuffer=new StringBuffer(" ");
        criteriaBuffer=new StringBuffer(" ");

        jrb3.setSelected(true);
        createQueryStatus=0;
        strQuery=new StringBuffer("select ");

        String str=jcom1.getSelectedItem()==null ? "---None---" : jcom1.getSelectedItem().toString();
        if(str.equals("---None---"))
        {
            clearColumns();
            return;
        }

        Connect.fieldNames=new Vector(0,1);       // to blank jlist2
        jlist2.setListData(Connect.fieldNames);

        int numberOfColumns=0;
        try
        {
            Connection c=Connect.getConn();
            Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

            ResultSet rs=s.executeQuery("select * from "+str);

            ResultSetMetaData rsmd = rs.getMetaData();
            numberOfColumns = rsmd.getColumnCount();

            Connect.columnNames=new Vector(0,1);
            for(int i=1;i<=numberOfColumns;i++)
            {
                Connect.columnNames.add(rsmd.getColumnName(i));
            }
            jlist1.setListData(Connect.columnNames); //will set column names into list
        }
        catch(SQLException e)   {   System.out.println(" Query Event SQL error : "+e.getMessage());    }
        catch(Exception e)      {   System.out.println(" Query Event error : "+e);        }

        loading=true;
        jcom2.removeAllItems();                     // refreshing jcom2
        jcom2.addItem("---None---");
        for(int i=0;i<numberOfColumns;i++)
            jcom2.addItem(Connect.columnNames.elementAt(i));
        jtf1.removeAllItems();
        jtf1.addItem("Select Value");
        loading=false;

        jcom3.setSelectedIndex(0);
    }

    // fills the value box with the distinct values of the selected field
    void loadFieldValues()
    {
        loading=true;
        jtf1.removeAllItems();
        jtf1.addItem("Select Value");
        loading=false;

        Object t=jcom1.getSelectedItem();
        Object f=jcom2.getSelectedItem();
        if(t==null || f==null || t.toString().equals("---None---") || f.toString().equals("---None---"))
            return;

        try
        {
            Connection c=Connect.getConn();
            Statement s=c.createStatement();
            ResultSet rs=s.executeQuery("select distinct "+f+" from "+t+" order by "+f+" limit 1000");
            while(rs.next())
            {
                Object v=rs.getObject(1);
                if(v!=null)
                    jtf1.addItem(v.toString());
            }
            rs.close();
            s.close();
            c.close();
        }
        catch(SQLException e)   {   System.out.println(" Value load SQL error : "+e.getMessage());    }
    }

    // text currently in the value box (typed or selected)
    String valueText()
    {
        Object o=jtf1.getEditor().getItem();
        if(o==null)
            o=jtf1.getSelectedItem();
        return o==null ? "" : o.toString().trim();
    }
}



class QueryEvent implements ActionListener
{
    CreateFirstForm cff;
    QueryEvent(CreateFirstForm cff1)
    {
        cff=cff1;
    }

    // builds "field op value" from the Criteria part of the form (value is quoted properly)
    // returns null if field / operator / value is not filled in
    String formCondition()
    {
        String field=cff.jcom2.getSelectedItem().toString();
        String op=cff.jcom3.getSelectedItem().toString();
        String val=cff.valueText();

        if(field.equals("---None---") || op.equals("---None---") || val.length()==0 || val.equals("Enter Value") || val.equals("Select Value"))
            return null;
        return Connect.condition(field,op,val);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==cff.jb1)
        {
            cff.loadColumns();
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
        }
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
        if(ae.getSource()==cff.jb3)
        {
            int count=Connect.fieldNames.size();    // count stores no of elements in jlist2

            for(int i=count-1;i>=0;i--) // remove selected indices from the end (indices do not shift)
                if(cff.jlist2.isSelectedIndex(i))
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
            if(cff.strQuery.indexOf(" from ")<0)
            {
                JOptionPane.showMessageDialog(cff.jf1,"Press the 'Query' button first to build the query.");
                return;
            }
            new TableResult(cff.strQuery);
        }
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
        if(ae.getSource()==cff.jb6)
        {
            String table=cff.jcom1.getSelectedItem().toString();
            if(table.equals("---None---"))
            {
                JOptionPane.showMessageDialog(cff.jf1,"Please select a table first.");
                return;
            }

            // build the query from scratch every time (old code kept appending to the previous query)
            StringBuffer q=new StringBuffer("select ");
            int count=Connect.fieldNames.size();
            for(int i=0;i<count;i++)// adding col names to query
            {
                q.append(Connect.fieldNames.elementAt(i).toString());
                if(i<count-1)   q.append(", ");
            }
            if(count==0)
                q.append("*");
            q.append(" from "+table);// adding table name to query

            // criteria: use what AND/OR built, otherwise the single condition in the form
            String criteria=cff.criteriaBuffer.toString().trim();
            if(criteria.length()==0)
            {
                String cond=formCondition();
                if(cond!=null)
                    criteria="where "+cond;
            }

            q.append(" ").append(criteria);                         // criteria clause
            q.append(" ").append(cff.orderbyBuffer.toString().trim());// order by clause

            cff.strQuery=q;
            cff.createQueryStatus=1;
            cff.orderbyBuffer=new StringBuffer(" ");
            cff.criteriaBuffer=new StringBuffer(" ");

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
                String cond=formCondition();
                if(cond==null)
                {
                    JOptionPane.showMessageDialog(cff.jf1,"Select a field and an operator and enter a value first.");
                    cff.jrb3.setSelected(true);
                    return;
                }
                cff.criteriaBuffer.append("where "+cond);
            }
            System.out.println(cff.criteriaBuffer);
            cff.jbtemp.setBounds(450,400,60,25);
        }

////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
        if(ae.getSource()==cff.jbtemp)
        {

            String cond=formCondition();
            if(cond==null)
            {
                JOptionPane.showMessageDialog(cff.jf1,"Select a field and an operator and enter a value first.");
                return;
            }
            if(cff.jrb1.isSelected())
                cff.criteriaBuffer.append(" AND "+cond);
            else
                cff.criteriaBuffer.append(" OR "+cond);

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

            cff.jcom11=new JComboBox(new Vector(Connect.columnNames));   // copy: the combo must not change the real column list
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
            System.out.println(" TableResult SQL error : "+e.getMessage());
            JOptionPane.showMessageDialog(null,"Query failed:\n"+e.getMessage()+"\n\nQuery: "+sb);
            return;                     // do not open the result window
        }
        catch(Exception e)
        {
            System.out.println(" TableResult error : "+e);
            JOptionPane.showMessageDialog(null,"Error: "+e);
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
        jf.setSize(650,450);
        jf.setLocation(100,100);
        jf.setLayout(null);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        jb1=new JButton("Back");
        jb1.setBounds(100,60,150,30);
        jf.add(jb1);

        jb2=new JButton("Exit");
        jb2.setBounds(350,60,100,30);
        jf.add(jb2);

        jt=new JTable(5,3);
//      jt.setBounds(0,0,500,500);
//      jt.doLayout();

        jsp=new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.setBounds(50,110,550,250);
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
        catch(SQLException e)   {   System.out.println(" TableResult SQL error : "+e.getMessage());}
        catch(Exception e)      {   System.out.println(" TableResult error : "+e);     }

        jf.remove(jsp);
        jt=new JTable(rowDataMain,columnNames);
        jsp=new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.setBounds(50,110,550,250);
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
    static Vector dbList=new Vector(0,1);       // databases shown in chooser

    static String dsnName="";                   // JDBC url
    static String dbUser="";
    static String dbPass="";
    static String host="",port="";

    // every part of the program gets its connection from here
    static Connection getConn() throws SQLException
    {
        return DriverManager.getConnection(dsnName,dbUser,dbPass);
    }

    // ---- SQL value helpers: text values must be inside quotes  (name = 'abhi'),
    // ---- otherwise MySQL thinks 'abhi' is a column name -> "Unknown column 'abhi'"
    static String quote(String v)
    {
        v=v.trim();
        if(v.matches("-?\\d+(\\.\\d+)?"))                                   // numbers stay as they are
            return v;
        if(v.length()>=2 && v.startsWith("'") && v.endsWith("'"))            // user already typed quotes
            v=v.substring(1,v.length()-1).replace("''","'");
        else if(v.length()>=2 && v.startsWith("\"") && v.endsWith("\""))
            v=v.substring(1,v.length()-1);
        return "'"+v.replace("\\","\\\\").replace("'","''")+"'";
    }

    static String condition(String field,String op,String val)
    {
        if(op.equals("soundex"))                                             // MySQL syntax: field SOUNDS LIKE 'value'
            return field+" sounds like "+quote(val);

        if(op.equals("between"))                                             // value typed as:  10 and 20   or   10,20
        {
            String parts[]=val.split("(?i)\\s+and\\s+|\\s*,\\s*");
            if(parts.length==2)
                return field+" between "+quote(parts[0])+" and "+quote(parts[1]);
            return field+" between "+val;
        }

        if(op.equals("in"))                                                  // value typed as:  a,b,c   or   (a,b,c)
        {
            String t=val.trim();
            if(t.startsWith("(") && t.endsWith(")"))
                t=t.substring(1,t.length()-1);
            String parts[]=t.split("\\s*,\\s*");
            StringBuffer sb=new StringBuffer(field+" in (");
            for(int i=0;i<parts.length;i++)
            {
                if(i>0) sb.append(", ");
                sb.append(quote(parts[i]));
            }
            return sb.append(")").toString();
        }

        return field+" "+op+" "+quote(val);                                  // = != > >= < <= like
    }

    // MySQL server details (same defaults as before)
    static String currentLabel="";              // "db1 - name" of the opened database
    static Vector dbLabels=new Vector(0,1);     // "db1 - name", "db2 - name" ... shown in the combo

    // "db3 - sales"  ->  "sales"
    static String realName(String label)
    {
        int i=label.indexOf(" - ");
        return i<0 ? label : label.substring(i+3);
    }

    JFrame jf;
    JComboBox databaseCombo;
    JButton jb01,jb02;

    Connect()
    {
        jf=new JFrame("MySQL Database Connection");
        jf.setSize(430,200);
        jf.setLocation(300,250);
        jf.setLayout(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel jl=new JLabel("Select Database:");
        jl.setBounds(30,30,120,25);
        jf.add(jl);

        databaseCombo=new JComboBox();
        databaseCombo.setBounds(150,30,200,25);
        jf.add(databaseCombo);

        jb01=new JButton("Connect");
        jb01.setBounds(80,90,100,30);
        jf.add(jb01);

        jb02=new JButton("Exit");
        jb02.setBounds(220,90,100,30);
        jf.add(jb02);

        jb01.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ go(); }
        });
        jb02.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ System.exit(0); }
        });

        databaseCombo.addItem("Loading databases...");
        jf.setVisible(true);

        // let the window paint first, then connect to the server and list every database
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){ loadDatabases(); }
        });
    }

    // fills the combo with all databases:  db1 - name , db2 - name ...
    void loadDatabases()
    {
        jf.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.WAIT_CURSOR));
        boolean ok=connectDB();
        jf.setCursor(java.awt.Cursor.getDefaultCursor());
        databaseCombo.removeAllItems();
        if(ok)
        {
            for(int i=0;i<dbLabels.size();i++)
                databaseCombo.addItem(dbLabels.elementAt(i));
        }
    }

    // Connect button: open the selected database
    void go()
    {
        if(databaseCombo.getItemCount()==0)
            loadDatabases();
        Object sel=databaseCombo.getSelectedItem();
        if(sel==null)
        {
            JOptionPane.showMessageDialog(jf,"Please select a database first.");
            return;
        }
        currentLabel=sel.toString();
        if(openDatabase(realName(currentLabel),jf))
        {
            jf.dispose();
            new CreateFirstForm();              // query tab opens only now
        }
    }

    // Step 1: connect to the MySQL server and load the list of all databases
    public boolean connectDB()
    {
        try
        {
            host="localhost";
            port="3305";
            dbUser="root";
            dbPass="abhisql";
            dsnName="jdbc:mysql://"+host+":"+port+"/";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c=getConn();

            dbList=new Vector(0,1);
            dbLabels=new Vector(0,1);
            ResultSet rs=c.getMetaData().getCatalogs();
            int n=1;
            while(rs.next())
            {
                String name=rs.getString(1);
                dbList.add(name);
                dbLabels.add("DB "+n+" - "+name);        // sequence before the db name
                n++;
            }
            rs.close();
            c.close();
            return true;
        }
        catch(ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(jf,"MySQL driver not found: "+e.getMessage()+"\nAdd mysql-connector-j jar to the classpath.");
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

    // Step 2: user picked a database -> load its tables
    static boolean openDatabase(String name,JFrame parent)
    {
        try
        {
            dsnName="jdbc:mysql://"+host+":"+port+"/"+name;
            Connection c=getConn();

            DatabaseMetaData dbmd=c.getMetaData();
            ResultSet rs=dbmd.getTables(name,null,null,new String[]{"TABLE"});
            tableNames=new Vector(0,1);
            tableNames.add("---None---");
            while(rs.next())
                tableNames.add(rs.getString(3));
            rs.close();
            c.close();
            System.out.println(tableNames);
            return true;
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(parent,"Cannot open '"+name+"': "+e.getMessage());
        }
        return false;
    }
}
