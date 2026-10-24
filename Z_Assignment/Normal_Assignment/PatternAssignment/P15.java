class P15
{
public static void main(String args[])
{
int i,j,rows;
char ch='A';
System.out.printf("Enter the num: ");
rows=new java.util.Scanner(System.in).nextInt();

for(i=1; i<=rows; i++){
	char ch1 = (char)(ch + i - 1);  						
	for(j=i; j<=i+4; j++)
{
	
System.out.print(ch1);
ch1++;

}
System.out.println(" ");

}
}
}
