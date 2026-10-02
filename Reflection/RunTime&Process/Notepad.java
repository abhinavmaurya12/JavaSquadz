class Notepad
{
public static void main(String s[])
{
Runtime  rt=Runtime.getRuntime();
try
{
rt.exec("notepad.exe");
//rt.exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
rt.exec("C:\\Windows\\explorer.exe");
rt.exec("control.exe");
rt.exec("calc.exe");
rt.exec("C:\\Program Files (x86)\\Microsoft Office\\Office14\\winword.exe");
}catch(Exception  e){
System.out.println(e); }

System.out.println("hello");
}

}
