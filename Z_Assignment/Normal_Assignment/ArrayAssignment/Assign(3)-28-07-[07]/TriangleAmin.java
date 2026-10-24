class TriangleAmin {
    static void Amin(int x[][]) {
        int min = x[0][0];

        // Upper Triangle Minimum
        for (int i = 0; i < x.length; i++)
            for (int j = i; j < x[i].length; j++)
                if (x[i][j] < min)
                    min = x[i][j];

        System.out.println("      Matrix                 Amin\n");

        // Print Matrix + Amin
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
            {7, 8, 9}
        };
        Amin(x);
    }
}