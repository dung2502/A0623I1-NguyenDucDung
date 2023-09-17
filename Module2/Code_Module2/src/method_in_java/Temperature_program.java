package method_in_java;
import java.util.Scanner;
public class Temperature_program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Menu");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.println("0. Exit ");
        double celsius = 0.0;
        double fahrenheit = 0.0;
        int choose = sc.nextInt();
        do {
            switch (choose){
                case 1:
                    System.out.println("Enter Fahrenheit:");
                    fahrenheit = sc.nextDouble();
                    celsius = (5.0 / 9) * (fahrenheit - 32);
                    System.out.println(celsius);
                    break;
                case 2:
                    System.out.println("Enter Fahrenheit:");
                    celsius = sc.nextDouble();
                    fahrenheit = celsius / (5.0 * 9) +32;
                    System.out.println(fahrenheit);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("your choose is not have in the menu.");
            }
        }while (choose != 0);


    }
}
