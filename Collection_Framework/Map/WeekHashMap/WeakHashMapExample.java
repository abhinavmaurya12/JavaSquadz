/*It is exactly same as HashMap except the below difference.

    HashMap object is not eligible for Garbage collector even though it does not have any
    external references if it associated with HashMap.
    Key of WeakHashMap has weak reference. I.e if the key is garbage collected, and then
    entry in WeakHashMap object will be deleted automatically. This is not the case in
    HashMap. */


import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapExample
{

    public static void main(String[] args)
    {

        Map hashMap= new HashMap();

        Map weakHashMap = new WeakHashMap();

        Temporary t1 = new Temporary();
        Temporary t2 = new Temporary();

        hashMap.put(t1,"sai");
        System.out.println("Before HashMap gets garbage collected");
        System.out.println(hashMap);
        t1=null;
        System.gc();
        System.out.println("After HashMap gets garbage collected");
        System.out.println(hashMap);

        weakHashMap.put(t2,"sai");
        System.out.println("Before WeakHashMap gets garbage collected");
        System.out.println(weakHashMap);
        t2=null;
        System.gc();
        System.out.println("After WeakHashMap gets garbage collected");
        System.out.println(weakHashMap);
    }
}

class Temporary
{


    public String toString() {
        return "Temporary";
    }

    public void finalize(){
        System.out.println("Finalize method called");
    }
}
