package StudentManagement.until;

public interface Regex {
    String STUDENT_NAME = "[A-Za-z]{4,50}";
    String STUDENT_BORN = "^\\d{1,2}/\\d{1,2}/\\d{4}$";
    String PHONENUMBER = "^(090|091)\\d{7}$";
}
