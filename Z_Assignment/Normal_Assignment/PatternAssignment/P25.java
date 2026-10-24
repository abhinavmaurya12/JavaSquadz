class P25
{
public static void main(String args[])
{
   int i, j, n;
        for(i=1; i<=5; i++)
        {
            n = 2*i - 1;
            for(j=1; j<=i; j++)
            {
                System.out.print(n);
                n--;
            }
            System.out.println();
        }
}
}