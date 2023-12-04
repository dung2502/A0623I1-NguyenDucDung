package test_module2.until;

public interface Regex {
    String phone = "^0,\\d{9}$";
    String email = "^\\w.*\\@[a-z].*\\.com$";
    String dateOfBirth = "\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}";
}
