import java.util.HashSet;

public class MyDistElementEx
{

    public static void main(String a[]){

        HashSet<Price> lhm = new HashSet<Price>();
        lhm.add(new Price("Banana", 20));
        lhm.add(new Price("Apple", 40));
        lhm.add(new Price("Orange", 30));
        for(Price pr:lhm){
            System.out.println(pr);
        }
        Price key= new Price("Banana", 20);

        System.out.println("Does set contains key? "+lhm.contains(key));
        System.out.println("inserting duplicate object...");
        lhm.add(key);
System.out.println("deleting key from set...");
        lhm.remove(key);
        System.out.println("After insertion:");
        for(Price pr:lhm){
            System.out.println(pr);
        }
    }
}

class Price{

    private String item;
    private int price;

    public Price(String itm, int pr)
{
        this.item = itm;
        this.price = pr;
    }

    public int hashCode()
{
        System.out.println("In hashcode");
        int hashcode = 0;
        hashcode = price*20;
        hashcode += item.hashCode();
        return hashcode;
    }

    public boolean equals(Object obj)
{
        System.out.println("In equals");
        if (obj instanceof Price) {
            Price pp = (Price) obj;
            return (pp.item.equals(this.item) && pp.price == this.price);
        } else {
            return false;
        }
    }



    public String toString()
{
        return "item: "+item+"  price: "+price;
    }
}
