class LCM29
{
    static void lcm(int x[])
    {
        int lcm = x[0];
        for(int i = 1; i < x.length; i++)
        {
            int a = lcm;
            int b = x[i];

            while(b != 0)
            {
                int r = a % b;
                a = b;
                b = r;
            }
            int hcf = a;
            lcm = (lcm * x[i]) / hcf;
        }
        System.out.println("LCM = " + lcm);
    }
    public static void main(String args[])
    {
        int x[] = {4, 6, 8};
        lcm(x);
    }
}