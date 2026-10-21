import java.util.*;


class Know_Your_Collection
{
public static void main(String args[])
{
	
// Hii EveryOne Here we know how over collection can work....

//this are list what we know....
//List --> 1.ArrayList --> 2.LinkedList 
//Set --> 1.HashSet --> --> 2.LinkedList --> 3.TreeSet
//Queue --> 1.PriorityQueue
while(true)
{
	System.out.println();
	System.out.println();
System.out.println("------------------------------------");
System.out.println("            Main Manu:              ");
System.out.println("------------------------------------");
System.out.println("------------------------------------");
System.out.println("1. List");
System.out.println("2. Set");
System.out.println("3. Queue");
System.out.println("4. Exit");
System.out.println("------------------------------------");
System.out.println("------------------------------------");
System.out.println();
System.out.printf("Select any option: ");
int op_Main=new Scanner (System.in).nextInt(); 
System.out.println();
System.out.println();


//Options 1.........
if(op_Main==1) { 
for(int i=0;i<30;i++)
		{
			System.out.println("\n");
		}
 System.out.println("List Selected...."); 
        System.out.println("------------------------------------");
        System.out.println("1.ArrayList");
        System.out.println("2.LinkedList");
        System.out.println("3.Exit");
		System.out.println("------------------------------------");
		System.out.printf("Select any option: ");
        int list_Manu=new Scanner (System.in).nextInt();
  if(list_Manu==1){ 
     for(int i=0;i<30;i++)
		{
			System.out.println("\n");
		}
  System.out.println();
   System.out.println("1.ArrayList Select...");
  System.out.println("------------------------------------");
  System.out.println("Uses a resizable array internally.");
  System.out.println("------------------------------------");
  System.out.println();
    ArrayList<String> str = new ArrayList<> ();
	
	System.out.println("How many names do you want to store?");
	int namenum= new Scanner (System.in).nextInt();
	
	for (int i = 1; i <= namenum; i++) {
            System.out.print("Enter name " + i + ": ");
            String name = new Scanner (System.in).nextLine();
            str.add(name);
        }

        System.out.println("Your ArrayList: " + str);

  }
  else if(list_Manu==2){
	  for(int i=0;i<30;i++)
		{
			System.out.println("\n");
		}
	  System.out.println();
     System.out.println("2.LinkedList Select...");
     System.out.println("------------------------------------");
     System.out.println("Uses a doubly linked list. It implements ");
     System.out.println("------------------------------------");
	     System.out.println();
   LinkedList<String> list = new LinkedList<> ();
	
	System.out.println("How many names do you want to store?");
	int namenum= new Scanner (System.in).nextInt();
	
	for (int i = 1; i <= namenum; i++) {
            System.out.print("Enter name " + i + ": ");
            String name = new Scanner (System.in).nextLine() ;
            list.add(name);
        }

        System.out.println("Your LinkedList: " + list);
  }
  else if(list_Manu==3){ 
  for(int i=0;i<30;i++)
		{
			System.out.println("\n");
		}
   System.out.println("3.Exiting...");
  System.exit(0);
  }
  else {
	  System.out.println("You have enter wrong choice");
  }
 }
 
 
 //Options 2.........
else if(op_Main==2) { 
for(int i=0;i<30;i++)
		{
			System.out.println("\n");
		}
 System.out.println("Set Selected...."); 
        System.out.println("------------------------------------");
        System.out.println("1.HashSet");
        System.out.println("2.LinkedHash Set");
        System.out.println("3.TreeSet");
        System.out.println("4.Exit");
		System.out.println("------------------------------------");
		System.out.printf("Select any option: ");
        int set_Manu=new Scanner (System.in).nextInt();
  if(set_Manu==1){ 
  for(int i=0;i<30;i++)
		{
			System.out.println("\n");
		}
    System.out.println();
   System.out.println("1.HashSet Select...");
  System.out.println("------------------------------------");
  System.out.println("Stores unique elements and does not \nguarantee insertion order.");
  System.out.println("------------------------------------");
    System.out.println();
   HashSet<Integer> set = new HashSet<>();
   
   System.out.println("How many numbers do you want to store?");
	int num= new Scanner (System.in).nextInt();
	
	for (int i = 1; i <= num; i++) {
            System.out.print("Enter number " + i + ": ");
            int nums = new Scanner (System.in).nextInt() ;
            set.add(nums);
        }

        System.out.println("Your HashSet: " + set);
		
  }
  else if(set_Manu==2){
	  for(int i=0;i<30;i++)
		{
			System.out.println("\n");
		}
    System.out.println();
   System.out.println("2.LinkedHash Set Select...");
  System.out.println("------------------------------------");
  System.out.println("Maintains insertion order while preventing duplicates.");
  System.out.println("------------------------------------");
    System.out.println();
   LinkedHashSet <Integer> lhs = new LinkedHashSet<>();
   
   System.out.println("How many numbers do you want to store?");
	int num= new Scanner (System.in).nextInt();
	
	for (int i = 1; i <= num; i++) {
            System.out.print("Enter number " + i + ": ");
            int nums = new Scanner (System.in).nextInt() ;
            lhs.add(nums);
        }

        System.out.println("Your LinkedHashSet: " + lhs);
   
  }
   else if(set_Manu==3){
	   for(int i=0;i<30;i++)
		{
			System.out.println("\n");
		}
   System.out.println();
   System.out.println("3.TreeSet Select...");
   System.out.println("------------------------------------");
   System.out.println("Stores unique elements in sorted order.");
   System.out.println("------------------------------------");
   System.out.println();
   
   TreeSet<Integer> ss= new TreeSet<>();
   System.out.println("How many numbers do you want to store?");
   int num= new Scanner (System.in).nextInt();
   	for (int i = 1; i <= num; i++) {
            System.out.print("Enter number " + i + ": ");
            int nums = new Scanner (System.in).nextInt() ;
            ss.add(nums);
        }

        System.out.println("Your TreeSet: " + ss);
   
  }
  else if(set_Manu==4){ 
  for(int i=0;i<30;i++)
		{
			System.out.println("\n");
		}
   System.out.println("4.Exiting...");
   System.exit(0);
  }
  else {
	  System.out.println("You have enter wrong choice");
  }
 }
 
 //Options 3.........
else if(op_Main==3) { 
for(int i=0;i<30;i++)
		{
			System.out.println("\n");
		}
 System.out.println("Queue Selected...."); 
        System.out.println("------------------------------------");
        System.out.println("1.PriorityQueue ");
        System.out.println("2.Exit");
		System.out.println("------------------------------------");
		System.out.printf("Select any option: ");
        int queue_Manu=new Scanner (System.in).nextInt();
  if(queue_Manu==1){ 
  for(int i=0;i<30;i++)
		{
			System.out.println("\n");
		}
   System.out.println();
   System.out.println("1.PriorityQueue Select...");
   System.out.println("------------------------------------");
   System.out.println("Processes elements according to their \npriority or order rather than insertion order.");
   System.out.println("------------------------------------");

     System.out.println();
   PriorityQueue<Integer> q = new PriorityQueue<>();
   
   System.out.println("How many numbers do you want to store?");
   int num= new Scanner (System.in).nextInt();
   	for (int i = 1; i <= num; i++) {
            System.out.print("Enter number " + i + ": ");
            int nums = new Scanner (System.in).nextInt() ;
            q.add(nums);
        }

        System.out.println("Your PriorityQueue: " + q);
  }
  else if(queue_Manu==2){ 
  for(int i=0;i<30;i++)
		{
			System.out.println("\n");
		}
   System.out.println("3.Exiting...");
   System.exit(0);
  }
  else {
	  System.out.println("You have enter wrong choice");
  }
  }
  
  
  //Options 4.........
else if (op_Main==4) { 
for(int i=0;i<30;i++)
		{
			System.out.println("\n");
		}
 System.out.println("Exiting program...."); 
 System.exit(0);
 }
 else { 
 System.out.println("Invalid Option");
 
 }
 

    // for(int i=0;i<30;i++)
		// {
			// System.out.println("\n");
		// }
}
}

}