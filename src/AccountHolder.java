public class AccountHolder {
    private int ssn;
    private String name;
    private String phone;
    private String address;

    AccountHolder (String name, int ssn, String phone, String address) {
        this.name = name;
        this.ssn = ssn;
        this.phone = phone;
        this.address = address;
    }
    String getName() {
        return name;
    }
    int getSSN() {
        return ssn;
    }
    String getPhone() {
        return phone;
    }
    String getAddress() {
        return address;
    }
}
