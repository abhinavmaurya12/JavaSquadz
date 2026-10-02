import javax.tools.*;
class CompileTest
{
public static void main(String d[])
{
JavaCompiler comp=ToolProvider.getSystemJavaCompiler();
int i=comp.run(System.in,System.out,System.err,"A.java");

System.out.println(i);
}
}
