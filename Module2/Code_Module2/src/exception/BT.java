package exception;

import java.util.Random;
import java.util.Scanner;

public class BT {
    public Integer[] creatRandom(){
        Random rd = new Random();
        Integer[] num = new Integer[100];
        System.out.println("Array num: ");
        for (int i = 0; i < num.length; i++){
            num[i] = rd.nextInt(100);
            System.out.println(num[i] + " ");
        }
        return num;
    }

    public static void main(String[] args) {
        BT arrExample = new BT();
        Integer[] arr = arrExample.creatRandom();

        Scanner sc = new Scanner(System.in);
        System.out.println("Pleased enter value any number you want: ");
        int x = sc.nextInt();
        try {
            System.out.println("Value of number 5 " + x + " is: " + arr[x]);
        }
        catch (IndexOutOfBoundsException e ){
            System.out.println("Number height of the array");
        }
    }

}
