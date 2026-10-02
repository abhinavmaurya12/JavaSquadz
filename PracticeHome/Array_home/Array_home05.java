import java.util.*;
class Array_home05
{
public static void main(String args[])
{
// int num[]={1,-8,9,8,6,4,3,2};
// System.out.println("unsorted arrays...");
// for(int i=0; i<num.length; i++){
// System.out.print(num[i] + " ");
// }

// Arrays.sort(num,4,8); // 1 -8 9 8 .2 3 4 6.
// System.out.println();

// System.out.println("sorted arrays...");
// for(int i=0; i<num.length; i++){
// System.out.print(num[i] + " ");
// }

int num[]={-2,4,-1,7,6,90,65,3,2,5,1};
for(int i=0; i<num.length; i++){
    System.out.print(num[i]+" ");    
}

// Arrays.sort(num);
Arrays.sort(num,3,11);
System.out.println();
for(int i=0; i<num.length; i++){
    System.out.print(num[i]+" ");
}
}
}