public class P62 {
    public static void main(String args[]){

        for(int i=1; i<=5; i++){
            int num=i;
            for(int space=1; space<=5-i; space++){
                System.out.print("  ");
            }
            for(int j=1; j<=i; j++){
                System.out.print(num+" ");
                num++;
            }
            System.out.println();
        }

    }

       //  1
    //   2 3
  //   3 4 5
   //4 5 6 7
 //5 6 7 8 9
    
}
