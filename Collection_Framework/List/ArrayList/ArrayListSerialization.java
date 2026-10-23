import java.util.ArrayList;
import java.io.*;
public class ArrayListSerialization
{
    public static void main(String [] args)
    {
        ArrayList<String> al=new ArrayList<String>();
        al.add("Hello");
        al.add("Hi");
        al.add("Howdy");

        try{
          FileOutputStream fos= new FileOutputStream("myfile");
          ObjectOutputStream oos= new ObjectOutputStream(fos);
          oos.writeObject(al);
          oos.close();
          fos.close();
System.out.println("after  deserialization");
 FileInputStream fin= new FileInputStream("myfile");
ObjectInputStream oin= new ObjectInputStream(fin);
ArrayList   al1=(ArrayList)oin.readObject();
System.out.println(al1);
        }catch(Exception ioe){
            ioe.printStackTrace();
          }
    }
}
