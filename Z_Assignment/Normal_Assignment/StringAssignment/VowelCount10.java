class VowelCount10
{
   static int vowelCount(String s)
{
    int count = 0;
    for(int i = 0; i < s.length(); i++)
    {
        String ch = s.substring(i, i + 1);

        if(ch.equalsIgnoreCase("a") ||
           ch.equalsIgnoreCase("e") ||
           ch.equalsIgnoreCase("i") ||
           ch.equalsIgnoreCase("o") ||
           ch.equalsIgnoreCase("u"))
        {
            count++;
        }
    }
    return count;
}
    public static void main(String args[])
    {
        String s = "I am learning Java";
        System.out.println("Vowel Count = " + vowelCount(s));
    }
}




// with charAt()
        // for(int i = 0; i < s.length(); i++)
        // {
            // char ch = s.charAt(i);

            // if(ch == 'a' || ch == 'e' || ch == 'i' ||
               // ch == 'o' || ch == 'u' ||
               // ch == 'A' || ch == 'E' || ch == 'I' ||
               // ch == 'O' || ch == 'U')
            // {
                // count++;
            // }
        // }