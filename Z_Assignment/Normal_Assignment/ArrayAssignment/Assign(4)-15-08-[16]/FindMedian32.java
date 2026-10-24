import java.util.Arrays;

class FindMedian32
{
    static float findMedian(int x[])
    {
        Arrays.sort(x);

        if(x.length % 2 != 0)
        {
            return x[x.length / 2];
        }
        else
        {
            return (x[x.length / 2 - 1] + x[x.length / 2]) / 2.0f;
        }
    }
    public static void main(String args[])
    {
        int x[] = {10, 40, 20, 30, 50};
        System.out.println("Median = " + findMedian(x));
    }
}