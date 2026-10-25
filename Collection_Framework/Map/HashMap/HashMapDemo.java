import java.util.*;
class HashMapDemo
{
public static void main(String s1[])
{
HashMap<String,String> hm=new HashMap<>();
System.out.println(hm.size());
hm.put("1001","aaaa");
hm.put("1002","bbbb");
hm.put("1003","cccc");
hm.put("1004","dddd");
hm.put(new String("1001"),"zzz");
Set s=hm.entrySet();
Iterator<Map.Entry> i=s.iterator();
while(i.hasNext())
{
Map.Entry e=i.next();
String k=(String)e.getKey();
String v=(String)e.getValue();
System.out.println(k+"="+v);
}

}
}
