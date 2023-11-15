package ss14;

import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter list size: ");
        int size = sc.nextInt();
        int[] list = new int[size];
        for (int i = 0; i < list.length; i++){
            System.out.println("Enter number in position " + i );
            list[i] = sc.nextInt();
        }
        System.out.println("Your list input: ");
        for (int i = 0; i < list.length; i++){
            System.out.println(list[i] + "\t");
        }
        insertionSort(list);
        System.out.println("Your list after reverse: ");
        for (int i = 0; i < list.length; i++){
            System.out.println(list[i] + "\t");
        }

    }

    public static void insertionSort(int[] list){
        int pos, x;
        for(int i = 1; i < list.length; i++){
            x = list[i];
            pos = i;
            while(pos > 0 && x < list[pos-1]){
                list[pos] = list[pos-1];
                pos--;
            }
            list[pos] = x;
        }
    }
}
