class Printtable
{
public static void main(String args[])
{

int i=1;
int number;

System.out.print("Enter the number: ");
 number =new java.util.Scanner(System.in).nextInt();
while(i<=10)
{
System.out.printf("%d * %d =%d ", number, i, number*i);
// System.out.print( number+" * "+i+ " = " + number*i );
System.out.println();
i++;
}
}
}