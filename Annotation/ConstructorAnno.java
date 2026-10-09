import java.lang.annotation.*;
import java.lang.reflect.*;
@Target(ElementType.CONSTRUCTOR)
 @Retention(RetentionPolicy.RUNTIME)
@interface MyAnnoc {
    int val();
}

public class ConstructorAnno
{
@MyAnnoc(val = 200)
ConstructorAnno(int x)
{

}
@MyAnnoc(val = 100)//Parent interface java.lang.annotation.Annotation
ConstructorAnno()
{


 }
public  static  void  readC()
{
    try {

      Class c =ConstructorAnno.class;
     Constructor c1 = c.getDeclaredConstructor();
      Constructor c2 = c.getDeclaredConstructor(int.class);
    MyAnnoc anno =(MyAnnoc)c1.getAnnotation(MyAnnoc.class);
   MyAnnoc anno1 =(MyAnnoc)c2.getAnnotation(MyAnnoc.class);

      System.out.println(anno.val());
System.out.println(anno1.val());
    } catch (Exception exc) {
     System.out.println(exc);
    }
  }

  public static void main(String args[]) {
    readC();
  }
}
