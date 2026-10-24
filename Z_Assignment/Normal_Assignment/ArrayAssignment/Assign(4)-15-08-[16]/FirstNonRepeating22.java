class FirstNonRepeating22
{
    static void firstnonrepeatingelement(int x[])
    {
        for(int i = 0; i < x.length; i++)
        {
            int count = 0;
            for(int j = 0; j < x.length; j++)
            {
                if(x[i] == x[j])
                    count++;
            }
            if(count == 1)
            {
                System.out.println("First Non-Repeating Element = " + x[i]);
                break;
            }
        }
    }
    public static void main(String args[])
    {
        int x[] = {10, 20, 30, 20, 10, 40};
        firstnonrepeatingelement(x);
    }
}