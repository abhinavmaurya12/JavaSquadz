import java.util.*;
import java.io.*;
public class properties
{
    public static void loadProperties( )
    {
        Properties loadProps = new Properties();
         FileInputStream fi = null;
         try
         {
            fi = new FileInputStream("application.properties");
            loadProps.load(fi);

            Enumeration names = loadProps.propertyNames();
            while( names.hasMoreElements() )
            {
              String key = (String)names.nextElement();

String v=loadProps.getProperty(key);
System.out.println(key+"="+v);
                }
        }catch(Exception e){System.out.println(e+"kkkkkkk"); }
        }
public static void main(String s[])
{
loadProperties();
}

}
