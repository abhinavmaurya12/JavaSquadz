import java.io.*;
import java.net.*;

public class MyServer1
{

	ServerSocket ss;
	Socket s;
	DataInputStream dis;
	DataOutputStream dos;

	public MyServer1()
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
		new MyServer1();
	}
public void serverChat()throws IOException
{
String str,s1;
do
{
str=dis.readUTF();
System.out.println("Client MESSAGE " +str);
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
s1=br.readLine();
dos.writeUTF(s1);
dos.flush();
}
while(!s1.equals("stop"));
}
}

// NOTE: the photos cut off after this point — the file is 53 lines total,
// and an extra line (beginning "//InetAddress i=s.getInetAddress();")
// after the closing brace was visible but not fully readable.