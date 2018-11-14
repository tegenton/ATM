import java.security.InvalidParameterException;
import java.util.Scanner;

public class ATM {
    BankAccount bankAccount;
    ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ATM atm = new ATM(new BankAccount(in));
        atm.menu();
    }

    private void menu(boolean secure) {
    	boolean accountNum = secure;
    	while (!secure) {
    		while (!accountNum) {
    			System.out.println("Enter your account number");
    			accountNum = this.bankAccount.checkAccountNumber(in.nextInt());
    			in.nextLine();
    			System.out.print( (accountNum) ? "" : "Incorrect, please try again\n");
    		}
    		
    		System.out.print("Enter your pin: ");
    		secure = this.bankAccount.checkPIN(in.nextInt());
    		in.nextLine();
    		System.out.println( (secure) ? "" : "Incorrect, please try again");
    	}
    	
        System.out.println("What would you like to do?");
        System.out.println("1. Account Info\n2. Make deposit\n3. Withdraw funds\n4. User Info");
        
        switch(in.nextLine().charAt(0)) {
        case '1':
        	System.out.println("Your current balance is $" + this.bankAccount.getBalance());
        	System.out.println("Your account number is " + this.bankAccount.getAccountNumber());
        	break;
        	
        case '2':
        	System.out.println("How much will you be depositing?");
        	this.bankAccount.deposit(in.nextDouble());
        	in.nextLine();
        	break;
        	
        case '3':
        	System.out.println("How much would you like to withdraw?");
        	try {
        		this.bankAccount.withdraw(in.nextDouble());
        	}
        	catch (InvalidParameterException e) {
        		System.out.println(e.getMessage());
        	}
        	in.nextLine();
        	break;
        	
        case '4':
        	System.out.println("Name: " + this.bankAccount.getAccountHolder().getName());
        	System.out.println("SSN: " + this.bankAccount.getAccountHolder().getSSN());
        	System.out.println("Phone Number: " + this.bankAccount.getAccountHolder().getPhone());
        	System.out.println("Address: " + this.bankAccount.getAccountHolder().getAddress());
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
