import java.util.*;

public class ArrayToArrayList {
     public static void main(String[] args) {

       /* Array Declaration and initialization*/
       String citynames[]={"Agra", "Mysore", "Chandigarh", "Bhopal"};
List<String>   l=Arrays.asList(citynames);
System.out.println(l.getClass().getName());
//l.add("Meerut");//(not supported)
       /*Array to ArrayList conversion*/
       ArrayList<String> citylist= new ArrayList<String>(l);

       citylist.add("New City2");
       citylist.add("New City3");


       for (String str: citylist)
       {
          System.out.println(str);
             }
           }
}
