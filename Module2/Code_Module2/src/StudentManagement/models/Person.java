package StudentManagement.models;

public abstract class Person {
    private int id;
    private String name;
    private String born;
    private String gender;
    private String phoneNumber;

    public Person() {
    }

    public Person(int id, String name, String born, String gender, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.born = born;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s",id,name,born,gender,phoneNumber);
    }
    public String showInfo(){
        return "Id: " + id + "\n" +
                "Name: " + name + "\n" +
                "Born: " + born + "\n" +
                "Gender: " + gender;
    }
}
