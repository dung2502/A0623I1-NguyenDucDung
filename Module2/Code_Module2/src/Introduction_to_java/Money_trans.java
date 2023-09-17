package Introduction_to_java;
import java.util.Scanner;
public class Money_trans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount to convert: ");
        int rate = 23000;
        double usd = sc.nextDouble();
        double vnd = usd*rate;
        System.out.println(usd + " dollars is worth " + vnd + " VND");
    }
}
