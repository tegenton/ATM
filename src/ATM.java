import java.util.Scanner;

public class ATM {
    BankAccount currentAccount;
    ATM(BankAccount currentAccount) {
        this.currentAccount = currentAccount;
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

        return new BankAccount(user, pin, accountNumber);
    }

    public static void menu() {
        
    }
}   
