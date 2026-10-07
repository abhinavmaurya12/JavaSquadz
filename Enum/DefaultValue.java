enum Week
{
  Monday, Tuesday, Wednesday, Thursday, Friday, Saturaday, Sunday
}

public class DefaultValue
{
  public static void main(String args[])
{

    // Obtain all ordinal values using ordinal().
    System.out.println("Here are all week constants" + " and their ordinal values: ");
Week   day1[]=Week.values();
for(int i=0;i<day1.length;i++)
{
System.out.print(day1[i]+"=");
System.out.println(day1[i].ordinal());
}
    for (Week day : Week.values())
      System.out.println(day + " " + day.ordinal());
}
}
