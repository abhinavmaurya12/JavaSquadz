class Min1 {

    static int min1(int x[][]) {

        int min = x[0][0];

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {

                if (x[i][j] < min) {
                    min = x[i][j];
                }

            }
        }

        return min;
    }

    public static void main(String[] args) {

        int arr[][] = {
            {10, 20, 30},
            {5, 60, 15},
            {25, 40, 50}
        };

        System.out.println("Minimum Element = " + min1(arr));
    }
}