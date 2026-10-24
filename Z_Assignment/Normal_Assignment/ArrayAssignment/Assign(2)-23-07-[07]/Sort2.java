class Sort2 
{
    static void sort(int x[][]) {
        int temp;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length - 1; j++) {
                for (int k = j + 1; k < x[i].length; k++) {
                    if (x[i][j] > x[i][k]) {
                        temp = x[i][j];
                        x[i][j] = x[i][k];
                        x[i][k] = temp;
                    }
                }
            }
        }
    }
    public static void main(String args[]) {
        int arr[][] = {
            {5, 2, 8},
            {9, 1, 6},
            {7, 4, 3}
        };

        sort(arr); // method call

        System.out.println("Sorted 2D Array:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}