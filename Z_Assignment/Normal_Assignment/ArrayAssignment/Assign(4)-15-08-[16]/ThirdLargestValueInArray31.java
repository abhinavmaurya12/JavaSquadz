class ThirdLargestValueInArray31
{
    static int thirdLargest(int x[])
    {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for(int i = 0; i < x.length; i++)
        {
            if(x[i] > max1)
            {
                max3 = max2;
                max2 = max1;
                max1 = x[i];
            }
            else if(x[i] > max2)
            {
                max3 = max2;
                max2 = x[i];
            }
            else if(x[i] > max3)
            {
                max3 = x[i];
            }
        }
        return max3;
    }
    public static void main(String args[])
    {
        int x[] = {10, 40, 20, 50, 30};
        System.out.println(thirdLargest(x));
    }
}