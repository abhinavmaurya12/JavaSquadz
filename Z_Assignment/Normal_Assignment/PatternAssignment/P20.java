public class P20 {
    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {

            if (i % 2 == 1) {
                // Odd row -> *****
                for (int j = 1; j <= 5; j++) {
                    System.out.print("*");
                }
            } else {
                // Even row -> ABCDE
                for (char ch = 'A'; ch <= 'E'; ch++) {
                    System.out.print(ch);
                }
            }

            System.out.println();
        }
    }
}