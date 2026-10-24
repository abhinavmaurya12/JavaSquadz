class practice5
{
public static void main(String args[])
{

int checkBalance=0;
System.out.println("Hi, I am FunAtm.com **Your ATM**");


while(true)
{
	System.out.println("Before Continue,");
	System.out.println("Please Enter Last 4 Digit ATM No. 2003-2010-2015-xxxx");
	int atmpass=new java.util.Scanner(System.in).nextInt();
	if(atmpass==2026)
	{
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Here Your Details Featch By ATM No.");
		System.out.println("Name : Lalu S/O Kalu Kumar");
		System.out.println("ATM-Type : Rupay");
		System.out.println("Bank Name : Berozgar Bank ");
		System.out.println(" ");
		System.out.println(" ");
		
		
System.out.println("How may I help you Sir/Mam.");		
System.out.println("Enter 1 for Debit, 2 for Credit, 3 for Check Balance, 5 for exit");

int num=new java.util.Scanner(System.in).nextInt();
if(num==1)
{
	System.out.println("enter the amount want to Debit...");
    int debit=new java.util.Scanner(System.in).nextInt();
	if(debit<=0){
	System.out.println("Your Balance is 0 , ADD Money First");}
	else if(checkBalance>=debit){
		System.out.println("Your debit amount is " + debit + " success");
	    checkBalance=checkBalance-debit;
	System.out.println("Your Remaing Balance is : " + checkBalance);}
	else{
	System.out.println("your debit amount can not more then Balance");	}	
		
}
	else if(num==2)
	{
		System.out.println("enter the amount want to Credit...");
        int credit=new java.util.Scanner(System.in).nextInt();
	if(credit<=0)
		System.out.println("You enter 0 , please enter amount");
	else
		System.out.println("Your credit amount is " + credit + " success");
	    checkBalance=checkBalance+credit;
		System.out.println("Your updated Balance is : " + checkBalance);
	}
	else if(num==3)
	{
		System.out.println("your balance is : " + checkBalance);
	}
	else if(num==5){
		System.out.println(" Thanks for using me.");
        System.out.println(" Come again..");
		break;
	}
	else
		System.out.println("Enter valid value");
     
System.out.println("press 4 for continue and 5 for exit");
int press=new java.util.Scanner(System.in).nextInt();
if(press==4){
continue;}
else if(press==5){
	System.out.println(" Thanks for using me.");
    System.out.println(" Come again..");
break;	}
else{
	System.out.println(" Enter valid value");
	System.out.println("press 4 for continue and 5 for exit");
    int press1=new java.util.Scanner(System.in).nextInt();
}
		
}

else{
	System.out.println("Entered ATM No. is Invalid ");
}
   
	System.out.println("press 4 for continue and 5 for exit");
    int press3=new java.util.Scanner(System.in).nextInt();
	if(press3==4){
	continue;}
	else if(press3==5){
		System.out.println(" Thanks for using me.");
        System.out.println(" Come again..");
	break;}
	else{
	System.out.println("Enter valid value");
	System.out.println("press 4 for continue and 5 for exit");
    int press4=new java.util.Scanner(System.in).nextInt();}
}
}



}