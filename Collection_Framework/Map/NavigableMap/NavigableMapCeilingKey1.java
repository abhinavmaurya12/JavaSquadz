import java.util.NavigableMap;
import java.util.TreeMap;


public class NavigableMapCeilingKey1 {

    public static void main(String args[]) {


        NavigableMap<String, String> navigableMap = new TreeMap<String, String>();

        navigableMap.put("C++", "Good programming language");
        navigableMap.put("Java", "Best programming language");
        navigableMap.put("Scala", "Another JVM language");
        navigableMap.put("Python", "Language which Google use");

        System.out.println("SorteMap : " + navigableMap);

      //ceilingKey returns key which is greater than or equal to specified key
        System.out.println("ceilingKey from Java: " + navigableMap.ceilingKey("Java"));
        navigableMap.remove("Java");
         System.out.println("ceilingKey from Java: " + navigableMap.ceilingKey("Java"));
    }
}
