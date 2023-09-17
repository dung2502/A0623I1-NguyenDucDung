package method_in_java;
import java.util.Scanner;
public class Min_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = 10;
        int[] arr = new int[10];
        int a =0;
        for (int i = 0; i < size; i++){
            System.out.println("Enter number:");
            arr[a] = sc.nextInt();
            a++;
        }
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (temp > arr[i]){
                temp = arr[i];
            }
        }
        System.out.println(temp);
    }
}
