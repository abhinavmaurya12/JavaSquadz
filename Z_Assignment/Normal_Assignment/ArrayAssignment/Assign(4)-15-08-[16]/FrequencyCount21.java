class FrequencyCount21
{
    static void frequencycount(int x[])
    {
        for(int i = 0; i < x.length; i++)
        {
            int count = 0;
            for(int j = 0; j < x.length; j++)
            {
                if(x[i] == x[j])
                    count++;
            }
            boolean found = false;

            for(int k = 0; k < i; k++)
            {
                if(x[i] == x[k])
                    found = true;
            }
            if(found == false)
                System.out.println(x[i] + " = " + count);
        }
    }
    public static void main(String args[])
    {
        int x[] = {10, 20, 10, 30, 20, 10};
        frequencycount(x);
    }
}