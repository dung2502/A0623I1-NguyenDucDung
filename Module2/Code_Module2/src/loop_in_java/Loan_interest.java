package loop_in_java;
import java.util.Scanner;
public class Loan_interest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Enter loan amount (milion):");
        int money = sc.nextInt();
        System.out.println("Enter monthly interest rate:");
        double month_rate = sc.nextDouble();
        System.out.println("Enter month send:");
        int month = sc.nextInt();
        double loan_money = money * (month_rate/100)/12 * month;
        System.out.println("Loan interest is: " + loan_money);
    }
}
