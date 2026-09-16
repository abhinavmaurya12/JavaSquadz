import java.io.File;

public class Rename
{
  public static void main(String[] args)
  {

    File oldFile = new File("D:\\codesqz\\Files_handle\\metadata\\CWD.class");
    File newFile = new File("D:\\codesqz\\Files_handle\\metadata\\new_dummy124.class");

    boolean fileRenamed = oldFile.renameTo(newFile);
    if (fileRenamed)
    {
      System.out.println(oldFile + "  renamed  to " + newFile);
    }
else
{
      System.out.println("Renaming " + oldFile + "  to " + newFile
          + "  failed.");
  }

  }
}
