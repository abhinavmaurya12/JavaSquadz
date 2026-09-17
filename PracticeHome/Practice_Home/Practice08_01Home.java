class Practice08_01Home
{
public static void main(String args[])
{
int i,j,x=1;
for(i=3; i>=1; i--){
 for(int sp=1; sp<=i+3-1; sp++){
  System.out.print(" ");
   }
   for(j=1; j<=x; j++){
    System.out.print(x);
	}
	x+=2;
	System.out.println();
	}
	
	for(i=1; i<=4; i++){
		for(int sp=1; sp<=3; sp++){
			System.out.print(" ");
		}
		for(j=1; j<=5; j++){
			if(j==1 || j==5)
				System.out.print("$");
			else System.out.print(" ");
		}
		System.out.println();
	}
	
	x=3;
	for(i=3; i>=1; i--){
		for(int sp=1; sp<=3-i; sp++){
			System.out.print(" ");
		}
		for(j=1; j<=x; j++){
			System.out.print("&");
		}
	    if(i==3)System.out.print("@");	
		x-=2;
		
		for(int sp=1; sp<=3; sp++){
		System.out.print(" ");	
	    }
	    if(i==3)System.out.print("@");	
	    x+=2;
		for(j=1; j<=x; j++){
			System.out.print("&");
		}
		x-=2;
		
		System.out.println();
	}
	
	
	
	}
	}