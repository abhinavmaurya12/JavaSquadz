import java.util.Arrays;
class Array_home03
{
public static void main(String args[])
{
// int arr[] ={1,3,2,5,9,6,7,0}; //unsorted arrays

// System.out.println("Unsorted arrays...");
// for(int i=0; i<arr.length; i++){
// System.out.println(arr[i] + " ");
// }

// Arrays.sort(arr); //sorting arrays
// System.out.println();

// System.out.println("Sorted arrays...");
// for(int i=0; i<arr.length; i++){
// System.out.println(arr[i] + " ");
// }

int arr[]={1,2,3,56,3,2,7,8,90,342};
Arrays.sort(arr);
for(int i=0; i<arr.length; i++){
    System.out.print(arr[i]+" ");
}
}
}

