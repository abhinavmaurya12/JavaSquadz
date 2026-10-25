import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapLastKey {
  public static void main(String args[]) {
    Calendar now = Calendar.getInstance();
    Locale locale = Locale.getDefault();

    Map<String, Integer> names = now.getDisplayNames(Calendar.DAY_OF_WEEK, Calendar.LONG,
    locale);
    NavigableMap<String, Integer> nav = new TreeMap<String, Integer>(names);
    System.out.printf("Whole list:%n%s%n", nav);
    System.out.printf("Last key: %s\tLast entry: %s%n", nav.lastKey(), nav.lastEntry());
 System.out.printf("Key lower before Sunday: %s%n", nav.lowerKey("Sunday"));
 System.out.printf("Key floor before Sunday: %s%n", nav.floorKey("Sunday"));
 System.out.printf("Key ceiling after Sunday: %s%n", nav.ceilingKey("Sunday"));
  }
}
