class SequenceDiagonalwise27
{
    static void sequencedigonalwise(int x[][])
    {
        int n = x.length;
        // Upper diagonals
        for(int k = 0; k < n; k++)
        {
            for(int i = 0; i <= k; i++)
            {
                System.out.print(x[i][k-i] + " ");
            }

            System.out.println();
        }
        // Lower diagonals
        for(int k = 1; k < n; k++)
        {
            for(int i = k; i < n; i++)
            {
                System.out.print(x[i][n-1-(i-k)] + " ");
            }
            System.out.println();
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
        sequencedigonalwise(x);
    }
}