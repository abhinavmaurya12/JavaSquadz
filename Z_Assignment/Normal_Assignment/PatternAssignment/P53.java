class P53
{
public static void main(String args[])
{
int i,j;
char ch='E';

for(i=5; i>=1; i--){
	for(j=1; j<=i; j++){
		System.out.print(ch);
	}
	System.out.println();	
    ch--;	
}
}
}