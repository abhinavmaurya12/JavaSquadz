import java.util.*;
class Array_home09
{
public static void main(String args[])
{
// String str[]=new String[3];
// int num[]={1,2,3,4,5};

// Arrays.fill(str, "hello");
// System.out.println("print via loop...");
// for(int i=0; i<str.length; i++){
//  System.out.print(str[i] +", "); //print via loop...
//  }
//  System.out.println();
//  System.out.println();
 
//  System.out.println("print via toString...");
//  System.out.print(Arrays.toString(str)); //print via toString...
 
//  System.out.println();
//  System.out.println();
 
//   System.out.println("print via toString...");
//  System.out.print(Arrays.toString(num)); //print via toString...

 String str[]=new String[3];
 int num[]={1,2,3,4,5};

 Arrays.fill(str,"hello");
 
 for(int i=0; i<str.length; i++){
    System.out.print(str[i]+" "); // hello hello hello 
 }

 System.out.println();

 System.out.print(Arrays.toString(str)); // [hello, hello, hello]

 System.out.println();

 System.out.print(Arrays.toString(num)); // [1, 2, 3, 4, 5]

 System.out.println();

 for(int i=0; i<num.length; i++){
    System.out.print(num[i]+" "); // 1 2 3 4 5 
 }


 }
 }