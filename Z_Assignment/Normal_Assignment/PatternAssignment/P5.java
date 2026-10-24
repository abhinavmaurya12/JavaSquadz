class P5
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
System.out.print(j%2); //10101

}
System.out.println(" ");
}
}
}
// 10101
// 10101
// 10101
// 10101
// 10101