import java.io.File;
public class MyFile
{
public static void main(String args[])
{
// NOTE: lines 1-8 were not visible in any photo. The file path passed
// to "new File(...)" below is a placeholder reconstruction; the real
// value used on screen is unknown.
File f=new File("D:\\codesqz\\Files_handle\\metadata");
boolean b=f.exists();
if(b==true)
{
System.out.println("exist");
String  path=f.getPath();
String  name=f.getName();
long l=f.length();
System.out.println("path= "+path);
System.out.println("name= "+name);
System.out.println("size= "+l);
boolean  b1=f.isFile();
if(b1==true)
{
System.out.println("it is a  file");
f.delete();
}
boolean  b2=f.isDirectory();
if(b2==true)
{
System.out.println("it is a  folder");

String  list[]=f.list();
for(int i=0;i<list.length;i++)
{
System.out.println(list[i]);
}

}

}
else
{
System.out.println("file or folder does not exist");
f.mkdir();
}
}
}

//File f=new  File("D:\\manish123\\io\\charstream\\MyFile.java");
//File f1=new  File("D:\\manish123\\io\\charstream");
