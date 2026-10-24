class HCF30
{
    static void hcf(int x[])
    {
        int hcf = x[0];
        for(int i = 1; i < x.length; i++)
        {
            int a = hcf;
            int b = x[i];

            while(b != 0)
            {
                int r = a % b;
                a = b;
                b = r;
            }
            hcf = a;
        }
        System.out.println("HCF = " + hcf);
    }
    public static void main(String args[])
    {
        int x[] = {12, 18, 24};
        hcf(x);
    }
}