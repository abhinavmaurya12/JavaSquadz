class P13
{
public static void main(String args[])
{
int i,j,rows;
System.out.printf("Enter the num: ");
rows=new java.util.Scanner(System.in).nextInt();

for(i=1; i<=rows; i++)
{
for(j=i+4; j>=i; j--)
{
System.out.print(j);
}
System.out.println(" ");


}
}
}