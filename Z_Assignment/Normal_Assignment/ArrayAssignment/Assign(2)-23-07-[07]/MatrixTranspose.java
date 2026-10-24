class MatrixTranspose 
{
    static void matrixtranspose(int x[][]) {
        int z[][] = new int[3][3];

        System.out.println("Original Matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(x[i][j] + " ");
            }
            System.out.println();
        }

        // Transpose
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                z[i][j] = x[j][i];
            }
        }

        System.out.println("Transpose Matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(z[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]) {
        int x[][] = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        matrixtranspose(x);
    }
}