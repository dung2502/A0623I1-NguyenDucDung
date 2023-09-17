package method_in_java;
import java.util.Scanner;
public class Max_inArray {
    public static void main(String[] args) {
        int size ;
        int[] array;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Enter a size: ");
            size = sc.nextInt();
            if (size > 20){
                System.out.println("Size does not exceed 20.");
            }
        } while (size > 20);
        array =  new int[size];
        int i = 0;
        while (i < array.length) {
            for (int j = 0; j < array.length; j++){
                System.out.println("Enter number: " + i);
                array[i] =  sc.nextInt();
                i++;
            }
        }
        int temp = array[0];
        int index = 0;
        for (int j =0; j < array.length; j++){
            if ( array[j] > temp ){
                temp = array[j];
                index = j +1;
            }
        }
        System.out.println("The largest property value in the list is " + temp + " ,at position " + index);
    }
}
