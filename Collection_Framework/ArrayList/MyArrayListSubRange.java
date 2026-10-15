import java.util.ArrayList;
import java.util.List;

public class MyArrayListSubRange {

    public static void main(String a[]){
        ArrayList<String> arrl = new ArrayList<String>();
        //adding elements to the end
        arrl.add("First");
        arrl.add("Second");
        arrl.add("Third");
        arrl.add("Random");
        arrl.add("Click");
        System.out.println("Actual ArrayList:"+arrl);
        List<String> list = arrl.subList(2, 4);
        System.out.println("Sub List: "+list);
    }
}
