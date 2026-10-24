class MakeAllElementZero35_1
{
    static void makeZero(int x[][])
    {
        boolean foundZero = false;

        // Check if any element is 0
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                if(x[i][j] == 0)
                {
                    foundZero = true;
                }
            }
        }
        // If zero found, make all elements zero
        if(foundZero)
        {
            for(int i = 0; i < 5; i++)
            {
                for(int j = 0; j < 5; j++)
                {
                    x[i][j] = 0;
                }
            }
        }
    }
    public static void main(String args[])
    {
        int x[][] = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}
        };
        makeZero(x);
		
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                System.out.print(x[i][j] + " ");
            }
            System.out.println();
        }
    }
}