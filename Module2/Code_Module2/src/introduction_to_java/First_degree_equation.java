package introduction_to_java;
import java.util.Scanner;
public class First_degree_equation
{
    public static void main(String[] args) {
        double a;
        double b;
        double c;
        Scanner scanner = new Scanner(System.in);
        System.out.println("First degree equation ax + b = c.");
        System.out.println("a: ");
        a = scanner.nextDouble();
        System.out.println("b: ");
        b = scanner.nextDouble();
        System.out.println("c: ");
        c = scanner.nextDouble();
        double x = (c - b)/a;
        System.out.println("x: " + x);
    }
}
