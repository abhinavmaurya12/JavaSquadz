class My
{
 static int x=10;
 }
 
 class Childstaticinterface extends My{
 
 int x=100;
 //static int x=10;
 
 public static void main(String args[])
 {
 System.out.println(My.x);
 System.out.println(new Childstaticinterface().x);
 
 }
 }