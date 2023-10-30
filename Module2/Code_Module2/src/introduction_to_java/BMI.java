package introduction_to_java;
import java.util.Scanner;
public class BMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your weigth: ");
        double weigth = scanner.nextDouble();
        System.out.println("Input your heigth: ");
        double heigth = scanner.nextDouble();
        double BMI = weigth / Math.pow(heigth,2);
        if(BMI < 18.5){
            System.out.println("UnderWeigth");
        }
        else if (BMI < 25){
            System.out.println("Normal");
        }
        else if (BMI < 30){
            System.out.println("OverWeigth");
        }
        else{
            System.out.println("Obese");
        }
    }
}
