class P41_1
{
public static void main(String args[])
{
int i,j;

for(i=1; i<=7; i++){
 for(j=1; j<=5; j++){
  if (i == 1 || i == 7 || j == 1 || j == 5)
    System.out.print("*  ");
else if ((i == 3 || i == 5) && j != 3)
    System.out.print("*  ");
else if (i == 4 && j == 3)
    System.out.print("*  ");
else
    System.out.print("   ");
  }
  System.out.println();
  }
  
}
}