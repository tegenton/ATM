import java.security.InvalidParameterException;

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
    void deposit(int amount) {
        balance += amount;
    }
    void withdraw(int amount) {
    	if (balance >= amount)
    		balance -= amount;
    	else
    		throw new InvalidParameterException("Withdraw amount is greater than balance");
    }
    double getBalance() {
        return balance;
    }
    boolean checkAccountNumber(int test) {
        return accountNumber == test;
    }
    AccountHolder getAccountHolder() {
        return accountHolder;
    }
    boolean checkPIN(int test) {
        return pin == test;
    }
}
