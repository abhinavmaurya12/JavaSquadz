class P14
{
public static void main(String args[])
{
int i,j,rows;
System.out.printf("Enter the num: ");
rows=new java.util.Scanner(System.in).nextInt();

for(i=1; i<=rows; i++)
{
for(j=1; j<=rows; j++) 
{
 if ((i + j) % 2 == 0)
 {
    System.out.print(1);
 } 
 else 
 {
  System.out.print(0);
 }
}
System.out.println(" ");
}
}
}