class Union 
{
    static void union(int x[], int y[]) {
        System.out.print("Array X : ");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();

        System.out.print("Array Y : ");
        for (int i = 0; i < y.length; i++) {
            System.out.print(y[i] + " ");
        }
        System.out.println();
        
        int z[] = new int[x.length + y.length];
        int k = 0;
        for (int i = 0; i < x.length; i++) { // Copy all elements of x[]
            z[k] = x[i];
            k++;
        }

        for (int i = 0; i < y.length; i++) { // Add only unique elements of y[]
            boolean found = false;
            for (int j = 0; j < k; j++) {
                if (y[i] == z[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                z[k] = y[i];
                k++;
            }
        }
        System.out.print("Union Array Z : ");
        for (int i = 0; i < k; i++) {
            System.out.print(z[i] + " ");
        }
    }
    public static void main(String args[]) {
        int x[] = {10, 20, 30, 40};
        int y[] = {30, 40, 50, 60};
        union(x, y);
    }
}