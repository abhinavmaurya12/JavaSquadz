import java.util.*;
public class Array_home26 {
    public static void main(String[] args) {

        //max nums
        // int nums[]={1,2,3,4,5,6,7};
        // int max=nums[0];
        // for (int i=0; i<nums.length; i++){
        //   if(nums[i]>max){
        //     max=nums[i];
        //   }

        // }
        // System.out.println(max);


        //min nums
        // int nums[]={105,203,37,457,65,64,90};
        // int min=nums[0];

        // for(int i=0; i<nums.length; i++){
        //     if(nums[i]<min){
        //         min=nums[i];
        //     }
        // }

        // System.out.println(min);

        //2D max
        // int nums[][]={{1,2,3},{4,5,6},{7,80,9}};
        // int max=nums[0][0];

        // for(int i=0; i<nums.length; i++){
        //     for(int j=0; j<nums[i].length; j++){
        //         if(nums[i][j]>max){
        //             max=nums[i][j];
        //         }
        //     }
        // }
        // System.out.println(max);


        //2D min
        // int nums[][]={{15,24,36},{4,5,6},{7,8,9}};
        // int min=nums[0][0];

        // for(int i=0; i<nums.length; i++){
        //     for(int j=0; j<nums[i].length; j++){
        //         if(nums[i][j]<min){
        //             min=nums[i][j];
        //         }
        //     }
        // }
        // System.out.println(min);

        
        //2D max for each rows
        // int nums[][]={{1,2,3},{4,5,69},{7,8,9}};
        // int row=1;

        // for(int i=0; i<nums.length; i++){
        // int max=nums[i][0];
        //     for(int j=0; j<nums[i].length; j++){
        //         if(nums[i][j]>max){
        //             max=nums[i][j];
        //         }

        //     }
        //     System.out.println("row:" + row + " max:" + max);
        //     row++;
        // }


        //2D min for each rows
        // int nums[][]={{12,30,4,5},{45,67,89,3},{45,67,85,23}};
        // int row=1;
        // for(int i=0; i<nums.length; i++){
        // int min=nums[i][0];
        //     for(int j=0; j<nums[i].length; j++){
        //         if(nums[i][j]<min){
        //             min=nums[i][j];
        //         }
                                                
        //     }
        //     System.out.println(" rows: "+ row + " min: "+ min);
        //     row++;
        // }

        //Because nums[i][0] means first element of the current row, while nums[0][0] always means first element



        //sort
        // int nums[]={1,3,2,8,9,5,4,0};
        // Arrays.sort(nums);
        // for(int i=0; i<nums.length; i++){
        //     System.out.print(nums[i] + " ");
        // }


      
        //2D sort for eacn rows
        // int nums[][]={{1,3,2},{8,9,5},{4,0,7}};
        // for(int i=0; i<nums.length; i++){
        //     Arrays.sort(nums[i]);
        //     for(int j=0; j<nums[i].length; j++){
        //         System.out.print( nums[i][j] +" ");
        //     }
        //     System.out.println();
        // }


        //intersection (same element are print)
        // int num1[]={10,20,30,40};
        // int num2[]={30,50,60,20};

        // for(int i=0; i<num1.length; i++){
        //     for(int j=0; j<num2.length; j++){
        //         if(num1[i]==num2[j]){
        //             System.out.print(num1[i]+" ");
        //         }
        //     }
        // }


        //matrix sum
        // int num1[]={1,2,3,4};
        // int num2[]={5,6,7,8};
        // int sum=num1[0]+num2[0];

        // for(int j=0; j<num2.length; j++){
        //     sum=num1[j]+num2[j];
        // System.out.print(sum+" ");
        // }


        //2D matrix sum
        // int num1[][]={{1,2,3},{4,5,6}};
        // int num2[][]={{1,1,1},{2,2,2}};
        
        // System.out.println("num1 elements are....");
        // for(int i=0; i<num1.length; i++){
        //     for(int j=0; j<num1[i].length; j++){
        //     System.out.print(num1[i][j]+ " ");
        //     }
        //     System.out.println();
        // }
        
        // System.out.println("num2 elements are....");
        // for(int i=0; i<num2.length; i++){
        //     for(int j=0; j<num2[i].length; j++){
        //     System.out.print(num2[i][j]+ " ");
        //     }
        //     System.out.println();
        // }
       
        // System.out.println("sum of  elements are....");
        // for(int i=0; i<num1.length; i++){
        //     for(int j=0; j<num2[i].length; j++){
        //        int sum=num1[i][j]+num2[i][j];
        //     System.out.print(sum+ " ");
        //     }
        //     System.out.println();
        // }












    }
}