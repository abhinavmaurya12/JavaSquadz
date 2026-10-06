import java.awt.*;
import javax.swing.*;
class MyFrame
{
MyFrame()
{
JFrame f=new JFrame("dd");
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setSize(400,400);
f.setVisible(true);
}
public static void main(String s[])
{

new MyFrame();
System.out.println("aaa");
}
}
//jar cvfm  t1.jar  my.mf  *.class.
//Only  Swing/Awt Based  classes can be executed  via  executable jar file