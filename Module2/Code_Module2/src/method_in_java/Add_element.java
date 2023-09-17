package method_in_java;

import java.util.Scanner;

public class Add_element {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = {4, 12, 7, 8, 1, 6, 9};
        System.out.println("Enter a number you want add to array: ");
        int num = sc.nextInt();
        System.out.println("Enter a location you want add number to array: ");
        int local = sc.nextInt();
        int[] arrayNew = add(array,num,local);
        for (int i = 0; i < arrayNew.length; i++){
            System.out.println(arrayNew[i]);
        }

    }
    public static int[] add(int[] arr, int num, int local){
        int[] newArray = new int[arr.length+ 1];
        if (local < 0 || local >= arr.length - 1 ){
            System.out.println("Can not add element into array.");
        }
        else {
            for (int i =0; i < local; i++){

                    newArray[i] = arr[i];
            }
            for(int i = local + 1; i < newArray.length; i++) {
                newArray[i] = arr[i-1];
            }
            newArray[local] = num;
        }
        return newArray;
    }
}
