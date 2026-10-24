class Printdigonalwise26
{
    static void printdigonalwise(int x[][])
    {
        for(int i = 0; i < x.length; i++)
        {
            for(int j = 0; j < x[i].length; j++)
            {
                if(x[i][j] == 0)
                {
                    // System.out.println("Zero Position = [" + i + "][" + j + "]");
                    if(i > 0)
                        System.out.println("Up = " + x[i-1][j]);
                    if(j > 0)
                        System.out.println("Before = " + x[i][j-1]);
                    if(j < x[i].length-1)
                        System.out.println("After = " + x[i][j+1]);
                    if(i < x.length-1)
                        System.out.println("Down = " + x[i+1][j]);
                }
            }
        }
    }
    public static void main(String args[])
    {
        int x[][] = {
            {10, 20, 30, 40, 50},
            {60, 70, 20, 90, 10},
            {11, 12, 0, 10, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}
        };
        printdigonalwise(x);
    }
}