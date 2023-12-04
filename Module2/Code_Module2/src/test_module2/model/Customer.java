package test_module2.model;

public class Customer {
    private String name;
    private String phoneNumber;
    private String address;
    private String email;
    private String facebook;
    private String gender;
    private String dateOfBirth;
    private int groupOfPhoneNumber;

    public Customer() {
    }

    public Customer(String name, String phoneNumber, String address, String email, String facebook, String gender, String dateOfBirth, int groupOfPhoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.facebook = facebook;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.groupOfPhoneNumber = groupOfPhoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGroupOfPhoneNumber() {
        return groupOfPhoneNumber;
    }

    public void setGroupOfPhoneNumber(int groupOfPhoneNumber) {
        this.groupOfPhoneNumber = groupOfPhoneNumber;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", name, phoneNumber, address, email, facebook, gender, dateOfBirth, groupOfPhoneNumber);
    }
}
