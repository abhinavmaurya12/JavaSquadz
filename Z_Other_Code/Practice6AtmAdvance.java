import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Practice6AtmAdvance
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int pin = 2026;
        int balance = 0;
        int choice;
        int attempt = 3;
		
		String history = "No Transaction Yet";
        int amount;

        System.out.println("====================================================");
        System.out.println("              WELCOME TO FUN ATM BANK");
        System.out.println("====================================================");

        // Login
        while(attempt > 0)
        {
            System.out.print("\nEnter Last 4 Digit ATM PIN : ");
            int pass = sc.nextInt();

            if(pass == pin)
            {
                System.out.println("\nLogin Successful...");
                break;
            }
            else
            {
                attempt--;
                if(attempt == 0)
                {
                    System.out.println("\nATM Blocked!");
                    return;
                }
                System.out.println("Wrong PIN! Remaining Attempts : " + attempt);
            }
        }

        // Customer Details
        System.out.println("\n========================================");
        System.out.println("            CUSTOMER DETAILS");
        System.out.println("========================================");
        System.out.println("Name          : Lalu Kumar");
        System.out.println("Father Name   : Kalu Kumar");
        System.out.println("Bank          : Berozgar Bank");
        System.out.println("ATM Type      : RuPay Platinum");
        System.out.println("Account No.   : XXXX XXXX XXXX 4589");
        System.out.println("IFSC Code     : BBNK0002026");
        System.out.println("Status        : Active");
        System.out.println("========================================");

        while(true)
        {
            System.out.println("\n============== MAIN MENU ==============");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Fast Cash");
            System.out.println("5. Mini Statement");
			System.out.println("6. Change PIN");
			System.out.println("7. Exit");
            System.out.println("=======================================");

            System.out.print("Enter Choice : ");
            choice = sc.nextInt();

            switch(choice)
            {
                case 1:

    System.out.println("\n========== DEPOSIT ==========");

    System.out.print("Enter Amount : ₹");
    amount = sc.nextInt();

    if(amount <= 0)
    {
        System.out.println("Invalid Amount!");
    }
    else
    {
        balance = balance + amount;

        history = history +
        "\nDeposit : +₹" + amount;

        System.out.println("--------------------------------");
        System.out.println("Deposit Successful");
        System.out.println("Current Balance : ₹" + balance);
    }

    break;

                case 2:

    System.out.println("\n========== WITHDRAW ==========");

    System.out.print("Enter Amount : ₹");
    amount = sc.nextInt();

    if(amount <= 0)
    {
        System.out.println("Invalid Amount!");
    }
    else if(amount > balance)
    {
        System.out.println("Insufficient Balance");
    }
    else
    {
        balance = balance - amount;

        history = history +
        "\nWithdraw : -₹" + amount;

        System.out.println("--------------------------------");
        System.out.println("Withdrawal Successful");
        System.out.println("Remaining Balance : ₹" + balance);
    }

    break;

                case 3:
                    System.out.println("Current Balance : ₹" + balance);
                    break;

                case 4:

    System.out.println("\n========== FAST CASH ==========");

    System.out.println("1. ₹500");
    System.out.println("2. ₹1000");
    System.out.println("3. ₹2000");
    System.out.println("4. ₹5000");

    System.out.print("Choose Option : ");

    int fast = sc.nextInt();

    if(fast == 1)
        amount = 500;
    else if(fast == 2)
        amount = 1000;
    else if(fast == 3)
        amount = 2000;
    else if(fast == 4)
        amount = 5000;
    else
    {
        System.out.println("Invalid Option");
        break;
    }

    if(balance < amount)
    {
        System.out.println("Insufficient Balance");
    }
    else
    {
        balance = balance - amount;

        history = history +
        "\nFast Cash : -₹" + amount;

        System.out.println("Please Collect Your Cash");
        System.out.println("Remaining Balance : ₹" + balance);
    }

    break;
                case 5:

    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter dtf =
    DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    System.out.println("\n========================================");
    System.out.println("           MINI STATEMENT");
    System.out.println("========================================");

    System.out.println("Customer Name : Lalu Kumar");
    System.out.println("Account No.   : XXXX XXXX XXXX 4589");
    System.out.println("Bank          : Berozgar Bank");

    System.out.println("----------------------------------------");

    System.out.println(history);

    System.out.println("----------------------------------------");
    System.out.println("Available Balance : ₹" + balance);

    System.out.println("Date : " + dtf.format(now));

    System.out.println("========================================");

    break;
                case 6:

    System.out.println("\n========== CHANGE PIN ==========");

    System.out.print("Enter Old PIN : ");

    int old = sc.nextInt();

    if(old == pin)
    {
        System.out.print("Enter New PIN : ");

        int newPin = sc.nextInt();

        System.out.print("Confirm New PIN : ");

        int confirm = sc.nextInt();

        if(newPin == confirm)
        {
            pin = newPin;

            System.out.println("--------------------------------");
            System.out.println("PIN Changed Successfully");
        }
        else
        {
            System.out.println("PIN does not match.");
        }
    }
    else
    {
        System.out.println("Wrong Old PIN");
    }

    break;
	
	case 7:

    LocalDateTime exitTime = LocalDateTime.now();

    DateTimeFormatter dt =
    DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    System.out.println();

    System.out.println("==========================================");
    System.out.println("          TRANSACTION RECEIPT");
    System.out.println("==========================================");

    System.out.println("Customer Name : Lalu Kumar");

    System.out.println("Account No.   : XXXX XXXX XXXX 4589");

    System.out.println("Available Balance : ₹" + balance);

    System.out.println("------------------------------------------");

    System.out.println("Thank You For Banking With Us");

    System.out.println("Visit Again");

    System.out.println("Transaction Time : " + dt.format(exitTime));

    System.out.println("==========================================");

    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}