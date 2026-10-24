class P40
{
public static void main (String args[])
{
int i,j,k,n=5;

for(i=1; i<=n; i++){
System.out.print(i+" ");
}
System.out.println("");

for(j=1; j<=n; j++){
 if(j==1){
 System.out.print("2 ");}
 else if(j!=n){
 System.out.print("  ");}
 else{
 System.out.print((n-1)+" ");}
}
System.out.println("");

for(k=1; k<=n; k++){
if(k==1 || k==n){
System.out.print("3 ");}
else{
System.out.print("  ");}
}
System.out.println("");

for(j=1; j<=n; j++){
 if(j==1){
 System.out.print("4 ");}
 else if(j==n){
 System.out.print((n-3)+" ");}
 else{
 System.out.print("  ");}
 }
 System.out.println("");

for(j=n; j>=1; j--){
System.out.print(j+" ");
  }

 }
 }