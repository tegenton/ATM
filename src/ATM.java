import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    ArrayList<BankAccount> bankAccount = new ArrayList<BankAccount>();
    ATM(BankAccount bankAccount) {
        this.bankAccount.add(bankAccount);
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
    			accountNum = this.bankAccount.get(this.bankAccount.size() - 1).checkAccountNumber(in.nextInt());
    			in.nextLine();
    			System.out.print( (accountNum) ? "" : "Incorrect, please try again\n");
    		}
    		
    		System.out.print("Enter your pin: ");
    		secure = this.bankAccount.get(this.bankAccount.size() - 1).checkPIN(in.nextInt());
    		in.nextLine();
    		System.out.println( (secure) ? "" : "Incorrect, please try again");
    	}
    	
        System.out.println("What would you like to do?");
        System.out.println("1. Account Info\n2. Make deposit\n3. Withdraw funds\n4. User Info\n5. Switch Accounts");
        
        switch(in.nextLine().charAt(0)) {
        case '1':
        	System.out.println("Your current balance is $" + this.bankAccount.get(this.bankAccount.size() - 1).getBalance());
        	System.out.println("Your account number is " + this.bankAccount.get(this.bankAccount.size() - 1).getAccountNumber());
        	break;
        	
        case '2':
        	System.out.println("How much will you be depositing?");
        	this.bankAccount.get(this.bankAccount.size() - 1).deposit(in.nextDouble());
        	in.nextLine();
        	break;
        	
        case '3':
        	System.out.println("How much would you like to withdraw?");
        	try {
        		this.bankAccount.get(this.bankAccount.size() - 1).withdraw(in.nextDouble());
        	}
        	catch (InvalidParameterException e) {
        		System.out.println(e.getMessage());
        	}
        	in.nextLine();
        	break;
        	
        case '4':
        	System.out.println("Name: " + this.bankAccount.get(this.bankAccount.size() - 1).getAccountHolder().getName());
        	System.out.println("SSN: " + this.bankAccount.get(this.bankAccount.size() - 1).getAccountHolder().getSSN());
        	System.out.println("Phone Number: " + this.bankAccount.get(this.bankAccount.size() - 1).getAccountHolder().getPhone());
        	System.out.println("Address: " + this.bankAccount.get(this.bankAccount.size() - 1).getAccountHolder().getAddress());
        	break;
        	
        case '5':
        	this.accountSwitcher();
        	return;
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
    
    public void addAccount(BankAccount bankAccount) {
    	this.bankAccount.add(bankAccount);
    }
    public void addAccount() {
    	this.addAccount(new BankAccount(in));
    }
    
    private void accountSwitcher() {
    	if (this.bankAccount.size() == 1) {
    		System.out.println("There is only one account in the system, would you like to create a new one?");
    		switch(in.nextLine().toLowerCase().charAt(0)) {
    		case 'y':
    			this.addAccount();
    			break;
			default:
				return;
    		}
    	}
    	
    	System.out.println("There are currently " + this.bankAccount.size() + " accounts in the system.\nWhat would you like to do?");
    	System.out.println("1. Create a new account\n2. View account information\n3. Access an account");
    	switch(in.nextLine().toLowerCase().charAt(0)) {
    	case '1':
    		this.addAccount();
    		break;
    	case '2':
    		int x = 0;
    		this.bankAccount.forEach((account)->System.out.println("Account " + x++ + " has account number " + account.getAccountNumber()));
    		break;
    	case '3':
    		
    		break;
		default:
			System.out.println("Invalid option");
        }
        
        System.out.println("Would you like to do anything else? (y/n)");
        switch(in.nextLine().toUpperCase().charAt(0)) {
        case 'Y':
        	this.accountSwitcher();
        default:
        	return;
        }
    }
}   
