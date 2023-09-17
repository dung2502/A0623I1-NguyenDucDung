package method_in_java;
import java.util.Scanner;
public class Matrix {
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

        int maxValue = matrix[0][0];
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] > maxValue) {
                    maxValue = matrix[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        System.out.println("Max element in matrix is: " + maxValue);
        System.out.println("Location of max value is: Row " + (maxRow + 1) + ", column " + (maxCol + 1));

    }
}

