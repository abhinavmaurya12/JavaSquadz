class Palindrome5
{
    static boolean palindromo(String s)
    {
        String r = "";
        for(int i = s.length() - 1; i >= 0; i--)
        {
            r = r + s.substring(i, i + 1);
        }
        if(s.equals(r))
            return true;
        else
            return false;
    }
    public static void main(String args[])
    {
        String s = "MADAM";
        System.out.println(palindromo(s));
    }
}