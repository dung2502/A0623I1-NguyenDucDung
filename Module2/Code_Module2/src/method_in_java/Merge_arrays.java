package method_in_java;
import java.util.Scanner;
public class Merge_arrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = {4, 12, 7, 8, 1, 6, 9};
        int[] array1 = {5, 13, 10, 14, 16, 20, 21};
        int[] arrayNew = merge(array,array1);
        for (int i = 0; i < arrayNew.length; i++){
            System.out.println(arrayNew[i]);
        }

    }
    public static int[] merge(int[] arr, int[] arr1){
        int[] newArray = new int[arr.length+ arr1.length -1];
            for (int i =0; i < arr.length; i++){

                newArray[i] = arr[i];
            }
            int index = arr.length - 1;
            for(int i = 0; i < arr1.length; i++) {
                newArray[index + i] = arr1[i];
            }
        return newArray;
    }
}
