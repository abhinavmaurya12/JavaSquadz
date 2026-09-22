import java.io.*;
import java.net.*;
public class MyClient1
{
	Socket s;
	DataInputStream din;
	DataOutputStream dout;
	public MyClient1()
	{
		try
		{

//s=new Socket("13.201.161.138",10);
s=new Socket("localhost",10);
System.out.println(s.getLocalPort());
System.out.println(s);
        din=new DataInputStream(s.getInputStream());
	    dout=new DataOutputStream(s.getOutputStream());
clientChat();
	    }
	    catch(Exception e){System.out.println(e);}
	}

	public void clientChat() throws IOException
	{
BufferedReader br=new BufferedReader(new
InputStreamReader(System.in));
	String s1;
		do
		{
			s1=br.readLine();
			dout.writeUTF(s1);
			dout.flush();
			System.out.println
			("Server    Message:"+din.readUTF());
		}while(!s1.equals("stop"));
	}
	public static void main(String ar[])
	{
		new MyClient1();
	}
}