import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
public class HashMapSyncExample
{
    public static void main(String args[])
    {

Map map= Collections.synchronizedMap(new HashMap<Integer, String>());
        map.put(2, "Anil");
       map.put(44, "Ajit");
        map.put(4, "Sachin");
        map.put(88, "XYZ");


        Set set = map.entrySet();
        synchronized(map)
        {
            Iterator i = set.iterator();
            // Display elements
            while(i.hasNext())
            {
               Map.Entry me = (Map.Entry)i.next();
               System.out.print(me.getKey() + ": ");
               System.out.println(me.getValue());
            }
        }
    }
}
