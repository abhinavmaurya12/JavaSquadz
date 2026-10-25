import java.util.NavigableMap;
import java.util.*;


public class NavigableMapHeadMap {

    public static void main(String args[]) {


        NavigableMap<String, String> navigableMap = new TreeMap<String, String>();

        navigableMap.put("C++", "Good programming language");
       navigableMap.put("Java", "Best programming language");
        navigableMap.put("Scala", "Another JVM language");
        navigableMap.put("Python", "Language which Google use");
            System.out.println("SorteMap : " + navigableMap);

      //an example of headMap - returns NavigableMap whose key is less than specified
       // NavigableMap<String, String> headMap = navigableMap.headMap("Python",true);
SortedMap<String, String> headMap = navigableMap.headMap("Python");
        System.out.println("headMap created form navigableMap : " + headMap);
    }
}
