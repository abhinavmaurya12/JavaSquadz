class B1_interface
{
final int x;
B1_interface(int z)
{

//x=0; (this line is inserted by the compiler)
// System.out.println(x); //(error)
x=z;
System.out.println(x);
}

public static void main(String args [])
{
B1_interface b1=new B1_interface(20);
//b1.x=6000;
B1_interface b2 =new B1_interface(200);
}
}