import java.util.NavigableMap;
import java.util.TreeMap;


public class NavigableMapHigherKey1 {

    public static void main(String args[]) {

        NavigableMap<String, String> navigableMap = new TreeMap<String, String>();

        navigableMap.put("C++", "Good programming language");
       navigableMap.put("Java", "Best programming language");
        navigableMap.put("Scala", "Another JVM language");
        navigableMap.put("Python", "Language which Google use");

        System.out.println("SorteMap : " + navigableMap);

      //higherKey returns key which is greater specified key
        System.out.println("higherKey from Java: " + navigableMap.higherKey("Java"));
//lowerKey returns key which is less than specified key
        System.out.println("lowerKey from Java : " + navigableMap.lowerKey("Java"));
    }
}
