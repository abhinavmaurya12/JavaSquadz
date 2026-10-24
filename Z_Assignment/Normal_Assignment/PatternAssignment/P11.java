class P11
{
public static void main(String args [])
{

int i, j, rows;
System.out.printf("Enter the num: ");
rows=new java.util.Scanner(System.in).nextInt();

for(i=1; i<=rows; i++)
{
for(j=rows; j>=1; j--)
{
System.out.print(j);	
}
System.out.println(" ");
}
}
}