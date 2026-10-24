class Nestedif
{
public static void main (String args[])
{
System.out.println("enter the number1");
int num1=new java.util.Scanner(System.in).nextInt();
System.out.println("enter the number2");
int num2=new java.util.Scanner(System.in).nextInt();

if(num1>=num2){
if(num1==num2){
System.out.printf("Result: %d=%d",num1,num2);
}
else{
System.out.printf("Result: %d>%d",num1,num2);
}
}
else{
System.out.printf("Result: %d>%d",num1,num2);
}
}
}
