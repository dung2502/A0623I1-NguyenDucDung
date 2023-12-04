package StudentManagement.models;

public class Teacher extends Person{
    public Teacher() {
    }

    public Teacher(int id, String name, String born, String gender, String phoneNumber) {
        super(id, name, born, gender, phoneNumber);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String showInfo() {
        return super.showInfo();
    }
}
