class PrintTrianglewise28
{
    static void printtrianglewise(int x[])
    {
        int k = 0;
        for(int i = 1; k < x.length; i++)
        {
            for(int j = 1; j <= i && k < x.length; j++)
            {
                System.out.print(x[k] + " ");
                k++;
            }
            System.out.println();
        }
    }
    public static void main(String args[])
    {
        int x[] = {1,2,3,4,5,6,7,8,9,10};
        printtrianglewise(x);
    }
}