public class P67 {
    public static void main(String args[]){
        char ch='A';
        for(int i=1; i<=5; i++){
            for(int space=1; space<=5-i; space++){
                System.out.print("  ");
            }
            for(int j=1; j<=(2*i-1); j++){
                System.out.print(ch+" ");
            }
            ch++;
            System.out.println();
        }
    }
    
}
