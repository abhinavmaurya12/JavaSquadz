public class ArrayCopy
{

  public static void main(String[] args)
{
    String[] names = new String[] { "A", "B", "C" };

    String[] extended = new String[5];

    extended[3] = "D";
    extended[4] = "F";

    System.arraycopy(names, 0, extended, 0, names.length);

    for (String str : extended)
      System.out.println(str);
  }
}
/*  first index represent the position of first array
and last two index represent the position of second array*/
