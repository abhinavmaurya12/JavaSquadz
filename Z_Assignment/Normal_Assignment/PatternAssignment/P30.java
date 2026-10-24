class P30
{
public static void main(String args[])
{
int i,j;
 for( i=1; i<=5; i++)
   {
    char ch = (char)('A' + i - 1);
            ch = (char)(ch + i - 1);

            for( j=1; j<=i; j++)
            {
                System.out.print(ch);
				ch--;
            }

            System.out.println();
        }
}
}