import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno1 {
  String str();
  int val();
}

public class Meta
{
   // Annotate a method.
  @MyAnno1(str="Annotation Example", val = 100)
  public static void myMeth()
{
   Meta ob = new Meta();

   try {

     Class c = ob.getClass();


     Method m = c.getMethod("myMeth");


     MyAnno1 anno = m.getAnnotation(MyAnno1.class);


     System.out.println(anno.str() + " " + anno.val());
   } catch (NoSuchMethodException exc) {
    System.out.println("Method Not Found.");
   }
 }

 public static void main(String args[]) {
   myMeth();
 }
}
