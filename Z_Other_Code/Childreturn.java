class Parent  //Covariant Return Type ka example..
{
Parent show()
{
System.out.println("hello parent");
return this;
// Parent pa=new Parent();

}
}

class Childreturn extends Parent
{
Childreturn show()
{
super.show();
System.out.println("hello child") ;
return this;
 // Child ch=new Child();

}
 
public static void main (String args [])
{

Childreturn ch=new Childreturn();
ch.show();
}
}