interface My 
{
int x=10;
}

interface My1
{
int x=10;
}

class Childinterface3 implements My, My1
{

public static void main (String args[])
{
System.out.println(My.x);
System.out.println(My1.x);
//System.out.println(x);
//My.x=1000;
}
}