import java.io.File;

class ListRoot
{
  public static void main(String[] args)
  {
    File[] roots = File.listRoots();
    System.out.println("List  of  root directories:");
    for (int i=0;i<roots.length;i++)
    {
      System.out.println(roots[i].getPath());
    }
  }
}
