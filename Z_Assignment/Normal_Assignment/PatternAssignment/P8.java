class P8
{
public static void main(String args[])
{
int i,rows;
char ch='A';
System.out.printf("Enter the num: ");
rows=new java.util.Scanner(System.in).nextInt();

for(i=1; i<=rows; i++)
{
for(ch='A'; ch<='E'; ch++)
{
System.out.print(ch);
}
System.out.println(" ");
}
}
}
// ABCDE
// ABCDE
// ABCDE
// ABCDE
// ABCDE
