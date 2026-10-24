class Studentmedical
{
public static void main(String args[]) throws Exception

{
System.out.println("enter the total num of class");
int n1=new java.util.Scanner(System.in).nextInt();
System.out.println("enter the total num of attended");
int n2=new java.util.Scanner(System.in).nextInt();
System.out.println("enter the total num of medical");
int x= System.in.read();
char ch=(char)x;
int per=(n2*100)/n1;
if(per>=75)
System.out.println("allowed");
else if(ch=='Y' || ch=='y')
System.out.println("allowed to sit exam " + per);
else
System.out.println("not allowed");
}
}