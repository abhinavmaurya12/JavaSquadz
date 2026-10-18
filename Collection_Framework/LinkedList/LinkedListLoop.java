import java.util.*;

public class LinkedListLoop {

   public static void main(String args[]) {
      /*LinkedList declaration*/
      LinkedList<String> linkedlist=new LinkedList<String>();
      linkedlist.add("Apple");
      linkedlist.add("Orange");
      linkedlist.add("Mango");

      /*for loop*/
      System.out.println("**For loop**");
      for(int num=0; num<linkedlist.size(); num++)
      {
          System.out.println(linkedlist.get(num));
      }

      /*Advanced for loop*/
      System.out.println("**Advanced For loop**");
      for(String str: linkedlist)
      {
          System.out.println(str);
      }

      /*Using Iterator*/
      System.out.println("**Iterator**");
      Iterator<String> i = linkedlist.iterator();
      while (i.hasNext()) {
      System.out.println(i.next());
      }

      /* Using While Loop*/
      System.out.println("**While Loop**");
      int num = 0;
      while (linkedlist.size() > num) {
      System.out.println(linkedlist.get(num));
      num++;
      }
// Using lambda expression and functional operations
linkedlist.forEach((s) -> System.out.print(s + "; "));
 System.out.println("  ");
// Using double colon operator in Java 8
linkedlist.forEach(System.out::println);
   }
}
