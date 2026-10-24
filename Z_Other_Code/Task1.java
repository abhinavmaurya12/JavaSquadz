class Task1
{
public static void main(String args[])
{
int charge=0;
System.out.println("enter bike number");
String bno=new java.util.Scanner(System.in).nextLine();
System.out.println("enter customer name");
String name=new java.util.Scanner(System.in).nextLine();
System.out.println("enter number of days");
int days =new java.util.Scanner(System.in).nextInt();

if(days<=5)
{
charge=500*days;
}
else if (days>5 && days<=10)
{
charge=2500+400*(days-5);
}
else if (days>10)
{
charge=2500+2000+200*(days-10);
}

System.out.println("Bike no: " + bno);
System.out.println("Name of customer: " + name);
System.out.println("Number of Days: " + days);
System.out.println( "Charges: " + charge);

// System.out.print("bike no" + "\t\t\t" + " Customer" + " \t\t\t\ " + "Days" + "Charges" + "\t\t\t");
// System.out.print("");
// System.out.print(bno + "\t\t");
// System.out.print(name + "\t\t");
// System.out.print(days + "\t\t");
// System.out.print(charge + "\t\t");

}
}