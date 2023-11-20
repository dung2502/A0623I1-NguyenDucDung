package exception;

import java.util.Scanner;

public class IllegalTriangleException extends Throwable {
    public static void Enter() throws IllegalTriangleException {
        Scanner sc = new Scanner(System.in);
            System.out.println("Enter value three edge of the triangle.");
            System.out.println("Enter a: ");
            double a = sc.nextDouble();
            System.out.println("Enter b: ");
            double b = sc.nextDouble();
            System.out.println("Enter c: ");
            double c = sc.nextDouble();
            if(a <= 0 || b <= 0 || c <= 0){
                throw new IllegalTriangleException();
            }else if (a + b <= c || b + c <= a || a + c <= b){
                throw new IllegalTriangleException();
            }

    }

    public static void main(String[] args) {
        try {
            Enter();
        }
        catch (IllegalTriangleException e){
            System.out.println("Suprise you  have bug");
        }
    }
}
