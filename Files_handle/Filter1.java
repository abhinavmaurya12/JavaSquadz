import java.io.File;
import java.io.FileFilter;

public class  Filter1
{
  public static void main(String[] args)
  {
    String dirPath = "D:\\codesqz\\Files_handle\\metadata";
    File dir = new File(dirPath);

  MyFilter filter=new MyFilter();


  File[] list = dir.listFiles(filter);

  for (int i=0;i<list.length;i++) {
    if (list[i].isFile())
{
    System.out.println(list[i].getPath() + "  (File)");
  } else if (list[i].isDirectory()) {
    System.out.println(list[i].getPath() + "  (Directory)");
  }
  }
  }
}

class  MyFilter  implements  FileFilter
{

        public boolean accept(File  f)
        {

                if (f.isFile()  || f.isDirectory())
                {

                    String fileName = f.getName ().toLowerCase();
                if (fileName.endsWith(".java"))
                {

                return true;
                }
            }
        return false;
        }
}
