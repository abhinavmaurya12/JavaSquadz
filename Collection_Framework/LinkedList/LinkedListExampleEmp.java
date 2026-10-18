import java.util.*;
public class LinkedListExampleEmp
{
    public static void main(String args[]) {

        /* Linked List Declaration */
        LinkedList<Emp> linkedlist = new LinkedList<Emp>();

        /*add(Emp Element) is used for adding
         * the elements to the linked list*/
        linkedlist.add(new Emp(1001,"lalu"));
        linkedlist.add(new Emp(1002,"rabari"));
       linkedlist.add(new Emp(1003,"meesa"));
       linkedlist.add(new Emp(1004,"teju"));
       linkedlist.add(new Emp(1005,"tej pratap"));

        /*Display Linked List Content*/
Iterator<Emp> i=linkedlist.iterator();
    while(i.hasNext())
    {
    Emp e=i.next();
    System.out.println(e.id+"  "+e.name);
    }


        /*Add First and Last Element*/
        linkedlist.addFirst(new Emp(100,"nitish"));
        linkedlist.addLast(new Emp(200,"mulayam"));
        System.out.println("LinkedList Content after addition: ");
 i=linkedlist.iterator();
    while(i.hasNext())
    {
    Emp e=i.next();
    System.out.println(e.id+"  "+e.name);
    }
        /*This is how to get and set Values*/
        Emp firstvar =(Emp)linkedlist.get(0);
        System.out.println("First element: " +firstvar.id+"  "+firstvar.name);
Emp  e2=new Emp(420,"nitish420");
        linkedlist.set(0,e2);
         firstvar =(Emp)linkedlist.get(0);
        System.out.println("First element after update by set method: " +firstvar.id+"  "+
        firstvar.name);

        /*Remove first and last element*/
        linkedlist.removeFirst();
        linkedlist.removeLast();
        System.out.println("LinkedList after deletion of first and last element: " );
 i=linkedlist.iterator();
    while(i.hasNext())
    {
    Emp e=i.next();
    System.out.println(e.id+"  "+e.name);
    }
        /* Add to a Position and remove from a position*/
 e2=new Emp(421,"nitish421");
        linkedlist.add(0,e2);
        linkedlist.remove(2);
        System.out.println("Final Content: ");
 i=linkedlist.iterator();
    while(i.hasNext())
    {
    Emp e=i.next();
    System.out.println(e.id+"  "+e.name);
    }
 firstvar =(Emp)linkedlist.getFirst();
Emp lastvar =(Emp)linkedlist.getLast();
System.out.println("First element" +firstvar.id+"  "+firstvar.name);
System.out.println("Last element" +lastvar.id+"  "+lastvar.name);
     }
}

class  Emp
{
int id;
String name;
Emp(int id,String  name)
{
this.id=id;
this.name=name;
}
}
