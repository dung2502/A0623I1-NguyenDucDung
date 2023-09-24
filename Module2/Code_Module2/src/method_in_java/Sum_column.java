package method_in_java;
import java.util.Scanner;
public class Sum_column {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter row of matrix: ");
        int rows = sc.nextInt();
        System.out.print("Enter column of matrix: ");
        int columns = sc.nextInt();

        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element in row " + (i + 1) + ", column " + (j + 1) + ": ");
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter column you want sum: ");
        int columnSum = sc.nextInt();
        int sum = 0 ;
        for (int i = 0; i < rows; i++){
            sum += matrix[i][columnSum - 1];
        }
        System.out.println(sum);
    }
}
