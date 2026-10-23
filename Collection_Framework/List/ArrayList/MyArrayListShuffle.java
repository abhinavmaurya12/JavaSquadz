import java.util.ArrayList;
import java.util.Collections;

public class MyArrayListShuffle
{

    public static void main(String a[]){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Java");
        list.add("Cric");
        list.add("Play");

         System.out.println("Results before shuffle operation:");
        for(String str: list)
            System.out.println(str);

        Collections.shuffle(list);
        System.out.println("Results after shuffle operation:");
        for(String str: list){
            System.out.println(str);
        }

        Collections.shuffle(list);
        System.out.println("Results after shuffle operation:");
        for(String str: list){
            System.out.println(str);
        }
    }
}
