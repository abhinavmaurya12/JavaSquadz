public class P75 {
    public static void main(String args[]){
        for(int i=1; i<=5; i++){
            char ch='A';
            for(int space=1; space<=5-i; space++){
                System.out.print("  ");
            }
            for(int j=1; j<=i; j++){
                System.out.print(ch+" ");
                ch++;
            }
          for (int j = i - 2; j >= 0; j--) {
                System.out.print((char)('A' + j) + " ");
            }
            System.out.println();
        }
    }
    
}
//         A 
//       A B A 
//     A B C B A 
//   A B C D C B A 
// A B C D E D C B A 
