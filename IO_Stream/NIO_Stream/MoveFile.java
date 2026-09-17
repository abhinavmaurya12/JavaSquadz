/*Moving Files->

move(Path source, Path target, CopyOption... options) method of the Files class moves or rename a file.

The move operation fails if the specified target file already exists.

We can specify the REPLACE_EXISTING option to replace the existing target file.

If the file to move is a symbolic link, it moves the symbolic link, not the target of the
symbolic link.

The move() method can only be used to move an empty directory.

Apart from the REPLACE_EXISTING CopyOption, we can use the ATOMIC_MOVE as another CopyOption.

If the ATOMIC_MOVE option is used, it throws an AtomicMoveNotSupportedException if the file
could not be moved atomically.

If ATOMIC_MOVE option is specified, all other options are ignored.*/


import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;

import java.io.IOException;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MoveFile {
   public static void main(String[] args) throws Exception {
      Path source = Paths.get("e:\\manish123\\io\\Nio\\MoveFile.class");
      Path target = Paths.get("e:\\manish123\\io\\Nio\\FileLock\\DeleteFile27.class");

      try {
        Path p = Files.move(source, target, ATOMIC_MOVE);
        System.out.println(source + "  has  been  moved to " + p);
      }catch (NoSuchFileException e) {
        System.out.println("Source/target does  not  exist.");
      } catch (FileAlreadyExistsException e) {
        System.out.println(target + "  already exists.  Move failed.");
      } catch (DirectoryNotEmptyException e) {
        System.out.println(target + "  is not  empty.  Move failed.");
      } catch (AtomicMoveNotSupportedException e) {
        System.out.println("Atomic move is not  supported. MOve  failed.");
      } catch (IOException e) {
        e.printStackTrace();
      }

   }
}