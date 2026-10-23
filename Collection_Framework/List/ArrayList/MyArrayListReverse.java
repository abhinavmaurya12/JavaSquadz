import java.util.ArrayList;
import java.util.Collections;

public class MyArrayListReverse {

    public static void main(String a[])
{
        ArrayList<Emp> list = new ArrayList<Emp>();
        list.add(new Emp(1001));
       list.add(new Emp(1002));
       list.add(new Emp(1003));
       list.add(new Emp(1004));
        list.add(new Emp(1005));
System.out.println("Actual List:");
for(Emp  e: list){
            System.out.println(e.id);
        }
        Collections.reverse(list);
        System.out.println("Results after reverse operation:");
        for(Emp  e1: list){
            System.out.println(e1.id);
        }
    }
}

class Emp
{
int id;
Emp(int id)
{
this.id=id;
}
}
