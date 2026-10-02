class Vargs2
{
void show(int...   x)
{

for(int i=0;i<x.length;i++)
System.out.println(x[i]);
for(int i:x)
System.out.println(i);
}
void show(int   z)
{
System.out.println("single "+z);

}
public static void main(String s[])
{

new Vargs2().show(10,10,10,10);
System.out.println("after second call");
new Vargs2().show(20);
}

}
