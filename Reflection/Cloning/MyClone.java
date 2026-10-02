class Temp
{
    int g;
    Temp(int g)
    {
        this.g=g;
    }
}
class MyClone implements Cloneable
{
    int x=10;
    Temp t;

    MyClone(int a)
    {
        t=new Temp(a);
    }
    public MyClone clone()
    {
        //shallow copy
        try {
            return (MyClone) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public static void main(String... s)
    {
        MyClone c=null;
        MyClone m=new MyClone(100);
        System.out.println("m.t.g"+m.t.g);
        System.out.println("m.x"+m.x);
        try
        {
            c=m.clone();
        }catch(Exception e){ }
        System.out.println("c"+c.t.g);
        System.out.println("c.x"+c.x);
        c.t.g=3000;
        c.x=30;

        System.out.println("m after changes"+m.t.g);
        System.out.println("m after changes"+m.x);
        if(m.t==c.t)
        {
            System.out.println("shallow cloning");
        }
    }
}