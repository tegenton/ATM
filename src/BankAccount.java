import java.security.InvalidParameterException;
import java.util.Scanner;

public class BankAccount {
    private double balance = 0;
    private int accountNumber;
    private int pin;
    private AccountHolder accountHolder;
    BankAccount(AccountHolder accountHolder, int pin, int accountNumber) {
        this.accountHolder = accountHolder;
        this.pin = pin;
        this.accountNumber = accountNumber;
    }
    public BankAccount(Scanner in) {
    	accountHolder = new AccountHolder(in);
        System.out.print("Pin: ");
        pin = in.nextInt();
        System.out.print("Account Number: ");
        accountNumber = in.nextInt();
        in.nextLine();
    }
    public BankAccount(Scanner in, AccountHolder accountHolder) {
    	this.accountHolder = accountHolder;
        System.out.print("Pin: ");
        pin = in.nextInt();
        System.out.print("Account Number: ");
        accountNumber = in.nextInt();
        in.nextLine();
    }
    void deposit(double amount) {
        balance += amount;
    }
    void withdraw(double amount) {
    	if (balance >= amount && amount > 0)
    		balance -= amount;
    	else if (0 > amount)
    		throw new InvalidParameterException("Withdraw amount is less than 0");
    	else
    		throw new InvalidParameterException("Withdraw amount is greater than balance");
    }
    double getBalance() {
        return balance;
    }
    boolean checkAccountNumber(int test) {
        return accountNumber == test;
    }
    int getAccountNumber() {
        return accountNumber;
    }
    AccountHolder getAccountHolder() {
        return accountHolder;
    }
    boolean checkPIN(int test) {
        return pin == test;
    }
    
    
}
