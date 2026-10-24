class FindMode34
{ //Mode: most frequently repeated value
    static int findMode(int x[])
    {
        int mode = x[0];
        int max = 0;

        for(int i = 0; i < x.length; i++)
        {
            int count = 0;

            for(int j = 0; j < x.length; j++)
            {
                if(x[i] == x[j])
                {
                    count++;
                }
            }
            if(count > max)
            {
                max = count;
                mode = x[i];
            }
        }
        return mode;
    }
    public static void main(String args[])
    {
        int x[] = {10, 20, 30, 20, 40, 20, 50};
        System.out.println("Mode = " + findMode(x));
    }
}