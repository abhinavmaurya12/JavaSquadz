class A
{
{
System.out.println("init block of class A");
}

A()
{
// super();
//init block code will be pasted here after compilation
System.out.println("A");
}
}

class B extends A
{
{
System.out.println("init block of class B");
}
B(int x)
{
// super();
//init block code will be pasted here after compilation

System.out.println(x);
}
B()
{
// super();
//init block code will be pasted here after compilation
System.out.println("B");
}
}

class Cinit extends B 
{
{
System.out.println("init block if class C");
}

Cinit()
{
super(10);
//init block code will be pasted here after compilation

System.out.println("C");
}

Cinit(int x)
{
// super();
//init block code will be pasted here after compilation
System.out.println(x);
}

public static void main(String args[])
{
// new Cinit();
new Cinit(12);
}
}