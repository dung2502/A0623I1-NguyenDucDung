package class_in_java.stopW;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a length of array: ");
        int arLength = sc.nextInt();
        int[] arr = Array(arLength);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        selection_Sort(arr);
        stopWatch.stop();
        System.out.println("The execution time of the selection sort algorithm is: "+ stopWatch.getElapsedTime() + "ms");
    }
    public static void selection_Sort(int[] arr){
        int size = arr.length;
        for (int i = 0; i <  size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++)
                if (arr[j] < arr[min]) {
                    min = j;
                }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    public static int[] Array(int length){
        int[] array = new int[length];
        for (int i = 0; i <array.length; i++) {
            array[i]=(int)(Math.random()*length);
        }
        return array;
    }
}
