class Baseparent // upcasting and downcasting
{
int x=30;
void show()
{
System.out.println("Base");
}
}

class Basechild3 extends Baseparent
{
int x=30;
void show()
{
System.out.println("child");
}

void display()
{
System.out.println("Display");
}
public static void main (String args [])
{
Baseparent bp=new Basechild3(); //upcasting

bp.show();
Basechild3 bc=(Basechild3)bp; //downcasting
bc.display();
System.out.println(bp.x);
System.out.println(bc.x);
}
}