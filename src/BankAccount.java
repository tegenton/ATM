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
        balance -= amount;
    }
    double getBalance() {
        return balance;
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
