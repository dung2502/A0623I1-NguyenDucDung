package thi_module2.model;

 abstract class Person{
     private int id;
     private String name;
     private String dateOfBirth;
     private String gender;
     private String phoneNumber;
     private String idClass;

     public Person() {
     }

     public Person(int id, String name, String dateOfBirth, String gender, String phoneNumber, String idClass) {
         this.id = id;
         this.name = name;
         this.dateOfBirth = dateOfBirth;
         this.gender = gender;
         this.phoneNumber = phoneNumber;
         this.idClass = idClass;
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

     public String getDateOfBirth() {
         return dateOfBirth;
     }

     public void setDateOfBirth(String dateOfBirth) {
         this.dateOfBirth = dateOfBirth;
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

     public String getIdClass() {
         return idClass;
     }

     public void setIdClass(String idClass) {
         this.idClass = idClass;
     }
     @Override
     public String toString() {
         return String.format("%s,%s,%s,%s,%s,%s", id, name, dateOfBirth, gender, phoneNumber, idClass);
     }
 }
