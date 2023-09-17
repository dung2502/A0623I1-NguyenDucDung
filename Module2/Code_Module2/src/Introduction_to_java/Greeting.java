package Introduction_to_java;
import java.util.Scanner;
public class Greeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        System.out.println("Enter your name: ");
        name =  scanner.next();
        System.out.println("Hello" + " " +name);
    }
}
