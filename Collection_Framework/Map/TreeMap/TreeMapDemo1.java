//the key class must be implementing the Comparable interface otherwise ClassCastException will be thrown.

import java.util.*;
class TreeMapDemo1
{
public static void main(String s1[])
{
TreeMap<Temp,String> hm=new TreeMap<Temp,String>();
System.out.println(hm.size());
hm.put(new Temp(10),"dddd");
hm.put(new Temp(5),"cccc");
hm.put(new Temp(4),"bbbb");
hm.put(new Temp(1),"aaaa");
show(hm);
Temp  e1=new Temp(10);
//SortedMap sm= hm.headMap(e1);
SortedMap sm= hm.headMap(e1,true);
System.out.println("less than 10");
 show(sm);
e1=new Temp(1);
 sm= hm.tailMap(e1);
System.out.println("greater than 1");
show(sm);
Temp e2=new Temp(10);
 //sm= hm.subMap(e1,e2);
sm= hm.subMap(e1,true,e2,true);
System.out.println("between 1 and 10");
show(sm);
System.out.println(hm.isEmpty());
System.out.println(hm.get(e1));
hm.remove(e1);
show(hm);
System.out.println(hm.size());
Map<Temp, String> rm = hm.descendingMap();
show(rm);
}
static void show(Map<Temp, String> hm)
{
Set s=hm.entrySet();
Iterator i=s.iterator();
while(i.hasNext())
{
Map.Entry e=(Map.Entry)i.next();
Temp k=(Temp)e.getKey();
String v=(String)e.getValue();
System.out.println(k.x+"="+v);
}


}
}
class Temp implements Comparable<Temp>
{
int  x;
Temp(int x)
{
this.x=x;
}
public int compareTo(Temp t)
{
//System.out.println("compare");
if(this.x>t.x)
return  1;
else if(this.x<t.x)
return  -1;
else
return 0;
}
}
