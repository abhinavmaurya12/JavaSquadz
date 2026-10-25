import java.util.*;
import java.util.Map.Entry;
class MyTreeMap
{
public static void main(String s1[])
{
Comparator m1= new MySalaryComp();
Comparator m2= new MyNameComp();
TreeMap t=new TreeMap(m1);
System.out.println("Sorting  with  Salary");
add(t);
show(t);
Empl em = (Empl)t.firstKey();
        System.out.println("Lowest salary emp: "+em.salary);
        Entry<Empl,String> ent = t.firstEntry();
        System.out.println("Entry set values: ");
Empl   k=(Empl)ent.getKey();
        System.out.println(k.salary+" ==> "+ent.getValue());
System.out.println("Sorting  with Name");
TreeMap t1=new TreeMap(m2);
add(t1);
show(t1);
}

static  void  add(TreeMap  t)
{
t.put(new   Empl("lalau",101),"chaprasi");
t.put(new   Empl("bhalu",102),"sweaper");
t.put(new   Empl("rabari",51),"kaamwalibai");
t.put(new   Empl("meesa",21),"chotikaamwalibai");
}
static void  show(TreeMap  t)
{
Set s=t.entrySet();
Iterator i=s.iterator();
while(i.hasNext())
{
Map.Entry e=(Map.Entry)i.next();
Empl k=(Empl)e.getKey();
String v=(String)e.getValue();
System.out.println(k.name+"="+k.salary+" ,value="+v);
}
}

}
class MySalaryComp implements Comparator<Empl>
{


    public int compare(Empl e1, Empl e2) {
        if(e1.getSalary() > e2.getSalary()){
            return 1;
        } else {
            return -1;
        }
    }
}
class MyNameComp implements Comparator<Empl>
{


    public int compare(Empl e1, Empl e2)
{
        return   e1.name.compareTo(e2.name);
    }
}
class  Empl
{
String name;
int salary;
Empl(String name,int  salary)
{
this.name=name;
this.salary=salary;
}
int  getSalary()
{
return  salary;
}
}
