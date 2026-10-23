import java.util.ArrayList;

public class AddMethodExample
 {
   public static void main(String[] args)
{
        ArrayList<String> al = new ArrayList<String>();

        al.add("Hi");
        al.add("hello");
        al.add("String");
        al.add("Test");

        al.add(3,"lalu");

        System.out.println( al);

        al.add(0, "Bye");

        System.out.println("Elements after adding string bye:"+ al);
   }
}
