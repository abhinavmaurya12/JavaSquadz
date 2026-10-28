import java.util.Arrays;
import java.util.Collections;

public class ReverseOrder {
    public static void main(String[] args) {
        Integer[] arrayToSort = new Integer[] {
            new Integer(5),
            new Integer(89),
            new Integer(16),
            new Integer(2)
        };

        Arrays.sort(arrayToSort, Collections.reverseOrder());

        for (Integer i : arrayToSort) {
            System.out.println(i.intValue());
        }
    }
}
