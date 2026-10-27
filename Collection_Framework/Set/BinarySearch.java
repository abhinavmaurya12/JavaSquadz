import java.util.Arrays;

 class Main1
{
  public static void main(String[] args)
{
    byte bArray[] = { 1, 2, 4, 5 };
    Arrays.sort(bArray);

    byte searchValue = 2;

    int intResult = Arrays.binarySearch(bArray, searchValue);
    System.out.println("Result of binary search of 2 is : " + intResult);

    searchValue = 7;
    intResult = Arrays.binarySearch(bArray, searchValue);
    System.out.println("Result of binary search of 3 is : " + intResult);
  }
}

class Main2 {
 public static void main(String[] args) {
   char charArray[] = { 'a', 'b', 'd', 'e' };
   Arrays.sort(charArray);

   char searchValue = 'b';
   System.out.println(Arrays.binarySearch(charArray, searchValue));

   searchValue = 'z';
   System.out.println(Arrays.binarySearch(charArray, searchValue));

 }

}


//Performing Binary Search on Java double Array



class Main3 {
 public static void main(String[] args) {
   double doubleArray[] = { 1.3, 2.1, 4.7, 5.3 };
   Arrays.sort(doubleArray);

   double searchValue = 4.7;

   System.out.println(Arrays.binarySearch(doubleArray, searchValue));

   searchValue = 3.33;
   System.out.println(Arrays.binarySearch(doubleArray, searchValue));
 }
}

//Performing Binary Search on Java float Array Example



class Main4 {
 public static void main(String[] args) {
   float floatArray[] = { 1.2f, 2.1f, 4.7f, 5.3f };
   Arrays.sort(floatArray);

   float searchValue = 4.7f;
   System.out.println(Arrays.binarySearch(floatArray, searchValue));

   searchValue = 3.3f;
   System.out.println(Arrays.binarySearch(floatArray, searchValue));
 }
}


//Performing Binary Search on Java int Array



class Main5 {
 public static void main(String[] args) {
   int intArray[] = { 1, 2, 4, 5 };
   Arrays.sort(intArray);
   int searchValue = 2;
   System.out.println(Arrays.binarySearch(intArray, searchValue));

   searchValue = 3;
   System.out.println(Arrays.binarySearch(intArray, searchValue));
 }
}

//Performing Binary Search on Java long Array



class Main6 {
 public static void main(String[] args) {
   long longArray[] = { 1L, 2L, 4L, 5L };
   Arrays.sort(longArray);

   long searchValue = 2L;
   System.out.println(Arrays.binarySearch(longArray, searchValue));

   searchValue = 3;
   System.out.println(Arrays.binarySearch(longArray, searchValue));
 }
}

//Performing Binary Search on Java short Array



class Main7 {
 public static void main(String[] args) {
   short shortArray[] = { 1, 2, 4, 5 };
   Arrays.sort(shortArray);

   short searchValue = 2;
   System.out.println(Arrays.binarySearch(shortArray, searchValue));

   searchValue = 3;
   System.out.println(Arrays.binarySearch(shortArray, searchValue));
 }
}
