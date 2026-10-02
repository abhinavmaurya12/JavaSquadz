import java.util.*;
class Array_home07
{
public static void main(String args[])
{ // using equals() method
// int num1[]={1,2,3,4,5,6,7,8,9};
// int num2[]={1,2,3,4,5,6,7,8,9};
// int num3[]={4,3,2,1,5,6,7,8,9};

// System.out.println("using == : " + (num1==num2)); // we compare the address of num1 and num2
// System.out.println("using arrays equals() method : " + Arrays.equals(num1,num2)); // compare elements
// System.out.println("using arrays equals() method : " + Arrays.equals(num3,num2)); // compare elements

int num1[]={1,2,3,4,5,6};
int num2[]={1,2,3,4,5,6};
int num3[]={1,2,3,4,5,6};

System.out.println((num1==num2));
System.out.println(Arrays.equals(num1,num2));
System.out.println(Arrays.equals(num3,num2));

}
}