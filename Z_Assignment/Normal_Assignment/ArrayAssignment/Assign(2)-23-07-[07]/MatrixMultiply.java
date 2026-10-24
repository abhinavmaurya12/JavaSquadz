class MatrixMultiply
 {
    static void matrixmulti(int x[][], int y[][]) {

        int z[][] = new int[3][3];

        System.out.println("Matrix X:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(x[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Matrix Y:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(y[i][j] + " ");
            }
            System.out.println();
        }

        // Matrix Multiplication
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                z[i][j] = 0;
                for (int k = 0; k < 3; k++) {
                    z[i][j] = z[i][j] + x[i][k] * y[k][j];
                }
            }
        }
        System.out.println("Multiplication Matrix Z:");
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
        int y[][] = {
            {3, 2, 6},
            {1, 5, 4},
            {3, 2, 1}
        };
        matrixmulti(x, y);

    }
}