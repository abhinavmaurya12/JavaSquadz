class TriangleBsum {
    static void TriangleBsum(int x[][]) {
        int sum = 0;

        // Lower Triangle Sum
        for (int i = 0; i < x.length; i++)
            for (int j = 0; j <= i; j++)
                sum += x[i][j];

        System.out.println("      Matrix                 Bsum\n");

        // Print Matrix + Bsum
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++)
                System.out.print("      " + x[i][j]);
            if (i == 0)
                System.out.print("          " + sum);
            System.out.println();
        }
    }
    public static void main(String args[]) {
        int x[][] = {
            {3, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        TriangleBsum(x);
    }
}