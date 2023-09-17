package Introduction_to_java;
import java.util.Scanner;
public class Width_height {
    public static void main(String[] args) {
        float width;
        float heigth;
        Scanner scanner =  new Scanner(System.in);
        System.out.println("Width: ");
        width = scanner.nextFloat();
        System.out.println("Heigth: ");
        heigth = scanner.nextFloat();
        float area = width * heigth;
        System.out.println("Area is: "+area);
    }
}
