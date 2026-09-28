public class IsInterface
{
  public static void main(String[] argv) throws Exception {

    Class clazz =int.class;
Class ar=int[].class;
Class  c=java.io.Serializable.class;
    boolean isInterface = clazz.isPrimitive();
 boolean isInterface1 = c.isInterface();
boolean isInterface2 = ar.isArray();
System.out.println( ar.getName());
Class inter[]=ar.getInterfaces();
for(int i=0;i<inter.length;i++)
{
System.out.println(inter[i].getName());
}
System.out.println("Is primitive = " + isInterface);
System.out.println("Is Interface = " + isInterface1);
System.out.println("Is Array= " + isInterface2);
  }
}
