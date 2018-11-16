import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    ArrayList<BankAccount> bankAccount = new ArrayList<BankAccount>();
    private int currentAccount = 0;
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
    			accountNum = this.bankAccount.get(currentAccount).checkAccountNumber(in.nextInt());
    			in.nextLine();
    			System.out.print( (accountNum) ? "" : "Incorrect, please try again\n");
    		}
    		
    		System.out.print("Enter your pin: ");
    		secure = this.bankAccount.get(currentAccount).checkPIN(in.nextInt());
    		in.nextLine();
    		System.out.println( (secure) ? "" : "Incorrect, please try again");
    	}
    	
        System.out.println("What would you like to do?");
        System.out.println("1. Account Info\n2. Make deposit\n3. Withdraw funds\n4. User Info\n5. Switch Accounts");
        
        switch(in.nextLine().charAt(0)) {
        case '1':
        	System.out.println("Your current balance is $" + this.bankAccount.get(currentAccount).getBalance());
        	System.out.println("Your account number is " + this.bankAccount.get(currentAccount).getAccountNumber());
        	break;
        	
        case '2':
        	System.out.println("How much will you be depositing?");
        	this.bankAccount.get(currentAccount).deposit(in.nextDouble());
        	in.nextLine();
        	break;
        	
        case '3':
        	System.out.println("How much would you like to withdraw?");
        	try {
        		this.bankAccount.get(currentAccount).withdraw(in.nextDouble());
        	}
        	catch (InvalidParameterException e) {
        		System.out.println(e.getMessage());
        	}
        	in.nextLine();
        	break;
        	
        case '4':
        	System.out.println("Name: " + this.bankAccount.get(currentAccount).getAccountHolder().getName());
        	System.out.println("SSN: " + this.bankAccount.get(currentAccount).getAccountHolder().getSSN());
        	System.out.println("Phone Number: " + this.bankAccount.get(currentAccount).getAccountHolder().getPhone());
        	System.out.println("Address: " + this.bankAccount.get(currentAccount).getAccountHolder().getAddress());
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
    public void addAccount(AccountHolder accountHolder) {
    	this.addAccount(new BankAccount(in, accountHolder));
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
    		case 'n':
    			this.menu();
			default:
				System.out.println("Invalid option");
				this.accountSwitcher();
				return;
    		}
    	}
    	
    	System.out.println("There are currently " + this.bankAccount.size() + " accounts in the system.\nWhat would you like to do?");
    	System.out.println("1. Create a new account\n2. View account information\n3. Access an account");
    	switch(in.nextLine().toLowerCase().charAt(0)) {
    	case '1':
    		this.addAccount(this.bankAccount.get(currentAccount).getAccountHolder());
    		break;
    	case '2':
    		this.bankAccount.forEach((account)->System.out.println("Account " + (this.bankAccount.indexOf(account) + 1) + " has account number " + account.getAccountNumber()));
    		break;
    	case '3':
    		System.out.println("What account do you want to access?");
    		int temp;
    		while ((temp = in.nextInt()) < 0 && temp > this.bankAccount.size()) {
    			System.out.println("Invalid account number, please try again");
    		}
    		in.nextLine();
    		this.menu();
    		return;
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
