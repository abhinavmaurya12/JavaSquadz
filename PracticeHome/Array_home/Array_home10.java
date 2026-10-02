import java.util.*;
class Array_home10
{
	
// public static int sum(int [] num) {
// int sum=0;
// for(int i=0; i<num.length; i++)
//  sum=sum+num[i];
//  return sum ;
//  }

public static int sum1(int []num){
int sum1=0;
for(int i=0; i<num.length; i++){
    sum1=sum1+num[i];
}
    return sum1;

 }
 public static void main(String args[]){
 int num[]={1,2,3,4,5,6,7};
//  System.out.println("Sum of arrays element: " + sum(num));
 System.out.println("Sum of arrays element: " + sum1(num));
 }
 

}
