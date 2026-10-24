class CheckAlphabet
{
public static void main (String args[]) throws java.io.IOException
{
System.out.println("enter the number");
int x=System.in.read();

char ch=(char)x;
if(ch=='M' || ch=='m')
System.out.println("Male");
else
System.out.println("Female");
System.out.println(x);
System.out.println(ch);
}
}