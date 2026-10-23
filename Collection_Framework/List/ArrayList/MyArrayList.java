import java.util.*;
class MyArrayListDemo
{
    public static void main(String args[])
    {
MyArrayList<String> al=new MyArrayList<>(5);
//  MyArrayList al=new MyArrayList(5);
Iterator i=al.iterator();
al.add("Ram");
al.add("mohan");
al.add("sohan");
al.add("sita");
al.add("Gita");
i.remove();
al.add("reeta");
al.add("reeta");
al.add("reeta");

i.remove();
    System.out.println(al.size1());
    System.out.println(al.capacity());
    System.out.println(al);

    i.remove();
    while(i.hasNext())
    {
    System.out.println(i.next());
    }
    System.out.println(al.size1());
System.out.println(al.capacity());

    }

}


public class MyArrayList<T> implements Iterator
{
    int size1;
    Object objects[];
    float growth=.5f;
    int index=-1;
    int next=0;

    public MyArrayList()
    {
        size1=10;
        objects=new Object[size1];
    }

    public MyArrayList(int size1)
    {
        this.size1=size1;
        objects=new Object[size1];
    }



    public void add(T obj)
    {
        //System.out.println(obj.getClass().getName());
        if(index+1==size1)
        {
            int tempsize1=size1+(new Float(size1*growth)).intValue();
            Object tempobj[]=new Object[tempsize1];

            size1=tempsize1;
            for(int i=0;i<objects.length;i++)
            {
                tempobj[i]=objects[i];
            }
            objects=tempobj;
        }
        objects[++index]=obj;

    }

    public void addAll(T o[])
    {
        for (int i=0;i<o.length;i++)
            add(o[i]);
    }
    public boolean set(int i, T obj)
    {
        if(i<0) return false;
        else if(i>index)
        {
            add(obj);
            return true;
        }
        else{
            objects[i]=obj;
            return true;
        }


    }

    public String toString()
    {
        String str="";
        for(int i=0;i<=index;i++)
            str+="{ "+objects[i].toString()+" }";

        return str;
    }
    public int size1(){return index+1;}
    public void remove(){index--;}
    public boolean isEmpty(){return index==-1;}
    public int capacity(){return objects.length;}


    public Object next()
    {return objects[next++];}

    public boolean hasNext()
    {
        if(next>index)
            return false;
        else
            return true;
    }

    Iterator iterator()
    {
        return this;
    }

}
