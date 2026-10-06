class Gen<T>
{
    T ob; // declare an object of type T
    int z;
    Gen(T o, int z)
    {
        ob = o;
        this.z = z;
    }

    T getob()
    {
        System.out.println("value of z=" + z);
        return ob;
    }

    void showType()
    {
        Class c = ob.getClass();
        System.out.println("Type of T is " + c.getName());
    }
}

public class GenDemo
{
    public static void main(String args[])
    {

        Gen<Integer> iOb = new Gen<Integer>(98, 100);

        iOb.showType();

        int v = iOb.getob();
        System.out.println("value: " + v);

        System.out.println();

        //Gen<String> strOb = new Gen<>("Generics Test",200);
        Gen<String> strOb = new Gen<String>("Generics Test", 200);
        strOb.showType();

        String str = strOb.getob();
        System.out.println("value: " + str);
        Emp e1 = new Emp();
        Gen<Emp> eOb = new Gen<Emp>(e1, 300);
        eOb.showType();
        Emp e2 = eOb.getob();
        System.out.println("value: " + e2.x);
        //iOb=strOb;

    }
}

class Emp
{
    int x = 200;
}
