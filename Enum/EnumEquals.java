enum Week {
  Monday, Tuesday, Wednesday, Thursday, Friday, Saturaday, Sunday
}

public class EnumEquals {
  public static void main(String args[])
{

    Week day1, day2, day3;
    day1 = Week.Monday;
    day2 = Week.Monday;
    day3 = Week.Tuesday;

    if(day1.equals(day2))
      System.out.println("Error!");

    if(!day1.equals(day3))
      System.out.println(day1 + " not equals " + day3);

    if(day2 != day3)
      System.out.println(day2 + " != " + day3);
  }
}
