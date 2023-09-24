package method_in_java;
import java.util.Scanner;
public class Sum_diagonal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = 0;
        int columns = 0;
        boolean check = false;
        do {
            System.out.print("Enter row of matrix: ");
             rows = sc.nextInt();
            System.out.print("Enter column of matrix: ");
             columns = sc.nextInt();
            if (rows != columns){
                System.out.println("This is not square matrix.");
            }
            if (rows == columns){
                check = true;
            }
        }while (!check);

        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element in row " + (i + 1) + ", column " + (j + 1) + ": ");
                matrix[i][j] = sc.nextInt();
            }
        }
        int sum = 0;
        for (int i = 0; i < rows; i++){
            sum +=  matrix[i][i];
        }
        System.out.println("Sum of numbers on the main diagonal of a square matrix is: " + sum);

    }
}
