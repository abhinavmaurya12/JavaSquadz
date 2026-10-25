import java.util.NavigableMap;
import java.util.TreeMap;


public class NavigableMapFloorKey1 {

    public static void main(String args[]) {

        NavigableMap<String, String> navigableMap = new TreeMap<String, String>();

        navigableMap.put("C++", "Good programming language");
       navigableMap.put("Java", "Best programming language");
        navigableMap.put("Scala", "Another JVM language");
        navigableMap.put("Python", "Language which Google use");

        System.out.println("SorteMap : " + navigableMap);

      //floorKey returns key which is less than or equal to specified key
        System.out.println("floorKey from Java: " + navigableMap.floorKey("Java"));
        navigableMap.remove("Java");
        System.out.println(navigableMap.floorKey("Java"));

    }
}
