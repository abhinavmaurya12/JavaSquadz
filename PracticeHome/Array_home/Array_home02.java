import java.util.*;

class Array_home02
{
public static void main (String args[])
{

// int num[];
// System.out.printf("Enter the num "); // get size of array
// int arr = new Scanner(System.in).nextInt();
// num=new int [arr];

// System.out.println("Enter the elements"); // get element in array
// for(int i=0; i<num.length; i++){
// num[i]=new Scanner(System.in).nextInt();
// }

// System.out.print("the elements are .... ");
// for(int i=0; i<num.length; i++){ // print elements of array
// 	System.out.print(num[i] + " ");
// }

int num[];
System.out.println("enter the num to get size of array");
int arr=new Scanner(System.in).nextInt();
num=new int[arr];

System.out.println("enter the elements");
for(int i=0; i<num.length; i++){
	num[i]=new Scanner(System.in).nextInt();
}

System.out.println("The element are...");
for(int i=0; i<num.length; i++){
 System.out.print(num[i]+" ");
}

}
}