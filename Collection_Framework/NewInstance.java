import java.lang.reflect.Array;

public class NewInstance
{
  public static void main (String args[]) {
    int array[] = (int[])Array.newInstance(int.class, 5);
    for(int i: array){
      System.out.println(i);

    }
  }
}
