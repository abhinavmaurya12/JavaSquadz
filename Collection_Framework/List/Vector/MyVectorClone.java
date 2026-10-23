import java.util.Vector;

public class MyVectorClone {
    public static void main(String a[]){
        Vector<String> vct = new Vector<String>();
        //adding elements to the end
        vct.add("First");
        vct.add("Second");
        vct.add("Third");
        vct.add("Random");
        System.out.println("Actual vector:"+vct);
        Vector<String> copy = (Vector<String>) vct.clone();
        System.out.println("Cloned vector:"+copy);
    }
}
