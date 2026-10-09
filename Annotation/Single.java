import java.lang.annotation.*;
import java.lang.reflect.*;


@Retention(RetentionPolicy.RUNTIME)
@interface MySingle
{
  int value();
}

public class Single
{


  @MySingle(100)
  public static void myMeth()
  {
    Single ob = new Single();

    try {
      Method m = ob.getClass().getMethod("myMeth");

      MySingle anno = m.getAnnotation(MySingle.class);
Class  c=anno.getClass();
 System.out.println(c.getName());
Class inter[]=c.getInterfaces();
for(int i=0;i<inter.length;i++)
{
System.out.println(inter[i].getName());
}
Method m1 = c.getMethod("value");
System.out.println(m1.getName());
 int  x=anno.value();
      System.out.println(x); // displays 100

    } catch (NoSuchMethodException exc) {
     System.out.println("Method Not Found.");
    }
  }

  public static void main(String args[]) {
    myMeth();
  }
}
