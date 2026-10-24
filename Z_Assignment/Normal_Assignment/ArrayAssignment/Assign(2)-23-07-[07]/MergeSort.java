class MergeSort 
{
    static void ms(int x[], int y[]) {
        int z[] = new int[x.length + y.length];

        int k = 0;
        for (int i = 0; i < x.length; i++) { // Copy x into z
            z[k] = x[i];
            k++;
        }

        for (int i = 0; i < y.length; i++) {  // Copy y into z
            z[k] = y[i];
            k++;
        }

        for (int i = 0; i < z.length - 1; i++) { // Sort z using temp
            for (int j = i + 1; j < z.length; j++) {
                if (z[i] > z[j]) {
                    int temp = z[i];
                    z[i] = z[j];
                    z[j] = temp;
                }
            }
        }
        System.out.println("Merged Sorted Array:"); // Print merged sorted array
        for (int i = 0; i < z.length; i++) {
            System.out.print(z[i] + " ");
        }
    }
    public static void main(String args[]) {
        int a[] = {5, 2, 8};
        int b[] = {9, 1, 6};
        ms(a, b);
    }
}