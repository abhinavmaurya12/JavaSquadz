import java.util.*;
class MyTreeSet
{
public static void main(String s1[])
{
Comparator<Empl> m1= new MySalaryComp();
Comparator<Empl>  m2= new MyNameComp();
TreeSet<Empl> t=new TreeSet<>(m1);
System.out.println("Sorting  with  Salary");
add(t);
show(t);
System.out.println("Sorting  with Name");
TreeSet<Empl> t1=new TreeSet<>(m2);
add(t1);
show(t1);
}

static  void  add(TreeSet<Empl>   t)
{
t.add(new   Empl("lalu",101));
t.add(new   Empl("bhalu",102));
t.add(new   Empl("rabari",51));
t.add(new   Empl("meesa",21));
}
static void  show(TreeSet<Empl>  t)
{
Iterator<Empl>   i=t.iterator();
while(i.hasNext())
{
Empl e=i.next();
System.out.println(e.name+"="+e.salary);
}
}

}
class MySalaryComp implements Comparator<Empl>{

    @Override
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

    @Override
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
return   salary;
}
}
