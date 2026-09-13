public class P71 {
      public static void main(String args[]) {
   
    for(int i = 1; i <= 5; i++) {
         int num=1;
        for(int space = 1; space <= 5 - i; space++) {
            System.out.print("  ");
        }
        for(int j = 1; j <= 2 * i - 1; j++) {
            System.out.print(num + " ");
            num++;
        }
        System.out.println();
    }
}
}
