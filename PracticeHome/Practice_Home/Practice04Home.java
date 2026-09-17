class Practice04Home
{
public static void main(String args  [])
{
int i,j;
for(i=1; i<=2; i++){
	for(j=1; j<=4; j++){
		if(i==1 && j==3 || i==2 && j>1){
			System.out.print("*");
		}else{System.out.print(" ");}		
	}
     System.out.println();
}

for(i=1; i<=4; i++){
	for(j=1; j<=5; j++){
		if(j%2!=0 && j!=3){
			System.out.print("@");
		} else if(j==3 || i>=2){
			System.out.print("*");
		} else{System.out.print(" ");}
	}
	System.out.println();
}

// for(i=1; i<=5; i++){
	// System.out.print("*");
// }
// System.out.println();

for(i=1; i<=3; i++){
	for(j=1; j<=5; j++){
		if(j==2 || j==3 || j==4){
		System.out.print("*");
		}
		else{System.out.print(" ");}
}
System.out.println();
}
}
}