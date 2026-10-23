import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ManyToOne
{
  public static void main(String[]  s1) {
    Map<Integer, List<String>> mapOfIntStrs = new HashMap<Integer, List<String>>();

    add(mapOfIntStrs, 1, "one");
    add(mapOfIntStrs, 1, "two");
    add(mapOfIntStrs, 1, "three");
    add(mapOfIntStrs, 2, "four");
    add(mapOfIntStrs, 2, "five");
    add(mapOfIntStrs, 3, "six");
    add(mapOfIntStrs, 3, "seven");


    Set<Integer> keySet = mapOfIntStrs.keySet();

    for (int i: keySet)
    {
      List<String> strList = mapOfIntStrs.get(i);
      System.out.println(i);
      for (String s : strList)
      {
        System.out.println("  " + s);
      }
    }
  }

  private static final void add(
      Map<Integer, List<String>> mapTo_addTo, int keyNum, String value)
      {
    if (mapTo_addTo.containsKey(keyNum)) {
      mapTo_addTo.get(keyNum).add(value);
    } else {
      List<String> strList = new ArrayList<String>();
      strList.add(value);
      mapTo_addTo.put(keyNum, strList);
    }
  }
}
