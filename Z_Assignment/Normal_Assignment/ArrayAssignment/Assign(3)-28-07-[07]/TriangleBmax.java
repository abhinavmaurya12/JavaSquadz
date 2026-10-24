class TriangleBmax {
    static void Bmax(int x[][]) {
        int max = x[0][0];

        // Lower Triangle Maximum
        for (int i = 0; i < x.length; i++)
            for (int j = 0; j <= i; j++)
                if (x[i][j] > max)
                    max = x[i][j];

        System.out.println("      Matrix                 Bmax\n");

        // Print Matrix + Bmax
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++)
                System.out.print("      " + x[i][j]);
            if (i == 0)
                System.out.print("          " + max);
            System.out.println();
        }
    }
    public static void main(String args[]) {
        int x[][] = {
            {3, 2, 3},
            {4, 1, 6},
            {7, 9, 8}
        };
        Bmax(x);
    }
}