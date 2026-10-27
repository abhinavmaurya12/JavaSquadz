import java.util.Arrays;

public class ArraysSort {

  public static void main(String[] args) {
    int[] intArray = new int[] { 4, 5, 9, 0, 3, 5, 6, 2 };

    Arrays.sort(intArray);

    for (int i = 0; i < intArray.length; i++)
      System.out.println(intArray[i]);

    String[] stringArray = new String[] { "D", "E", "A", "C", "B" };

    Arrays.sort(stringArray);

    for (int i = 0; i < stringArray.length; i++)
      System.out.println(stringArray[i]);

  }
}
