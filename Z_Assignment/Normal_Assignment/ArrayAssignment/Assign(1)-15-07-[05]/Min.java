class Min {

    static int min(int x[]) {
        int min = x[0];

        for (int i = 1; i < x.length; i++) {
            if (x[i] < min) {
                min = x[i];
            }
        }

        return min;
    }

    public static void main(String[] args) {

        int arr[] = {25, 10, 89, 45, 67, 99, 12};

        System.out.println("Minimum Element = " + min(arr));
    }
}