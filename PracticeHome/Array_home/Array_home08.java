import java.util.*;
class Array_home08
{ //use fill() method...
public static void main(String args[])
{

// int arr[]=new int[8]; // add the index of arrays...
// int arr1[]=new int[8];
// Arrays.fill(arr,3); // use fill method to fill the index with elements...
// for(int i=0; i<arr.length; i++){
//  System.out.print(arr[i] + " "); // 3 3 3 3 3 3 3 3 
//  }

//  System.out.println();

//  Arrays.fill(arr1, 3,7,5); // arrays=arr1,fromIndex=3,toIndex=7,value=5...
//  for(int j=0; j<arr1.length; j++){
// 	 System.out.print(arr1[j] + " "); // 0 0 0 5 5 5 5 0
//  }


 int arr[]=new int[8];
 int arr1[]=new int[8];

 Arrays.fill(arr,3);

 for(int i=0; i<arr.length; i++){
	System.out.print(arr[i]+" ");
 }
 System.out.println();

 Arrays.fill(arr1,3,7,5);
 for(int i=0; i<arr1.length; i++){
	System.out.print(arr1[i]+" ");
 }

 

 }
 }