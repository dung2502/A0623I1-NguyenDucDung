package loop_in_java;
import java.util.Scanner;
public class Greatest_common_divisor {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter a:");
        int a = sc.nextInt();
        System.out.println("Enter b:");
        int b = sc.nextInt();
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 || b == 0){
            System.out.println("No great common factor.");
        }
        while (a != b){
            if (a > b){
                a = a - b;
            }
            else {
                b = b -a;
            }
            System.out.println("Great common factor " + a);
            break;
        }
    }
}
