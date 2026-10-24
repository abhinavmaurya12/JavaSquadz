interface My
{

default void show()
{
System.out.println("my");
}

}
interface My1
{

default void show()
{

System.out.println("my1");
}
}

class MyRegister
{
void register (My b)
{
b.show();
}
}

class Childinterface implements My,My1
{
public void show()
{
System.out.println("child");
}

public static void main(String args [])
{
Childinterface c=new Childinterface ();

MyRegister mr=new MyRegister ();

mr.register(c);
My m=new Childinterface();
m.show();
My1 m1 =new Childinterface();
m1.show();
}
} 