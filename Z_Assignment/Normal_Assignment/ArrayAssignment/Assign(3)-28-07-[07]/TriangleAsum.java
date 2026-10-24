class TriangleAsum {
    static void TriangleAsum(int x[][]) {
        int sum = 0;

        // Upper Triangle Sum
        for (int i = 0; i < x.length; i++)
            for (int j = i; j < x[i].length; j++)
                sum += x[i][j];

        System.out.println("      Matrix                 Asum\n");

        // Print Matrix + Asum
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
        TriangleAsum(x);
    }
}