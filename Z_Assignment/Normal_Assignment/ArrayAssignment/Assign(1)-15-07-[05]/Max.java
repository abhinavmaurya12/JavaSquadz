class Max
{

static int max(int x[]) {
        int max = x[0];

        for (int i = 1; i < x.length; i++) {
            if (x[i] > max) {
                max = x[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {

        int arr[] = {25, 10, 89, 45, 67, 99, 12};

        System.out.println("Maximum Element = " + max(arr));
    }
	
}
