class P9
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
	if(i%2==0){
	System.out.print(i);
	}
	else{
		System.out.print("*");
	}
}
System.out.println(" ");
}
}
}
// *****
// 22222
// *****
// 44444
// *****