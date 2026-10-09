import java.lang.annotation.*;
class TestDeprecated
{
@Deprecated
static void display()
{
System.out.println("display");
}
}


class TestAnnotation {
   public static void main(String arg[]) {
       new TestAnnotation().doSomeTestNow();
   }
@SuppressWarnings({"checked","deprecation"})
   public void doSomeTestNow() {
   TestDeprecated.display();

   }
}
