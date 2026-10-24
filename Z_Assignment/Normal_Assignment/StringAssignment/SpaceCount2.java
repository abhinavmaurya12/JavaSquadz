class SpaceCount2
{
    static int spaceCount(String s)
    {
        int count = 0;
        while(s.indexOf(" ") != -1)
        {
            count++;
            s = s.substring(s.indexOf(" ") + 1);
        }
        return count;
    }
    public static void main(String args[])
    {
        String s = "I am learning Java";

        System.out.println("Space Count = " + spaceCount(s));
    }
}