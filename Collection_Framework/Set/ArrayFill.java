import java.util.Arrays;

public class ArrayFill {

  public static void main(String[] arg)
{

    double[] data = new double[5]; // An array of 5 values of type double
    Arrays.fill(data, 1.0);                              // Fill all elements of data with 1.0

    for (int i=0;i<data.length;i++)
{
      System.out.println(data[i]);
    }

  }
}
