interface My
{
 static void show()
 {
 System.out.println("my");
 }
 }
 
 class Childinterface2 implements My{
 
 public static void main(String args [])
 {
 My.show();
 }
 }