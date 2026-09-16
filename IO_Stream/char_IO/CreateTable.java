import java.io.FileInputStream;
import java.util.Scanner;

public class CreateTable
{
    public static void main(String s[])
    {

        try
        {


        //FileInputStream fin=new FileInputStream("tables_sql.txt");
        FileInputStream fin=new FileInputStream("lulu.txt");
        Scanner sc=new Scanner(fin);
        sc.useDelimiter("/");
        String name=" ";
        while(sc.hasNext())
        {
            name=sc.next();

            System.out.println(name);
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}