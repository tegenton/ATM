import java.security.InvalidParameterException;
import java.util.Scanner;

public class ATM {
    BankAccount bankAccount;
    ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ATM atm = new ATM(createAccount());
        atm.menu();
    }

    public static BankAccount createAccount() {
        String name; int ssn; String phone; String address;
        System.out.println("Enter your information to create an account");
        System.out.print("Name: ");
        name = in.nextLine();
        System.out.print("SSN: ");
        ssn = in.nextInt();
        in.nextLine();
        System.out.print("Phone: ");
        phone = in.nextLine();
        System.out.print("Address: ");
        address = in.nextLine();

        AccountHolder user = new AccountHolder(name, ssn, phone, address);

        System.out.print("Pin: ");
        int pin = in.nextInt();
        System.out.print("Account Number: ");
        int accountNumber = in.nextInt();
        in.nextLine();

        return new BankAccount(user, pin, accountNumber);
    }

    private void menu(boolean secure) {
    	while (!secure) {
    		System.out.print("Enter your pin: ");
    		secure = this.bankAccount.checkPIN(in.nextInt());
    		in.nextLine();
    		System.out.println( (secure) ? "" : "Incorrect, please try again");
    	}
    	
        System.out.println("What would you like to do?");
        System.out.println("1. Check balance\n2. Make deposit\n3. Withdraw funds\n");
        
        switch(in.nextLine().charAt(0)) {
        case '1':
        	System.out.println("Your current balance is $" + this.bankAccount.getBalance());
        	break;
        	
        case '2':
        	System.out.println("How much will you be depositing?");
        	this.bankAccount.deposit(in.nextInt());
        	in.nextLine();
        	break;
        	
        case '3':
        	System.out.println("How much would you like to withdraw?");
        	try {
        		this.bankAccount.withdraw(in.nextInt());
        	}
        	catch (InvalidParameterException e) {
        		System.out.println("You cannot withdraw more than your current balance");
        	}
        	in.nextLine();
        	break;
        	
    	default:
        	System.out.println("Invalid option");
        }
        
        System.out.println("Would you like to do anything else? (y/n)");
        switch(in.nextLine().toUpperCase().charAt(0)) {
        case 'Y':
        	this.menu(true);
        default:
        	return;
        }
    }
    
    public void menu() {
    	this.menu(false);
    }
}   
