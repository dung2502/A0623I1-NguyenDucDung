package ss14;

import java.util.Scanner;

public class BubbleSortStep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter list size: ");
        int size = sc.nextInt();
        int[] list = new int[size];
        System.out.println("Enter " + list.length + " value: ");
        for (int i = 0; i < list.length; i++){
            list[i] = sc.nextInt();
        }
        System.out.println("Your input list: ");
        for(int i = 0; i < list.length; i++){
            System.out.println(list[i] + "\t");
        }
        System.out.println("Your list after arrange: " );
        bubbleSortStep(list);
        for (int i = 0; i < list.length; i++){
            System.out.println(list[i] + "\t");
        }
    }

    public static void bubbleSortStep(int[] list){
        boolean needNextPass = true;
        for (int k = 1; k < list.length && needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i + 1]) {
                    System.out.println("Swap " + list[i] + " with " + list[i + 1]);
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    needNextPass = true;
                }
            }
            if (needNextPass == false) {
                System.out.println("Array may be sorted and next pass not needed");
                break;
            }
            System.out.print("List after the  " + k + "' sort: ");
            for (int j = 0; j < list.length; j++) {
                System.out.print(list[j] + "\t");
            }
            System.out.println();
        }
    }
}
