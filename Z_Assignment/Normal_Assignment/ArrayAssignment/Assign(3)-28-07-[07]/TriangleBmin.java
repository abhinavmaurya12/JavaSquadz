class TriangleBmin {
    static void Bmin(int x[][]) {
        int min = x[0][0];

        // Lower Triangle Minimum
        for (int i = 0; i < x.length; i++)
            for (int j = 0; j <= i; j++)
                if (x[i][j] < min)
                    min = x[i][j];

        System.out.println("      Matrix                 Bmin\n");

        // Print Matrix + Bmin
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++)
                System.out.print("      " + x[i][j]);
            if (i == 0)
                System.out.print("           " + min);
            System.out.println();
        }
    }
    public static void main(String args[]) {
        int x[][] = {
            {3, 2, 3},
            {4, 5, 6},
            {1, 8, 9}
        };
        Bmin(x);
    }
}