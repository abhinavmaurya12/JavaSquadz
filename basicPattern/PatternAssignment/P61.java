public class P61 {
    public static void main(String args[]){
        for(int i=1; i<=5; i++){
            int num=i;
            for(int space=1; space<=5-i; space++){
                System.out.print("  ");
            }
            for(int j=i; j>=1; j--){
                System.out.print(num+" ");
                num--;
            }
            System.out.println();

        }

    }
    
        //1
      //2 1
    //3 2 1
  //4 3 2 1
//5 4 3 2 1
}
