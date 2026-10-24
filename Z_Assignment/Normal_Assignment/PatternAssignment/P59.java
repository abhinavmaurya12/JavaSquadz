public class P59 {
    public static void main(String args[]){
        for(int i=5; i>=1; i--){
        int num=1;
            for(int j=i; j>=1; j--){
                if(i%2==0){
                    System.out.print(num+" ");
                    num++;
                }
                else{
                System.out.print("*"+" ");
                }
            }
            System.out.println();
        }
    }
}
// * * * * * 
// 1 2 3 4
// * * *
// 1 2
// *