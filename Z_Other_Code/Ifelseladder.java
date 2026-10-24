class Ifelseladder
{
public static void main (String args [])
{
System.out.println("enter the marks");
int marks=new java.util.Scanner(System.in).nextInt();
if (marks>75){
System.out.println("1st class");
}
else if(marks>65){
System.out.println("2nd class");
}
else if (marks>55){
System.out.println("3rd class");
}
else{
System.out.println("4th class");
}
}
}
