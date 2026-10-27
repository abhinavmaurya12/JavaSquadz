import java.lang.reflect.Array;

public class CheckArrayType
{
  public static void main (String args[]) {
    int[] z = {1,2,3};
    Class type = z.getClass();
    if (type.isArray()) {
      Class elementType = type.getComponentType();
      System.out.println("Array of: " + elementType);
      System.out.println("Length: " + Array.getLength(z));
    }
  }
}
