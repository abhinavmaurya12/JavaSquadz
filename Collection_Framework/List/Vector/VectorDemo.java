import java.util.*;
class VectorDemo
{
public static void main(String s1[])
{
Vector<String> al=new Vector<>(3,2);

System.out.println("ini"+al.capacity());
System.out.println(al.size());
al.addElement("a");
al.addElement("b");
al.addElement("a");
al.addElement("b");
System.out.println("cap"+al.capacity());
System.out.println(al.size());
al.removeElementAt(2);
Enumeration<String> e1=al.elements();
System.out.println(e1.getClass().getName());
while(e1.hasMoreElements())
{
String s=e1.nextElement();
System.out.print(s);
}
System.out.println("  ");
Iterator<String> e=al.iterator();
while(e.hasNext())
{
String s=e.next();
System.out.print(s);
}
al.trimToSize();
System.out.println("\ncap"+al.capacity());
}

}
