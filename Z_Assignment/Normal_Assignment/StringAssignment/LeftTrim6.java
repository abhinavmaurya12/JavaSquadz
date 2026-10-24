class LeftTrim6
{
    static String ITrim(String s)
    {
        while(s.indexOf(" ") == 0)
        {
            s = s.substring(1);
        }
        return s;
    }
    public static void main(String args[])
    {
        String s = "     Hello Java";

        System.out.println(ITrim(s));
    }
}