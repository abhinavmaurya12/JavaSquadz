interface My2
{
void show();
}
class Temp
{
public void show()
{
System.out.println("Temp");
}
}


class Childinterface4 extends Temp implements My2
{
public String toString()
{
return "hello";
}

public static void main(String args[]){
My2 m=new Childinterface4();
m.show();
System.out.println(m.toString());
}
}