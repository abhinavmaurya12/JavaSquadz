import java.lang.reflect.Constructor;

class Temp
{

  private Temp()
  {
    System.out.println("Default constructor");
  }
void show()
{
System.out.println("show");
}
private  Temp(int  x)
{

System.out.println(x+"via  parameter  Constructor");
}
}

  class PrivateConstructor {

  public static void main(String... args)
  {
    try
    {
    //Temp t1=new Temp(10);
Class  cl=Temp.class;
    Constructor c = cl.getDeclaredConstructor();
    c.setAccessible(true); // solution
Temp  t1=(Temp) c.newInstance();
t1.show();
Constructor c1 = cl.getDeclaredConstructor(int.class);
    c1.setAccessible(true); // solution
Temp  t2=(Temp)c1.newInstance(10);
t2.show();
  }catch(Exception e){   }
}
}
