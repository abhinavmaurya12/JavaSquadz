import java.util.*;
class ArrayListDemo1
{
public static void main(String s[])
{
ArrayList<Integer>  al=new ArrayList<Integer>();
//ArrayList  al=new ArrayList();
int x[]={1,-1,2,-2,3,-3,4,-4};
for(int i=0;i<x.length;i++)
{
   //add(Object  o)
al.add(x[i]);//new Integer(x[i])jdk1.4
}
System.out.println(al);
Iterator<Integer> i=al.iterator();
System.out.println(i.getClass().getName());
//Iterator  i=al.iterator();
while(i.hasNext())
{
//Integer z=(Integer)i.next();
Integer z=i.next();
if(z.intValue()<0)
i.remove();
}
System.out.println(al);
}
}
