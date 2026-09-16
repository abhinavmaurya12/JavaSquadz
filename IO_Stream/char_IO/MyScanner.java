import java.io.*;
import java.util.*;
class MyScanner
{

public static void main(String s2[])throws IOException
{
Scanner s=new Scanner(System.in);
String s1="  ";
while(!s1.equals("stop"))
{
s1=s.nextLine();
System.out.println(s1);
}
}
}