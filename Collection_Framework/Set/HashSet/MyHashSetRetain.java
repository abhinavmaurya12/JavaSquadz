import java.util.HashSet;

public class MyHashSetRetain {

    public static void main(String a[]){
        HashSet<String> hs = new HashSet<String>();
        //add elements to HashSet
        System.out.println(hs);
        hs.add("first");
        hs.add("second");
        hs.add("third");
        hs.add("apple");
        hs.add("rat");
        HashSet<String> subSet = new  HashSet<String>();
        subSet.add("rat");
        subSet.add("second");
        subSet.add("first");
      subSet.add("lalu");
        hs.retainAll(subSet);
        System.out.println("HashSet content:");
        System.out.println(hs);
    }
}
