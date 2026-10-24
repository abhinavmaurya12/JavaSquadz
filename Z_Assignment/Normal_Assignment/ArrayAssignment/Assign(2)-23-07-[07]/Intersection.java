class Intersection 
{
    static void intersection(int x[], int y[]) {
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

        System.out.print("Intersection : ");

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++) {
                if (x[i] == y[j]) {
                    System.out.print(x[i] + " ");
                    break;
                }
            }
        }
    }
    public static void main(String args[]) {
        int x[] = {10, 20, 30, 40};
        int y[] = {30, 40, 50, 60};
        intersection(x, y);
    }
}