import java.lang.annotation.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)

@interface MyAnno {
  String str() default "Testing";
  int val() default 9000;
}

public class DefaultValue
{


//@MyAnno(str="hello",val=1000)
 @MyAnno()
  public static void myMeth()
{
    DefaultValue ob = new DefaultValue();


    try {
      Class c = ob.getClass();

      Method m = c.getMethod("myMeth");

      MyAnno anno = m.getAnnotation(MyAnno.class);

      System.out.println(anno.str() + " " + anno.val());
    } catch (NoSuchMethodException exc) {
     System.out.println("Method Not Found.");
    }
  }

  public static void main(String args[])
{

    myMeth();
  }
}
