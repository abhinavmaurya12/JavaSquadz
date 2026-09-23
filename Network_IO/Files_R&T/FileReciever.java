import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

public class FileReciever
{
Socket s;
ServerSocket ss;
DataInputStream dis,dis1;
PrintWriter  pw;


public FileReciever()
{
try
{
ss=new ServerSocket(10);
s=ss.accept();
dis=new DataInputStream(s.getInputStream());

String s2=dis.readUTF();
FileWriter fo=new FileWriter(s2);
pw=new PrintWriter(fo);
fileReciever();
}
catch(Exception e)
{
System.out.println(e);
}
}
public void fileReciever()
{
String str="";
try
{
do
{
str=dis.readUTF();
pw.println(str);
pw.flush();
}while(!str.equals(null));
}
catch(Exception e)
{
System.out.println(e);
}
}



public static void main(String k[])
{
new FileReciever();
}
}