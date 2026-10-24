class Lapata
{
public static void main(String args [])
{

// int [] Sal = {s1,s2,s3,s4,s5};

System.out.println("Welcome to Lapata pvt Ltd. ");
System.out.println(" ");

System.out.printf("Enter the Emp1 sal : ");
int s1=new java.util.Scanner(System.in).nextInt();

System.out.printf("Enter the Emp2 sal : ");
int s2=new java.util.Scanner(System.in).nextInt();

System.out.printf("Enter the Emp3 sal : ");
int s3=new java.util.Scanner(System.in).nextInt();

System.out.printf("Enter the Emp4 sal : ");
int s4=new java.util.Scanner(System.in).nextInt();

System.out.printf("Enter the Emp5 sal : ");
int s5=new java.util.Scanner(System.in).nextInt();


System.out.println(" " );
System.out.println("Employee Salary : " );
System.out.println("Emp1 : " + s1);
System.out.println("Emp2 : " + s2);
System.out.println("Emp3 : " + s3);
System.out.println("Emp4 : " + s4);
System.out.println("Emp5 : " + s5);

int sum=(s1+s2+s3+s4+s5);
int avg=sum/5;

System.out.println(" ");
System.out.println("Total Salary Distributed by Company : " + sum);
System.out.println("Average Salary per Emp : " + avg);
System.out.println(" ");

if(s1>s2 && s1>s3 && s1>s4 && s1>s5 )
{
	System.out.printf("Best Emp of Year : Emp1 : id.120 ");
}
else if (s2>s1 && s2>s3 && s2>s4 && s2>s5 )
{
	System.out.printf("Best Emp of Year : Emp2 : id.220  ");
	
}
else if (s3>s1 && s3>s2 && s3>s4 && s3>s5 )
{
	System.out.printf("Best Emp of Year : Emp3 : id.320  ");
	
}
else if (s4>s1 && s4>s3 && s4>s2 && s4>s5 )
{
	System.out.printf("Best Emp of Year : Emp4 : id.420  ");
	
}
else if (s5>s1 && s5>s3 && s5>s4 && s5>s2 )
{
	System.out.printf("Best Emp of Year : Emp5 : id.520  ");
	
}
else
{
	System.out.println("This Year No Best Emp ! waiting for next year ! ");
}
}
}
