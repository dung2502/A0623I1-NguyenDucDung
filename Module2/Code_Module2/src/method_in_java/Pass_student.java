package method_in_java;
import java.util.Scanner;
public class Pass_student {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size ;
        double[] array ;
        do {
            System.out.println("Enter quantity of student: ");
            size = scanner.nextInt();
            if (size > 30){
                System.out.println("Quantity of student is not correct!");
            }
        }while (size > 30 );
        array = new double[size];
        int i =0;
         while (i < array.length){
             System.out.println(" Enter mark of student: " + (i +1) + ':');
             array[i] = scanner.nextDouble();
             i++;
         }

         int pass =0 ;
        System.out.println("List of mark: ");
        for (int j = 0; j < array.length; j++){
            System.out.println(array[j]);
            if (array[j] >= 5 && array[j] <= 10){
                pass++;
            }
        }
        System.out.println("\n The number of student pass the exam is: " + pass);
    }
}
