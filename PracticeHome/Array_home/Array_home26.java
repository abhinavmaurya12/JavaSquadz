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

        //Because nums[i][0] means first element of the current row, while nums[0][0] 
        // always means first element



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


        //2D matrix multiplication
        // int num1[][] = {
        // {1, 2, 3},
        // {4, 5, 6}};
        // int num2[][] = {
        // {4, 3},
        // {2, 7},
        // {3, 1}};
        // int multi[][] = new int[num1.length][num2[0].length];
        // for (int i = 0; i < num1.length; i++) {
        //   for (int j = 0; j < num2[0].length; j++) {
        //    multi[i][j] = 0;
        //     for (int k = 0; k < num1[i].length; k++) {
        //      multi[i][j] += num1[i][k] * num2[k][j];
        //  }
        //   System.out.print(multi[i][j] + " ");
        // }
        // System.out.println();
        // }


        //2D matrix transpose (row_col - col_row)
        // int x[][]={{1,2,3},{4,5,6},{7,8,9}};
        // int z[][]=new int[3][3];

        // System.out.println("original matrix");
        // for(int i=0; i<x.length; i++){
        //     for(int j=0; j<x[i].length; j++){
        //         System.out.print(x[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        // System.out.println("transpose matrix");
        // for(int i=0; i<x.length; i++){
        //     for(int j=0; j<x[i].length; j++){
        //         z[i][j]=x[j][i];
        //     System.out.print(z[i][j]+" ");
        //     }
        //     System.out.println();
        // }

       
       
       
        //merge sort of x[] and y[] in z[]
        // int x[]={1,2,3,6};
        // int y[]={7,4,5,8};
        // int z[]=new int [x.length+y.length];
        // int k=0;

        // for(int i=0; i<x.length; i++){
        //     z[k]=x[i];
        //     k++;
        // }
        // for(int j=0; j<y.length; j++){
        //     z[k]=y[j];
        //     k++;
        // }
        
        // System.out.println("value of x");
        // for(int l=0; l<x.length; l++){
        //     System.out.print(x[l]+" ");
        // }
        // System.out.println();

        // System.out.println("value of y");
        // for(int l=0; l<y.length; l++){
        //     System.out.print(y[l]+" ");
        // }
        // System.out.println();

        // System.out.println("merge without sort");
        // for(int l=0; l<z.length; l++){
        //     System.out.print(z[l]+" ");
        // }
        // System.out.println();

        // System.out.println("merge with sort");
        // Arrays.sort(z);
        // for(int l=0; l<z.length; l++){
        //     System.out.print(z[l]+" ");
        // }




        //union of two arrays
        // int x[]={1,2,3,4,5};
        // int y[]={4,5,6,7,8};
        // int z[]=new int[x.length+y.length];

        // int k=0;
        // for(int i=0; i<x.length; i++){
        //     z[k]=x[i];
        //     k++;
        // }
        // for(int j=0; j<y.length; j++){
        //     z[k]=y[j];
        //     k++;
        // }

        // System.out.println("union of two arrays");
        // Arrays.sort(z);
        // for(int l=0; l<z.length; l++){
        //     if(l>0 && z[l]==z[l-1]){
        //         continue;
        //     }
        //     System.out.print(z[l]+" ");

        // }




        //martix addition all side
        // int x[][]={{1,2,4},{4,5,6},{7,8,9}};
        // System.out.println("     Given matrix          row sum");
        // for(int i=0; i<x.length; i++){
        // int sum=0;
        //     for(int j=0; j<x[i].length; j++){
        //         sum=sum+x[i][j];
        //         System.out.print("     "+x[i][j]);
        //     }  
        //         System.out.print("            "+sum+" ");
        //         System.out.println();
        // }
        
        // int d1=0;
        // int d2=0;
        // for(int i=0; i<x.length; i++){
        //     for(int j=0; j<x[i].length; j++){
        //         if(i==j){
        //             d1=d1+x[i][j];
        //         }   
        //         if(i+j==x.length-1){
        //             d2=d2+x[i][j];
        //         }
        //     } 
        // }
        //   System.out.print(d2 + "                   " + d1 + "   diagonal sum");
        //   System.out.println();

        //    System.out.print("csum ");
        // for(int i=0; i<x.length; i++){
        // int csum=0;
        //     for(int j=0; j<x[i].length; j++){
        //         csum=csum+x[j][i];
        //     }  
        //         System.out.print(csum+"    ");
        // }



        //Trangle Amin
        // int x[][]={{1,2,3},
        //            {4,5,6},
        //            {7,8,9}};
        // int min=x[0][0];

        // for (int i = 0; i < x.length; i++)
        //     for (int j = i; j < x[i].length; j++)
        //         if (x[i][j] < min)
        //             min = x[i][j];

        // for(int i=0; i<x.length; i++){
        //     for(int j=0; j<x[i].length; j++){
        //         System.out.print("      " + x[i][j]);
        //     }
        //     if (i == 0)
        //         System.out.print("           " + min);
        //         System.out.println();
        // }



        //Trangle Amax
        // int x[][]={{2,3,7},{6,8,4},{9,3,1}};
        // int max=x[0][0];

        // for(int i=0; i<x.length; i++){
        //     for(int j=i; j<x[i].length; j++){
        //         if(x[i][j]> max){
        //             max=x[i][j];
        //         }
        //     }
        // }

        // for(int i=0; i<x.length; i++){
        //     for(int j=0; j<x[i].length; j++){
        //         System.out.print(x[i][j]+" ");
        //     }
        //     if(i==0){
        //         System.out.print("     "+max);
        //     }
        //     System.out.println();
        // }



        //Trangle Bmin
        int x[][]={{1,2,3},
                  {6,7,8},
                  {4,9,0}};
        int min=x[0][0];

        for(int i=0; i<x.length; i++){
            for(int j=0; j<=i; j++){
                if(x[i][j]<min){
                    min=x[i][j];
                }
            }
        }

        for(int i=0; i<x.length; i++){
            for(int j=0; j<x[i].length; j++){
                System.out.print(x[i][j]+" ");
            }
            if(i==0){
                System.out.print("  "+min);

            }
            System.out.println();
        }




          
             






        











    }
    }
