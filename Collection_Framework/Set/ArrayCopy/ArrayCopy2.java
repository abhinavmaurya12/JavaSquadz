public class ArrayCopy2 {
  public static void main(String[] args) {
    String[] letters = { "A", "I", "U", "E", "O" };

    String[] results = new String[3];

    System.arraycopy(letters, 0, results, 0, 3);

    for (int i = 0; i < results.length; i++)
    {
      System.out.println("result = " + results[i]);
    }
  }
}
/*  first index represent the first array
and last two index represent the position of second array*/
