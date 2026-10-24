class Primenumber
{
public static void main(String args[])
{
System.out.println("enter the number");
int x1=new java.util.Scanner(System.in).nextInt();

int count=0;
for(int i=2; i<=x1; i++)
{

int z=x1%i;
if(z==2)
{
count++;
}
}
if(count==2)
System.out.println("prime num");
else
System.out.println("not prime num");
}
}
