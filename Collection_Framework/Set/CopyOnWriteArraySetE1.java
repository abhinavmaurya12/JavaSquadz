import java.util.HashMap;
import java.util.Iterator;
import java.util.*;
import java.util.concurrent.*;

public class CopyOnWriteArraySetE1 {

    public static void main(String[] args) {


        Set<String> myMap = new CopyOnWriteArraySet<String>();
        myMap.add("1");
        myMap.add("2");
        myMap.add("3");
        myMap.add("4");
        myMap.add("5");
        myMap.add("6");
        System.out.println("CopyOnWriteArraySet before iterator: "+myMap);
        Iterator<String> it = myMap.iterator();

        while(it.hasNext())
        {
            String key = it.next();
            if(key.equals("3")) myMap.add(key+"new");
        }
        System.out.println("CopyOnWriteArraySet after iterator: "+myMap);

        myMap = new HashSet<String>();
        myMap.add("1");
        myMap.add("2");
        myMap.add("3");
        myMap.add("4");
        myMap.add("5");
        myMap.add("6");
        System.out.println("HashSet before iterator: "+myMap);
        Iterator<String> it1 = myMap.iterator();

        while(it1.hasNext())
        {
            String key = it1.next();
            if(key.equals("3")) myMap.add(key+"new");
        }
        System.out.println("HashSet after iterator: "+myMap);
    }

}
