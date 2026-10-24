class prractice3  // calcu
{                // compile time (static) # method overloading
                 // run time (dynamic) # method overriding

int sum(int a, int b){
return a+b;
}

float sum(float a, float b){
return a+b;
}

int sum(int a, int b, int c){
return a+b+c;
}

public static void main(String args[]){
	
System.out.println("enter the number a");
int a = new java.util.Scanner(System.in).nextInt();
System.out.println("enter the number fa");
float fa = new java.util.Scanner(System.in).nextFloat();
System.out.println("enter the number b");
int b = new java.util.Scanner(System.in).nextInt();
System.out.println("enter the number fb");
float fb = new java.util.Scanner(System.in).nextFloat();
System.out.println("enter the number c");
int c = new java.util.Scanner(System.in).nextInt();

prractice3 cal = new prractice3();
System.out.println(" sum of a+b is :  " + cal.sum(a,b));
System.out.println( " sum of float number is : " + cal.sum(fa,fb));
System.out.println( " sum of a+b+c is : " + cal.sum(a,b,c));
}
}    	
