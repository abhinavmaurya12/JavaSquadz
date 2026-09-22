import java.io.*;
import java.net.*;

public class MyServer
{

	ServerSocket ss;
	Socket s;
	DataInputStream dis;
	DataOutputStream dos;

	public MyServer()
	{
		try
		{
System.out.println("Server Started");
ss=new ServerSocket(10);
s=ss.accept();
System.out.println(s);
System.out.println("CLIENT CONNECTED");
dis=new DataInputStream(s.getInputStream());
dos=new DataOutputStream(s.getOutputStream());
serverChat();
}
catch(Exception e)
{
System.out.println(e);}
}
	public static void main(String ar[])
	{
		new MyServer();
	}
public void serverChat()throws IOException
{
String str;
do
{
str=dis.readUTF();
System.out.println("Client MESSAGE " +str);
dos.writeUTF("hello " +str);
dos.flush();
}
while(!str.equals("stop"));
}
}