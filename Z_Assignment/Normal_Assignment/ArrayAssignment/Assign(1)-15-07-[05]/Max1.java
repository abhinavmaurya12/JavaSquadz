class Max1 {

    static int max1(int x[][]) {

        int max = x[0][0];

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {

                if (x[i][j] > max) {
                    max = x[i][j];
                }

            }
        }

        return max;
    }

    public static void main(String[] args) {

        int arr[][] = {
            {10, 20, 30},
            {5, 60, 15},
            {25, 40, 50}
        };

        System.out.println("Maximum Element = " + max1(arr));
    }
}