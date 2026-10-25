import java.util.NavigableMap;
import java.util.TreeMap;


public class NavigableMapFirstKey {

    public static void main(String args[]) {

                    NavigableMap<String, String> navigableMap = new TreeMap<String, String>();

        navigableMap.put("C++", "Good programming language");
       navigableMap.put("Java", "Best programming language");
        navigableMap.put("Scala", "Another JVM language");
        navigableMap.put("Python", "Language which Google use");

        System.out.println("SorteMap : " + navigableMap);


        System.out.println("FirstKey : " + navigableMap.firstKey());

        System.out.println("LatKey : " + navigableMap.lastKey());
    }
}
