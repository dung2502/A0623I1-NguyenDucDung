package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter number 1: ");
            int num1 = sc.nextInt();
            System.out.println("Enter number 2:");
            int num2 = sc.nextInt();
            int total = num1/num2;
            System.out.println(num1 +" / "+ num2 + " = "+ total);
        }
//        catch (InputMismatchException e){
//            System.out.println("Have a Bug!");
//        }
        catch (ArithmeticException e){
            System.out.println("Have a Buggg!");
        }
        finally {
            System.out.println("Finally");
        }
        System.out.println("Done all");
    }
}
