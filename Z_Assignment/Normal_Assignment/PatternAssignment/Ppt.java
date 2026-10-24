public class Ppt {
    public static void main(String[] args) {

        int[] space = {0, 1, 6, 1, 4};

        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < space[i]; j++)
                System.out.print(" ");

            for (int j = 0; j <= i; j++)
                System.out.print("*");

            System.out.println();
        }
    }
}