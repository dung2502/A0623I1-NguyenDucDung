package StudentManagement.models;

public class Student extends Person{
    private int classId;
    public Student(){}
    public Student(int classId) {
        this.classId = classId;
    }

    public Student(int id, String name, String born, String gender, String phoneNumber, int classId) {
        super(id, name, born, gender, phoneNumber);
        this.classId = classId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return super.toString() + "," + classId;
    }

    @Override
    public String showInfo() {
        return super.showInfo();
    }
}
