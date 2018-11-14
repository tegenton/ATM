import java.util.Scanner;

public class AccountHolder {
    private int ssn;
    private String name;
    private String phone;
    private String address;
    private String birthday;

    AccountHolder (String name, int ssn, String phone, String address, String birthday) {
        this.name = name;
        this.ssn = ssn;
        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
    }
    AccountHolder(Scanner in) {
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
        System.out.print("Date of Birth: ");
        birthday = in.nextLine();
    }
    
    void setName(String name) {
    	this.name = name;
    }
    String getName() {
        return name;
    }
    
    void setSSN(int ssn) {
    	this.ssn = ssn;
    }
    int getSSN() {
        return ssn;
    }
    
    void setPhone(String phone) {
    	this.phone = phone;
    }
    String getPhone() {
        return phone;
    }
    
    void setAddress(String address) {
    	this.address = address;
    }
    String getAddress() {
        return address;
    }
    
    void setBirthday(String birthday) {
    	this.birthday = birthday;
    }
    String getBirthday() {
        return birthday;
    }
}
