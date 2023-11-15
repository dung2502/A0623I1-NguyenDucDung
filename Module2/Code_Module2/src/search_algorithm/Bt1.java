package search_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Bt1 {
    private static int BinarySearch(int[] array, int left, int right, int value){
        while (right >= left ){
            int middle = (right + left)/2;
            if (array[middle] == value){
                return middle;
            }
            else if( value > array[middle]){
                return BinarySearch(array, middle+1, right, value);

            }
            else {
                return BinarySearch(array, middle -1 , right, value);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size of array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++){
            System.out.println("Enter value for index " + i);
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Enter a value you want to find: ");
        int value = sc.nextInt();
        int index  = BinarySearch(arr, 0, size - 1, value);
        if (value != -1){
            System.out.println(value + " is found at index " + index + " in array");
        } else {
            System.out.println("Value not found!");
        }
    }
}
