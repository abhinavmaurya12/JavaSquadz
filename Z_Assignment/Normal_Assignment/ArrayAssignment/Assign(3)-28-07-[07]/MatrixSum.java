class MatrixSum {
    static void matrixsum(int x[][]) {
        int d1 = 0;
        int d2 = 0;
        System.out.println("           Matrix               Row Sum\n");

        // Matrix + Row Sum
        for (int i = 0; i < x.length; i++) {
            int rsum = 0;
            for (int j = 0; j < x[i].length; j++) {
                System.out.print("      " + x[i][j]);
                rsum = rsum + x[i][j];
                if (i == j)
                    d1 = d1 + x[i][j];
                if (i + j == x.length - 1)
                    d2 = d2 + x[i][j];
            }
            System.out.println("              " + rsum);
        }
        System.out.println();

        // Diagonal Sum
        System.out.println(" " + d2 + "                        " + d1 + "   Diagonal Sum");
        System.out.println();

        // Column Sum
        for (int j = 0; j < x[0].length; j++) {
            int csum = 0;
            for (int i = 0; i < x.length; i++) {
                csum = csum + x[i][j];
            }
            System.out.print("     " + csum);
        }
        System.out.println("           Column Sum");
    }
    public static void main(String args[]) {
        int x[][] = {
            {3, 2, 3},
            {4, 5, 6},
            {6, 8, 5}
        };
        matrixsum(x);
    }
}