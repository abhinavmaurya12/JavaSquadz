class P17
{
public static void main(String args[])
{
int i,j,rows; 
char ch='A';
System.out.printf("Enter the num: ");
rows=new java.util.Scanner(System.in).nextInt();

 for (i = rows - 1; i >= 0; i--) {
    char ch1 = (char) (ch + i);
    for (j = 1; j <= rows; j++) {
      System.out.print(ch1);
	  
    }        
System.out.println(" ");

}
}
}
