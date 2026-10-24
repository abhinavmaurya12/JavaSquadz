class SortwithOutsort {
// no built-in class ..import..
    static void sort(int x[]) {

        int temp;

        for (int i = 0; i < x.length - 1; i++) {
            for (int j = i + 1; j < x.length; j++) {

                if (x[i] > x[j]) {
                    temp = x[i];
                    x[i] = x[j];
                    x[j] = temp;
                }

            }
        }
    }

    public static void main(String[] args) {

        int arr[] = {25, 10, 89, 45, 67, 99, 12};

        sort(arr);

        System.out.println("Sorted Array:");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}