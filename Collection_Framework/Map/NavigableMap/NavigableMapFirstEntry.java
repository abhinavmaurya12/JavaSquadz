import java.util.NavigableMap;
import java.util.TreeMap;


public class NavigableMapFirstEntry {

    public static void main(String args[]) {


        NavigableMap<String, String> navigableMap = new TreeMap<String, String>();
            navigableMap.put("C++", "Good programming language");
       navigableMap.put("Java", "Best programming language");
        navigableMap.put("Scala", "Another JVM language");
        navigableMap.put("Python", "Language which Google use");

        System.out.println("SorteMap : " + navigableMap);


        System.out.println("FirstEntry : " + navigableMap.firstEntry());

        System.out.println("LatEntry : " + navigableMap.lastEntry());
    }
}
