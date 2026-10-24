class Reverse4
{
    static String reverse(String s)
    {
        String r = "";
        for(int i = s.length() - 1; i >= 0; i--)
        {
            r = r + s.substring(i, i + 1);
        }
        return r;
    }
    public static void main(String args[])
    {
        String s = "HELLO";

        System.out.println(reverse(s));
    }
}