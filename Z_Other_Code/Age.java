class Age
{
public static void main(String args[])
{
System.out.println("enter the age1");
int age1 = new java.util.Scanner(System.in).nextInt();
System.out.println("enter the age2");
int age2 = new java.util.Scanner(System.in).nextInt();
System.out.println("enter the age3");
int age3 = new java.util.Scanner(System.in).nextInt();

if(age1> age2 && age2> age3)
System.out.println("max age is " + age1);
else if (age2> age1 && age2 > age3)
System.out.println("max age is " + age2);
else if (age3> age1 && age3 > age2)
System.out.println("max age is " + age3);

if(age2> age1 && age3> age2)
System.out.println("min age is " + age1);
else if (age1> age2 && age2 > age3)
System.out.println("min age is " + age2);
else if (age1> age3 && age2 > age3)
System.out.println("min age is " + age3);

}
}

