class P12
{
public static void main(String args [])
{

int i, j, rows;
System.out.printf("Enter the num: ");
rows=new java.util.Scanner(System.in).nextInt();

for(i=rows; i>=1; i--)
{
for(j=1; j<=rows; j++)
{
System.out.print(i);	
}
System.out.println(" ");
}
}
}