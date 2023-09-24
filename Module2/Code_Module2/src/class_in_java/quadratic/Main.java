package class_in_java.quadratic;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number a: ");
        double a = sc.nextDouble();
        System.out.println("Enter a number b: ");
        double b = sc.nextDouble();
        System.out.println("Enter a number c: ");
        double c = sc.nextDouble();
        Quadratic_Equation quadraticEquation = new Quadratic_Equation(a,b ,c);
        double discriminant = quadraticEquation.getDiscriminant();
        if(discriminant<0){
            System.out.println("The equation has no solution!");
        } else if(discriminant ==0){
            System.out.println("The equation has a single karma x1 = x2 = " + quadraticEquation.getRoot1());
        } else {
            System.out.println("The equation has 2 solutions: x1 = "
                    + quadraticEquation.getRoot1() + ", x2 = " + quadraticEquation.getRoot2());
        }
    }
}
