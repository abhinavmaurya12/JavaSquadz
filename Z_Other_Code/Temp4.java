class Temp4
{
int x=getx();
int getx()
{
System.out.println(x);
return 10;
}
Temp4()
{
x=0;
x=getx();
System.out.println(x);
}
public static void main(String args[])
{
Temp4 t = new Temp4();
}
}
// output 0, 0, 10
// in java we can also called  a method as class level of intialize the data member of that class..
