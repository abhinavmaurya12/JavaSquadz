class TriangleAmax {
    static void Amax(int x[][]) {
        int max = x[0][0];

        // Upper Triangle Maximum
        for (int i = 0; i < x.length; i++)
            for (int j = i; j < x[i].length; j++)
                if (x[i][j] > max)
                    max = x[i][j];

        System.out.println("      Matrix                 Amax\n");

        // Print Matrix + Amax
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++)
                System.out.print("      " + x[i][j]);
            if (i == 0)
                System.out.print("           " + max);
            System.out.println();
        }
    }
    public static void main(String args[]) {
        int x[][] = {
            {3, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        Amax(x);
    }
}