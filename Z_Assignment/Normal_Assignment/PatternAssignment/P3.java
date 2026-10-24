class P3
{
public static void main(String args[]) 
{
int i,j,rows;

System.out.printf("Enter the number: ");
rows=new java.util.Scanner(System.in).nextInt();

for(i=1; i<=rows; i++)
{
for(j=1; j<=rows; j++)
{
System.out.print(i);
}
System.out.println(" ");
}
}
}
// 11111
// 22222
// 33333
// 44444
// 55555