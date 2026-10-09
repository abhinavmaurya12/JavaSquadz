import java.lang.annotation.*;
import java.lang.reflect.*;
@Target(ElementType.FIELD)
 @Retention(RetentionPolicy.RUNTIME)
@interface MyAnno11
{
    int val();
}

public class FieldAnno
 {
@MyAnno11(val = 100)
public int   x;
    public static void myMeth()
{
   FieldAnno  ob = new FieldAnno();

    try {

      Class c = ob.getClass();
      Field   f = c.getField("x");

      MyAnno11 anno = f.getAnnotation(MyAnno11.class);


      System.out.println(anno.val());
    } catch (Exception exc) {
     System.out.println(exc);
    }
  }

  public static void main(String args[]) {
    myMeth();
  }
}
