class Discount
{
public static void main(String args[])
{
int totalprice=0;

System.out.println("enter the unit");
int units =new java.util.Scanner(System.in).nextInt();
int price=units*100;
if(price>1000)
{
totalprice=(price)-(price*10)/100;
}
else
totalprice=price;

System.out.println("Total price =" + totalprice);

}
}