public class GenMethDemo
{

  // Determine if an object is in an array.
  static <T, V extends T> boolean isIn(T x, V y[]) {

    for(int i=0; i < y.length; i++)
      if(x.equals(y[i])) return true;

    return false;
  }

  static <T extends Number> double add(T x, T y)
  {
    double d = x.doubleValue() + y.doubleValue();
    return d;
  }

  public static void main(String args[])
  {

    // Use isIn() on Integers.
    Integer nums[] = { 1, 2, 3, 4, 5 };

    if(isIn(2, nums))
      System.out.println("2 is in nums");

    if(!isIn(7, nums))
      System.out.println("7 is not in nums");

    System.out.println();

    // Use isIn() on Strings.
    String strs[] = { "one", "two", "three",
                      "four", "five" };

    if(isIn("two", strs))
      System.out.println("two is in strs");

    if(!isIn("seven", strs))
      System.out.println("seven is not in strs");

    System.out.println(add(10,20));
    System.out.println(add(10.5f,20.5f));
    System.out.println(add(10.5,20.5));
    System.out.println(add(1001,2001));

  }
}
