import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarFileEx
{
  public static void main(String args[]) throws IOException {

    JarFile jarFile = new JarFile("e:\\manish123\\io\\Nio\\Nioprograme\\t1.jar");
    Enumeration  e = jarFile.entries();
    while (e.hasMoreElements()) {
      process(e.nextElement());
    }
    jarFile.close();
  }

  private static void process(Object obj) {
    JarEntry entry = (JarEntry) obj;
    String name = entry.getName();
    long size = entry.getSize();
    long compressedSize = entry.getCompressedSize();
    System.out.println(name + "\t" + size + "\t" + compressedSize);
  }
}