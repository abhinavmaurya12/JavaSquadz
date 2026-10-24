class Bonus
{
public static void main(String args[])
{
int bonus=0;

System.out.println("enter the salary");
int s1= new java.util.Scanner(System.in).nextInt();

System.out.println("enter num of year");
int y1= new java.util.Scanner(System.in).nextInt();

if(y1>5)
{
bonus=(s1*5)/100;
}

System.out.println( " get bonus = " + bonus);
}
}