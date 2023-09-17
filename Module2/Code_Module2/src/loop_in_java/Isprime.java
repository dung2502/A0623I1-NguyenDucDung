package loop_in_java;
import java.util.Scanner;
public class Isprime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number you want to check is a prime: ");
        int ip = sc.nextInt();
        if( ip < 2){
            System.out.println("Is not prime!");
        }
        else {
            int i = 2;
            boolean check = true;
            while (i <= Math.sqrt(ip)){
                if (ip % i == 0){
                    check = false;

                }
                i++;
            }
            if (check){
                System.out.println(ip + " is a prime");
            }
            else {
                System.out.println(ip + " is not a prime");
            }
        }
    }
}
