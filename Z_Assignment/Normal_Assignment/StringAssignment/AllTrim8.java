class AllTrim8
{
    static String myTrim(String s)
    {
        while(s.startsWith(" "))
        {
            s = s.substring(1);
        }

        while(s.endsWith(" "))
        {
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }
    public static void main(String args[])
    {
        String s = "     Hello Java     ";
        System.out.println(myTrim(s));
    }
}