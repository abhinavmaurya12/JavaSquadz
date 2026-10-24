class FindMean33
{
    static float findMean(int x[])
    {
        int sum = 0;

        for(int i = 0; i < x.length; i++)
        {
            sum = sum + x[i];
        }
       return (float)sum / x.length;
    }
    public static void main(String args[])
    {
        int x[] = {10, 20, 30, 40, 50};
        System.out.println("Mean = " + findMean(x));
    }
}