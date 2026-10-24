class Armstrong
{
public static void main(String args[])
{
int rev=0;
int z;
int x2;
while(true)
{
	System.out.println("enter the value");
	x2=new java.util.Scanner(System.in).nextInt();
	int x1=x2;
	while(x1>0)
	{
		z=x1%10;
		x1=x1/10;
		rev=rev+(z*z*z);
	}
	if(rev==x2)
		System.out.println("it is Armstrong");
	else
		System.out.println("it is not Armstrong");
	
		System.out.println("press 1 continue  0 for end");
		int x3=new java.util.Scanner(System.in).nextInt();
		if(x3==1)
			continue;
		else
			break;

}			
}
}
