import java.util.ArrayList;

public class MyArrayListClone {

    public static void main(String a[])
    {
        ArrayList<String> arrl = new ArrayList<String>();
        //adding elements to the end
        arrl.add("First");
        arrl.add("Second");
        arrl.add("Third");
        arrl.add("Random");
        System.out.println("Actual ArrayList:"+arrl);
        ArrayList<String> copy = (ArrayList<String>) arrl.clone();
        System.out.println("Cloned ArrayList:"+copy);

        if(arrl.get(0)==copy.get(0))
        {
            System.out.println("shallow");
        }
        if(arrl!=copy)
        {
            System.out.println("clone");
        }
    }
}
