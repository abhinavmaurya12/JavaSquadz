class Baseparent
{
A show()
{
System.out.println("Base");
return new A();
}

}
class Basechild2 extends Baseparent
{
B show()
{
System.out.println("child class run..");
return new B();

}

public static void main(String args [])
{
Basechild2 bc=new Basechild2();
bc.show();
}
}
class A
{

}

class B extends A
{

}
