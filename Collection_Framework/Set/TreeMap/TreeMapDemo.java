import java.util.*;
class TreeMapDemo
{
public static void main(String s1[])
{
TreeMap<String,String> hm=new TreeMap<String,String>();
System.out.println(hm.size());
hm.put("1004","dddd");
hm.put("1003","cccc");
hm.put("1002","bbbb");
hm.put("1001","aaaa");
show(hm);
SortedMap sm=hm.headMap("1003");
System.out.println("less than 1003");
 show(sm);
 sm=hm.subMap("1002","1004");
System.out.println("between 1002 and 1004");
show(sm);
sm=hm.tailMap("1002");
System.out.println("greater than 1002");
show(sm);
}
static void show(SortedMap sm)
{
Set s=sm.entrySet();
Iterator i=s.iterator();
while(i.hasNext())
{
Map.Entry e=(Map.Entry)i.next();
String k=(String)e.getKey();
String v=(String)e.getValue();
System.out.println(k+"="+v);
}
}
}
