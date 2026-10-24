class P58
{
    public static void main(String args[])
    {
        int n = 5;

        for(int i = 1; i <= n; i++)
        {
            int x;

            if(i == 1)
                x = 1;
            else if(i == 5)
                x = 1;
            else
                x = 0;

            for(int j = 1; j <= n - i + 1; j++)
            {
                System.out.print(x);

                if(x == 1)
                    x = 0;
                else
                    x = 1;
            }

            System.out.println();
        }
    }
}