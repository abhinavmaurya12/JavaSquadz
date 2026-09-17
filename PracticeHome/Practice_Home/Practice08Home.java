class Practice08Home
{
public static void main(String args[])
{
int i,j,sp;
int n=5,x=1;
System.out.println(); 

for(i=1; i<=3; i++){
 for(sp=1; sp<=5-i+4; sp++){
  System.out.print(" ");
 }
  for(j=1; j<=x; j++){
   System.out.print("*");
   }
   x+=2;
   System.out.println();
   }
   
   for(i=1; i<n-1; i++){
	for(j=1; j<=11; j++){
		if(j==7 || j==11){
		 System.out.print("@");
	}else
	{
	 System.out.print(" ");
	}
	}
	System.out.println();
   }
   
   x=5;
   int s=4,s1=1;
   for(i=1; i<=3; i++){
	for(sp=4-s+1; sp>=1; sp--){
		System.out.print(" ");
	}
	for(j=1; j<=x; j++){
	 System.out.print("*"); 
	}
	for(sp=3-s1+1; sp>=1; sp--){
		if(sp==3 && i==1)System.out.print("@");
		else System.out.print(" ");
	}
	for(sp=5-s+1; sp>=1; sp--){
		if(sp==1 && i==1)System.out.print("@");
	    else System.out.print(" ");	
	}
	for(j=1; j<=x; j++){
	 System.out.print("*"); 
	}
	s1--;
	s--;
    x-=2;
	System.out.println();
   }  
}
}