/*Copying Files->

Files class copy(Path source, Path target, CopyOption... options) method can copy the
specified source path to the specified target path.

If the specified source file is a symbolic link, the target of the symbolic link is copied,
not the symbolic link.

If the specified source file is a directory, an empty directory at the target location is
created without copying the contents of the directory.

We can specify one or more of the following copy options with the copy() method:

    StandardCopyOption.REPLACE_EXISTING
    StandardCopyOption.COPY_ATTRIBUTES
    LinkOption.NOFOLLOW_LINKS

We can specify the REPLACE_EXISTING option to replace the existing target file.

If the target file is a symbolic link and if it exists, the symbolic link is replaced by
specifying the REPLACE_EXISTING option, not the target of the symbolic link.

The COPY_ATTRIBUTES option copies the attributes of the source file to the target file.

If the NOFOLLOW_LINKS option is used, the copy() method copies the symbolic link, not the
target of the symbolic link.*/

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.DirectoryNotEmptyException;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;

public class CopyFile {
    public static void main(String[] args) {
     Path source = Paths.get("D:\\codesqz\\Files_handle\\metadata\\new");
     Path target = Paths.get("D:\\codesqz\\Files_handle\\metadata\\new\\new_dummy124.class");

        try
        {
            Path p = Files.copy(source, target, REPLACE_EXISTING, COPY_ATTRIBUTES);
            System.out.println(source + " has been copied to " + p);
        } catch (FileAlreadyExistsException e) {
            System.out.println(target + " already exists.");
        } catch (DirectoryNotEmptyException e) {
            System.out.println(target + " is not empty.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}