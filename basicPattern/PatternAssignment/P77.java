public class P77 {
    public static void main(String args[]){
        for(int i=1; i<=5; i++){
            char ch='a';
            for(int space=1; space<=5-i; space++){
                System.out.print("  ");
            }
            for(int j=1; j<=(2*i-1); j++){
                if(i%2==0){
                    System.out.print(ch+" ");
                    ch++;
                }
                else{
                System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
    
}

//         * 
//       a b c 
//     * * * * * 
//   a b c d e f g 
// * * * * * * * * *
