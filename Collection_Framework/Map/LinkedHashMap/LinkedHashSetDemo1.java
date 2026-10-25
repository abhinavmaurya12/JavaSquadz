import java.util.*;
class LinkedHashSetDemo1
{
public static void main(String s[])
{
LinkedHashSet<Emp> al=new LinkedHashSet<Emp>();
System.out.println(al.size());
al.add(new Emp(1002));
al.add(new Emp(1003));
al.add(new Emp(1004));
al.add(new Emp(1005));
System.out.println(al.size());
Iterator<Emp> i=al.iterator();
while(i.hasNext())
{
Emp e=i.next();
System.out.println(e.id);
}
}
}

class Emp
{
int id;
Emp(int id)
{
this.id=id;
//System.out.println(this.hashCode());
}
public  boolean  equals(Object  o)
{
Emp e=(Emp)o;
if(e.id==this.id)
return true;
else
return false;
}
public int hashCode()
{
System.out.println("inside hashcode");
return  id*10;
}
}
