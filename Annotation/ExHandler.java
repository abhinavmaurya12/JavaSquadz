import java.lang.annotation.*;
import java.lang.reflect.*;

public class ExHandler
{
  public static void  readAnnotation()
  {
    Single ob = new Single();

    try {
      Method m = ob.getClass().getMethod("myMeth");

      MySingle anno = m.getAnnotation(MySingle.class);
 int  x=anno.value();
      System.out.println(x);
System.out.println(anno.getClass().getName());

    } catch (NoSuchMethodException exc) {
     System.out.println("Method Not Found.");
    }
 }

 public static void main(String args[]) {
   readAnnotation();
 }
}
