class CharCount3
{
    static int charCount(String s)
    {
        s = s.replace(" ", "");
        return s.length();
    }
    public static void main(String args[])
    {
        String s = "I am learning Java";
        System.out.println(" Character Count = " + charCount(s));
    }
}