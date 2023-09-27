package accessmodifier_static.bt2;

public class Test {
    public static void main(String[] args) {
        Student number1 = new Student();
        System.out.println(number1.getName() + " " +number1.getClasses());
        number1.setClasses("C03");
        number1.setName("Tuan");
        System.out.println(number1.getName() + " " +number1.getClasses());

    }
}
