import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

class MyEditor implements ActionListener
{
    JFrame jf;
    JLabel jl;
    JTextField jtf;
    JTextArea jta,jtal;
    JButton jbcompile,jbrun;
    JScrollPane jsp,jspl;
    Runtime r;
    String str="";
    String fname="";
    String result="";
    String result1="";
    
    MyEditor()
    {
        jf=new JFrame("My Editor");
        jf.setLayout(null);
        jl=new JLabel("Enter java Class Name");
        jl.setBounds(20,20,130,25);
        jtf=new JTextField();
        jtf.setBounds(180,20,230,25);
        jta=new JTextArea(50,50);
        jta.addFocusListener(new MyFocusListener(this));
        jtal=new JTextArea(50,50);
        jta.setFont(new Font("varinda",Font.PLAIN,15));
        jtal.setFont(new Font("varinda",Font.PLAIN,15));
        jsp=new JScrollPane(jta);
        jspl=new JScrollPane(jtal);
        jsp.setBounds(50,60,320,150);
        jspl.setBounds(50,270,320,150);
        jf.add(jsp);
        jf.add(jspl);
        jbcompile=new JButton("Compile");
        jbrun=new JButton("Run");
        jbcompile.setBounds(100,230,80,25);
        jbrun.setBounds(280,230,80,25);
        jf.add(jl);
        jf.add(jtf);
        r=Runtime.getRuntime();
        jf.add(jbcompile);
        jf.add(jbrun);
        jbcompile.addActionListener(this);
        jbrun.addActionListener(this);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(550,550);
        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==jbcompile)
        {
            str="";

            if(!jtf.getText().equals(""))
            {
                try
                {
                    fname=jtf.getText().trim()+".java";
                    FileWriter fw=new FileWriter(fname);
                    String s1=jta.getText();
                    PrintWriter pw=new PrintWriter(fw);
                    pw.println(s1);
                    pw.flush();

                    String[] compileCommand = {"C:\\Program Files\\Java\\jdk-26\\bin\\javac.exe", "-d", ".", fname};
                    Process error = r.exec(compileCommand);

                    BufferedReader err = new BufferedReader(new InputStreamReader(error.getErrorStream()));

                    while(true)
                    {
                        String temp = err.readLine();
                        if(temp!=null)
                        {
                            result+=temp;
                            result+="\n";
                        }
                        else break;
                    }
                    if(result.equals(""))
                    {
                        jtal.setText("Compilation successful!"+fname);
                        err.close();
                    }
                    else
                        jtal.setText(result);
                }
                catch(Exception e1)
                {
                    System.out.println(e1);
                }
            }
            else
                jtal.setText("Please Enter the java programe name!");
        }
        else if(e.getSource()==jbrun)
        {
            int start=0;
            try
            {
                String fn=jtf.getText().trim();
                String[] runCommand = {"C:\\Program Files\\Java\\jdk-26\\bin\\java.exe", "-cp", ".", fn};
                Process p = r.exec(runCommand);

                BufferedReader output = new BufferedReader(new InputStreamReader(p.getInputStream()));
                BufferedReader error = new BufferedReader(new InputStreamReader(p.getErrorStream()));

                while(true)
                {
                    String temp=output.readLine();
                    if(temp!=null)
                    {
                        result+=temp;
                        result+="\n";
                    }
                    else
                    {
                        break;
                    }
                }

                while(true)
                {
                    String temp =error.readLine();
                    if(temp!=null)
                    {
                        result1+=temp;
                        result1+="\n";
                    }
                    else
                    {
                        break;
                    }
                }

                output.close();
                error.close();

                jtal.setText(result+"\n"+result1);

            }
            catch(Exception e2)
            {
                System.out.println(e2);
            }
        }
    }
    public static void main(String arg[])
    {
        new MyEditor();
    }
}

class MyFocusListener extends FocusAdapter
{
    MyEditor e;
    MyFocusListener(MyEditor e)
    {
        this.e=e;
    }
    public void focusGained(FocusEvent fe)
    {
        if(e.jta.getText().trim().isEmpty()) 
        {
            String str=e.jtf.getText().trim();
            e.jta.setText("public class "+str+"\n"
            +"{"+"\n"
            +"public static void main(String... s)"+"\n"
            +"{"+"\n"
            +"                  "+"\n"
            +"}"+"\n"
            +"}");
        }
    }
}
