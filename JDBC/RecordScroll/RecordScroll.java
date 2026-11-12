import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

class RecordScroll extends JFrame implements AdjustmentListener
{
    Connection cn;
    Statement st;
    Scrollbar bar;

    JLabel [] la = new JLabel[4];
    JTextField [] tb = new JTextField[4];

    ResultSet rst;
    JLabel rv;
    int nor = 0;

    public RecordScroll()
    {
        setSize(400,400);
        setResizable(true);
        setLayout(null);

        String [] str = {"Sid","Name","City","Age"};
        int y = 50;

        for(int i=0;i<la.length;i++)
        {
            la[i] = new JLabel(str[i]);
            la[i].setBounds(100,y,90,27);
            add(la[i]);

            tb[i] = new JTextField();
            tb[i].setBounds(200,y,150,27);
            add(tb[i]);

            y += 60;
        }

        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            cn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe","system","mca6");

            st = cn.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);

            rst = st.executeQuery("select * from Students");

            while(rst.next())
            {
                nor++;
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }

        bar = new Scrollbar(Scrollbar.HORIZONTAL,0,1,0,nor);
        bar.setBounds(100,300,200,30);
        add(bar);

        bar.addAdjustmentListener(this);

        rv = new JLabel();
        rv.setBounds(100,270,60,30);
        add(rv);

        showRecord(1);
        setVisible(true);
    }

    void showRecord(int rn)
    {
        try
        {
            rst.absolute(rn);

            for(int i=0;i<4;i++)
            {
                tb[i].setText(rst.getString(i+1));
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }

        rv.setText(rn+"/"+nor);
    }

    public void adjustmentValueChanged(AdjustmentEvent e)
    {
        showRecord(e.getValue()+1);
    }

    public static void main(String [] args)
    {
        new RecordScroll();
    }
}