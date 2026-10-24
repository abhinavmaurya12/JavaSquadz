class P4
{
public static void main(String args[])
{
int i,j,rows,num=1;

System.out.printf("Enter the num: ");
rows=new java.util.Scanner(System.in).nextInt();

for(i=1; i<=rows; i++)
{
for(j=1; j<=rows; j++)
{
System.out.print(num);
num++;
}
System.out.println(" ");
}
}
}