class BinaryToDecimal23
{
    static int binarytodecimal(int x[])
    {
        int dec = 0;
        for(int i = 0; i < x.length; i++)
        {
            dec = dec * 2 + x[i];
        }
        return dec;
    }
    public static void main(String args[])
    {
        int x[] = {1, 0, 1, 1};
        System.out.println(binarytodecimal(x));
    }
}