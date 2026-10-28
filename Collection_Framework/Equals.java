/*public static boolean equals(boolean a[], boolean array2[])
public static boolean equals(byte array1[], byte array2[])
public static boolean equals(char array1[], char array2[])
public static boolean equals(double array1[], double array2[])
public static boolean equals(float array1[], float array2[])
public static boolean equals(int array1[], int array2[])
public static boolean equals(long array1[], long array2[])
public static boolean equals(short array1[], short array2[])
public static boolean equals(Object array1[], Object array2[])*/

import java.util.Arrays;
public class Equals
{
  public static void main(String[] a)
{
    int[] i = new int[] { 1, 2, 3 };
    int[] j = new int[] { 1, 2, 3};
    System.out.println(Arrays.equals(i, j));
  }
}
