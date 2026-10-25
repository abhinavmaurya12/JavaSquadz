import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapCeilingKey
{
  public static void main(String args[])
  {
    Calendar now = Calendar.getInstance();
   Locale locale = Locale.getDefault();
//Locale locale =new Locale("fr","FR");
    Map<String, Integer> names = now.getDisplayNames(Calendar.DAY_OF_WEEK, Calendar.LONG,
    locale);
System.out.println(names);
    NavigableMap<String, Integer> nav = new TreeMap<String, Integer>(names);
    System.out.printf("Whole list:%n%s%n", nav);
    System.out.printf("Key ceiling after Sunday: %s%n", nav.ceilingKey("Sunday"));
nav.remove("Sunday");
System.out.printf("Key ceiling after Sunday: %s%n", nav.ceilingKey("Sunday"));
  }
}
