import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ExtractZip
{
public static void main(String   s[])
{

try
{
ZipFile zipFile = new ZipFile("test1.zip");
Enumeration  enu = zipFile.entries();
while (enu.hasMoreElements())
{
ZipEntry zipEntry = (ZipEntry) enu.nextElement();
String name = zipEntry.getName();
System.out.println("name="+ name);
InputStream is = zipFile.getInputStream(zipEntry);

FileOutputStream fos = new FileOutputStream(name);
int length;
while ((length = is.read()) !=-1)
{
fos.write(length);
}
is.close();
fos.close();
}
zipFile.close();
} catch (IOException e)
{
e.printStackTrace();
}
}
}
/*//File file = new File(name);
//File file = new File("e:\\f2\\"+name);
//FileOutputStream fos = new FileOutputStream(file);*/