import java.lang.reflect.*;
import java.awt.*;
class SampleSuper
{
public static void printSuperClasses(Object o)
{
Class subClass=o.getClass();
Class superClass=subClass.getSuperclass();
while(superClass!=null)
{
System.out.println(superClass.getName());
subClass=superClass;
superClass=subClass.getSuperclass();
}
}
public static void main(String s[])
{
Frame f=new Frame("aa");
printSuperClasses(f);

}

}
