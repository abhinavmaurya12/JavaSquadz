import java.util.*;
class LinkedHashMapDemo
{
public static void main(String s2[])
{
LinkedHashMap<String,String> hm=new LinkedHashMap<String,String>(10,.75f,true);
//LinkedHashMap<String,String> hm=new LinkedHashMap<String,String>(10,.75f);
System.out.println(hm.size());
hm.put("1003","aaaa");
hm.put("1002","bbbb");
hm.put("1001","cccc");
hm.put("1004","dddd");
Set s=hm.entrySet();
Iterator i=s.iterator();
while(i.hasNext())
{
Map.Entry e=(Map.Entry)i.next();
String k=(String)e.getKey();
String v=(String)e.getValue();
System.out.println(k+"="+v);
}

String  s1[]={"1001","1002","1003","1004"};
for(int i1=0;i1<s1.length;i1++)
{
System.out.print(hm.get(s1[i1]));
}

 s=hm.entrySet();
 i=s.iterator();
System.out.println("  ");
while(i.hasNext())
{
Map.Entry e=(Map.Entry)i.next();
String k=(String)e.getKey();
String v=(String)e.getValue();
System.out.println(k+"="+v);
}
}


}
