import java.util.NavigableMap;
import java.util.*;


public class NavigableMapHigherEntry
{
    public static void main(String args[])
{


        NavigableMap original = new TreeMap();
original.put("1", "1");
original.put("2", "2");
original.put("3", "3");
System.out.println(original);

//higherEntry will be ("3", "3").
Map.Entry higherEntry = original.higherEntry("2");
System.out.println(higherEntry);
//lowerEntry will be ("1", "1")
Map.Entry lowerEntry = original.lowerEntry("2");
System.out.println(lowerEntry);
    }
}
