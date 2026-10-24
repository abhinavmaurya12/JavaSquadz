class Grade
{
    public static void main(String args[])
    {
        System.out.println("Enter the marks:");
        int gd = new java.util.Scanner(System.in).nextInt();

        if (gd >= 80 && gd <= 100)
            System.out.println("Grade A");
        else if (gd >= 60)
            System.out.println("Grade B");
        else if (gd >= 50)
            System.out.println("Grade C");
        else if (gd >= 45)
            System.out.println("Grade D");
        else if (gd >= 25)
            System.out.println("Grade E");
        else if (gd >= 0)
            System.out.println("Grade F");
        else
            System.out.println("Invalid Marks");
    }
}