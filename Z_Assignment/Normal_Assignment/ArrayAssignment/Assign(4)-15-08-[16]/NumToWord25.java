class NumToWord25
{
    static void numtoword(int x[])
    {
        String word[] = {
            "ZERO", "ONE", "TWO", "THREE", "FOUR",
            "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"
        };
        for(int i = 0; i < x.length; i++)
        {
            System.out.print(word[x[i]] + " ");
        }
    }
    public static void main(String args[])
    {
        int x[] = {1, 2, 3, 4, 5, 6};
        numtoword(x);
		System.out.println();
    }
}