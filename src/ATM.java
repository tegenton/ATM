import java.util.Scanner;

public class ATM {
    BankAccount currentAccount;
    ATM(BankAccount currentAccount) {
        this.currentAccount = currentAccount;
    }
    
    Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
    	
    	
    }
    
    public BankAccount createAccount() {
    	String name; int ssn; String phone; String address;
    	System.out.println("Enter your information to create an account");
    	System.out.print("Name:");
    	name = in.nextLine();
    	System.out.print("SSN:");
    	ssn = in.nextInt();
    	System.out.print("Phone:");
    	phone = in.nextLine();
    	System.out.println("Address:");
    	address = in.nextLine();
    	
    	AccountHolder user = new AccountHolder(name, ssn, phone, address);
    	
    	System.out.print("Pin:");
    	int pin = in.nextInt();
    	
    }
}   