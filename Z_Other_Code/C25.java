class A
{
A()

{
//super() implicit super() inserted by compiler
System.out.println("A");
}
}

class B extends A
{
B(int x)
{
//super() implicit super() inserted by compiler
System.out.println(x);

}
B()
{
//super() implicit super() inserted by compiler
System.out.println("B");
}
}

class C25 extends B
{
{
System.out.println("init block of C");
}
C25()
{
// this(10);
System.out.println("C");
super(10);

}

C25(int x)

{
//super() implicit super() inserted by compiler
System.out.println(x);
}

public static void main(String args[])
{
new C25();
// new C25(12);
}
}

