class MatrixAdd 
{
    static void matrixadd(int x[][], int y[][]) {
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

        // Matrix Addition
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                z[i][j] = x[i][j] + y[i][j];
            }
        }
        System.out.println("Addition Matrix Z:");
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
            {4, 9, 6},
            {7, 5, 2}
        };
        int y[][] = {
            {4, 3, 8},
            {22, 3, 12},
            {1, 2, 10}
        };
        matrixadd(x, y);
    }
}