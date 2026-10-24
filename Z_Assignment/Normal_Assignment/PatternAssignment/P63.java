public class P63 {
    public static void main(String args[]){
         
        for(int i=1; i<=5; i++){
          int num = 2 * i - 1;
            for(int space=1; space<=5-i; space++){
                System.out.print("  ");
            }
            for(int j=1; j<=i; j++){
                System.out.print(num+" ");
                num--;
            }
          
            System.out.println();
        }

    }
//            1
//          3 2
//        5 4 3
//      7 6 5 4
//    9 8 7 6 5

}
