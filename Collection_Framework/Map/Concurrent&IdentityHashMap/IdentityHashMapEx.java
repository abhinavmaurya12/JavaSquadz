/*Difference between IdentityHashMap and HashMap

Difference between IdentityHashmap vs HashMap in Java Interview question
Though both HashMap and IdentityHashMap implements Map interface, have fail-fast Iterator and non synchronized collections, following are some key differences between HashMap and IdentityHashMap in Java.


1) Main difference between HashMap vs IdentityHashMap is that IdentityHashMap uses equality operator "==" for 
comparing keys and values inside Map while HashMap uses equals method for comparing keys and values.

2) Unlike HashMap, who uses hashcode to find bucket location, IdentityHashMap also doesn't use hashCode() instead 
it uses System.identityHashCode(object).

3) Another key difference between IdentityHashMap and HashMap in Java is Speed. Since IdentityHashMap doesn't use 
equals() its comparatively faster than HashMap for object with expensive equals() and hashCode().

4) One more difference between HashMap and IdentityHashMap is Immutability of key. One of the basic requirement
 to safely store Objects in HashMap is keys needs to be immutable, IdentityHashMap doesn't require keys to be 
 immutable as it is not relied on equals and hashCode.*/

/*There is also a class called IdentityHashtable which is analogous to Hashtable in Java but its not part of 
standard JDK and available in com.sun... package.

Example of IdentityHashMap in Java
Here is an example of IdentityHashMap in Java which shows key difference between HashMap and IdentityHashMap 
in comparing Objects.  IdentityHashMap uses equality operator for comparison  instead of equals method in Java :*/

import java.util.IdentityHashMap;
import java.util.HashMap;

 class IdentityHashMapEx
{

    public static void main(String args[])
    {
        IdentityHashMap<String, String> identityMap = new IdentityHashMap<String, String>();
     HashMap<String, String> Map1 = new HashMap<String, String>();
        identityMap.put("sony", "bravia");
        identityMap.put(new String("sony"), "mobile");
      Map1.put("sony", "bravia");
        Map1.put(new String("sony"), "mobile");
        //size of identityMap should be 2 here because two strings are different objects
        System.out.println("Size of IdentityHashMap: " + identityMap.size());
System.out.println("Size of HashMap: " + Map1.size());
        System.out.println("IdentityHashMap: " + identityMap);
System.out.println("HashMap: " + Map1);

        identityMap.put("sony", "videogame");

         //size of identityMap still should be 2 because "sony" and "sony" is same object
        System.out.println("Size of IdentityHashMap: " + identityMap.size());
        System.out.println("IdentityHashMap: " + identityMap);


    }
}
