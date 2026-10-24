public class P74 {
    public static void main(String args[]){
        for(int i=1; i<=5; i++){
            int num=i-1;
            for(int space=1; space<=5-i; space++){
                System.out.print("  ");
            }
            for(int j=1; j<=i; j++){
                System.out.print(num+" ");
                num--;
            }
            for(int j=1; j<i; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    
}
//         0 
//       1 0 1 
//     2 1 0 1 2 
//   3 2 1 0 1 2 3 
// 4 3 2 1 0 1 2 3 4 
