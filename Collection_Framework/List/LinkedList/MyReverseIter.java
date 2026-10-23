import java.util.Iterator;
import java.util.LinkedList;

public class MyReverseIter {

    public static void main(String a[])
{


        LinkedList<String> arrl = new LinkedList<String>();
        arrl.add("First");
        arrl.add("Second");
        arrl.add("Third");
        arrl.add("Random");
        Iterator<String> itr = arrl.descendingIterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
