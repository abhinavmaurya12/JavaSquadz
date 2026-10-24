class P7
{
public static void main(String args[])
{
int i,j,rows;
System.out.printf("Enter the num: ");
rows=new java.util.Scanner(System.in).nextInt();

for(i=1; i<=rows; i++)
{
for(j=i; j<=i+4; j++)
{
System.out.print(j);
}
System.out.println(" ");


}
}
}
// 12345
// 23456
// 34567
// 45678
// 56789