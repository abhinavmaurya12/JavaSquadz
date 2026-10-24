class P39
{
public static void main(String args[])
{

int i,j,k;

//start
for(i=1; i<=5; i++){
System.out.print("* ");
}
System.out.println("");

//mid
for(i=1; i<=3; i++){
 for(j=1; j<=9; j++){
   if(j==5 || j==9){
    System.out.print("* ");
	}else
	{
	System.out.print("  ");
	}
	}
	System.out.println("");
	}
	
	//end
	for(k=1; k<=9; k++){
		if(k>=5){
			System.out.print("* ");
		}
		else{
			System.out.print("  ");
		}
	}
	
	}
	}
