class MaxInOneRow24
{
    static void maxinonerow(int x[][])
    {
        int max = 0;
        int row = 0;
        for(int i = 0; i < x.length; i++)
        {
            int count = 0;
            for(int j = 0; j < x[i].length; j++)
            {
                if(x[i][j] == 1)
                    count++;
            }
            if(count > max)
            {
                max = count;
                row = i;
            }
        }
        System.out.println("Row = " + (row + 1));
        System.out.println("Maximum 1 = " + max);
    }
    public static void main(String args[])
    {
        int x[][] = {
            {0, 1, 0, 1, 0},
            {1, 1, 1, 0, 0},
            {0, 1, 1, 1, 1},
            {1, 0, 0, 1, 0},
            {0, 0, 1, 0, 0}
        };
        maxinonerow(x);
    }
}