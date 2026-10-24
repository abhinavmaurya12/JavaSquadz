class WordCount1
{
    static int wordCount(String s)
    {
        int count = 0;
        while(s.indexOf(" ") != -1)
        {
            count++;
            s = s.substring(s.indexOf(" ") + 1);
        }
        return count + 1;
    }
    public static void main(String args[])
    {
        String s = "I am learning Java";
        System.out.println(" Word Count is : " + wordCount(s));
    }
}