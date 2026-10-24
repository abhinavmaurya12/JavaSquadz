class Practice4
{
	
public static void main(String args[])
{	
int count=0;
System.out.println("You have to enter the of x and y , x>=y always");

while(true)
{
System.out.println("enter the value of x");
int x=new java.util.Scanner(System.in).nextInt();
System.out.println("enter the value of y");
int y=new java.util.Scanner(System.in).nextInt();

if(x%y==0)
{
System.out.println("enterd value are " + x + "," + y + " x>=y which is devided.");

while(x>0)
{
 x=x-y; 
 count ++;
}
System.out.println(count);
}

else
{	
System.out.println("enterd value are " + x + "," + y + " which is not devided");
}
	
System.out.println("press 1 to continue and 0 for end");
int num=new java.util.Scanner(System.in).nextInt();
if(num==1)
	continue;
else
	break;

}
}
}
