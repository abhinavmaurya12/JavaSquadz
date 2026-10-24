class RightTrim7
{
    static String rightTrim(String s)
    {
        while(s.endsWith(" "))
        {
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }
    public static void main(String args[])
    {
        String s = "Hello Java      ";
        System.out.println(rightTrim(s));
    }
}