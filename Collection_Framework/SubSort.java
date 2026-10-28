/*public static void sort(byte array[])
public static void sort(byte array[], int fromIndex, int toIndex)
public static void sort(char array[])
public static void sort(char array[], int fromIndex, int toIndex)
public static void sort(double array[])
public static void sort(double array[], int fromIndex, int toIndex)
public static void sort(float array[])
public static void sort(float array[], int fromIndex, int toIndex)
public static void sort(int array[])
public static void sort(int array[], int fromIndex, int toIndex)
public static void sort(long array[])
public static void sort(long array[], int fromIndex, int toIndex)
public static void sort(short array[])
public static void sort(short array[], int fromIndex, int toIndex)*/

import java.util.Arrays;
public class SubSort {
  public static void main(String[] a) {
    int array[] = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };
 for (int i : array) {
      System.out.print(i);
    }
System.out.println("  ");
    Arrays.sort(array, 3, 7);

    for (int i : array) {
      System.out.print(i);
    }
  }
}
