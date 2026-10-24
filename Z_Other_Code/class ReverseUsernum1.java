class ReverseUsernum1
{
public static void main(String args [])
{
int rev=0;
int z;
while(true)
{
System.out.println("enter the num");
int x1=new java.util.Scanner(System.in).nextInt();
while(x1>0)
{
z=x1%10;
x1=x1/10;
rev=rev*10+z;
}
System.out.println(rev);
rev=0;

System.out.println("do you want to continue press 1 for yes 0 for no");
int x2=new java.util.Scanner(System.in).nextInt();
if(x2==1)
continue;
else
break;
}
}
}