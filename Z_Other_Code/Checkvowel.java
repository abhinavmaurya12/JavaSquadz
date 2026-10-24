class Checkvowel
{
public static void main (String args[]) throws java.io.IOException
{
System.out.println("enter the number");
int x=System.in.read();

char ch=(char)x;
if(ch=='A' || ch=='a' || ch=='E' || ch=='e' || ch=='I' || ch=='i' || ch=='O'
 || ch=='o' || ch=='U' || ch=='u')
System.out.println("vowel");
else
System.out.println("not vowel");
}
}


