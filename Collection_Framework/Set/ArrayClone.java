public class ArrayClone
{

  public static void main (String args[])
{
    int array1[] = {1, 2, 3, 4, 5};
	
    int[] clone = (int[]) array1.clone();
    for(int i: clone){
      System.out.println(i);
    }

  }
}
