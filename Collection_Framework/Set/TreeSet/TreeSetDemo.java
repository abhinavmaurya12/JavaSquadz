import java.util.*;
class TreeSetDemo
{
public static void main(String s[])
{
TreeSet<Emp> al=new TreeSet<Emp>();
System.out.println(al.size());
al.add(new Emp(10000));
al.add(new Emp(9000));
al.add(new Emp(5000));
al.add(new Emp(5000));
Emp e1=al.first();
Emp e2=al.last();
System.out.println("Least salary emp: "+e1.salary);
System.out.println("Last salary emp: "+e2.salary);
Iterator<Emp>  i=al.iterator();
while(i.hasNext())
{
Emp e=i.next();
System.out.println(e.salary);
}
}
}
class Emp implements Comparable<Emp>
{
int  salary;
Emp(int salary)
{
this.salary=salary;
}
public int compareTo(Emp  t)
{
System.out.println("CompareTo");
if(this.salary>t.salary)
return  1;
else if(this.salary<t.salary)
return  -1;
else
return 0;
}
}
