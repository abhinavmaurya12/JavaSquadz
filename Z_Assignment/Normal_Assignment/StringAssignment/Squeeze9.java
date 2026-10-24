class Squeeze9
{
    static String squeeze(String s)
    {
        s = s.replace(" ", "");
        return s;
    }
    public static void main(String args[])
    {
        String s = " I am learning Java ";
        System.out.println(squeeze(s));
    }
}