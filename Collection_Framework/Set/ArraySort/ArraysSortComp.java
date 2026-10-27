import java.util.*;

public class ArraysSortComp
{

  public static void main(String[] args)
{
    Empl[] e = new Empl[] {new Empl("lalu",101),new Empl("rabari",51),new Empl("meesa",21),
    new Empl("tej",11)};
Arrays.sort(e,new MySalaryComp());
        System.out.println("Sorted Array entries via Salary: ");
        for(Empl e1:e){
            System.out.println(e1.name+"="+e1.getSalary());
        }
 Arrays.sort(e,new MyNameComp());
 System.out.println("Sorted Array entries via Name: ");
 for(Empl e1:e){
            System.out.println(e1.name+"="+e1.getSalary());
        }
 }
}
class MySalaryComp implements Comparator<Empl>
{

    @Override
    public int compare(Empl e1, Empl e2) {
        if(e1.getSalary() > e2.getSalary()){
            return 1;
        } else {
            return -1;
        }
    }
}
class MyNameComp implements Comparator<Empl>{

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
return  salary;
}
}
