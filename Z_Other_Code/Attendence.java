class Attendence 
{
public static void main (String args[])
{
System.out.println("number of class");
int a = new java.util.Scanner(System.in).nextInt();
System.out.println("number of attendence");
int b = new java.util.Scanner(System.in).nextInt();
int p=(b*100)/a;

if(p>=75)
System.out.println("student are allowed to sit in exam = " + p + "%" + " Attendence");
else
System.out.println("student are not allowed to sit in exam = " + p + "%" + " Attendence");

 }
 }