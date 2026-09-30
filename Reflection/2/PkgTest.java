class PkgTest
{

    public static void main(String args[]) {
      Package pkgs[];

      pkgs = Package.getPackages();

  //  for(int i=0; i < pkgs.length; i++)
      System.out.println(
              pkgs[0].getName() + " " +
              pkgs[0].getImplementationTitle() + " " +
              pkgs[0].getImplementationVendor() + " " +
              pkgs[0].getImplementationVersion()
      );

    }
}



//cmd workflow-->
// D:\codesqz\Reflection\2>javac PkgTest.java
// D:\codesqz\Reflection\2>javap Temp1
// Compiled from "Temp1.java"
// class Temp1 {
  // public int x;
  // Temp1();
  // public void show();
// }
// D:\codesqz\Reflection\2>javap Temp1>abc.txt