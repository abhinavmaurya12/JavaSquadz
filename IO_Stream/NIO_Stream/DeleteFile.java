/*Deleting Files->

delete(Path p) and  (Path p) from Files to delete a file, a directory, and a symbolic link.

delete() method throws an exception if the deletion fails.

deleteIfExists() method does not throw a NoSuchFileException if the file being deleted does
not exist.

It returns true if it deletes the file. Otherwise, it returns false.*/


import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeleteFile
{
   public static void main(String[] args) throws Exception {
      Path p = Paths.get("E:\\manish123\\io\\Nio\\Nioprograme\\PathDemo.class");

      try {
//Files.delete(p);
boolean b=Files.deleteIfExists(p);
System.out.println(p +"= "+ b);
//System.out.println(p + "  deleted successfully.");
      } catch (NoSuchFileException e) {
        System.out.println(p + "  does  not  exist.");
      } catch (DirectoryNotEmptyException e) {
        System.out.println("Directory " + p + "  is not  empty.");
      } catch (IOException e) {
        e.printStackTrace();
      }

   }
}