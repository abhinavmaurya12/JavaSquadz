// always use child name as a file name in case of main inside child class.
// -->if you can't use you get error in some case it will run.<--
// Error: Main method not found in class Super
class Super 
{
int x=80;
}

class Base extends Super
{
int x=50;
}

class Basechild extends Base
{
int x=20;
void show()
{
System.out.println(x);
System.out.println(super.x);
System.out.println(((Super)this).x);
System.out.println(((Base)this).x);
}
public static void main(String args[])
{
Basechild c1=new Basechild();

c1.show();
System.out.println(((Super)c1).x);
}
}