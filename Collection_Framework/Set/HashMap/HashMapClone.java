import java.util.HashMap;
import java.util.Map;

public class HashMapClone
{
    public static void main(String a[]) {
        HashMap hashMap = new HashMap();


        hashMap.put(1,"One");
        hashMap.put(2, "Two");
        hashMap.put(3, "Three");
        System.out.println("Original HashMap : " + hashMap);

     HashMap  hashMap1 = (HashMap) hashMap.clone();

        System.out.println("Copied HashMap : " + hashMap1);

    }
}
