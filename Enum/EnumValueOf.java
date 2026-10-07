enum Week {
  Monday, Tuesday, Wednesday, Thursday, Friday, Saturaday, Sunday
}

public class EnumValueOf
{
  public static void main(String args[]) {
    Week day;

    //
    day = Week.valueOf("Monday");
    System.out.println("day contains " + day);
    day = Week.valueOf("Tuesday");
    System.out.println("day contains " + day);
  }
}
