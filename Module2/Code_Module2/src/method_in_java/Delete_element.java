package method_in_java;
import java.util.Scanner;
public class Delete_element {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = {4, 12, 7, 8, 1, 6, 9};
        System.out.println("Enter a number you want delete to array: ");
        int num = sc.nextInt();
        int[] arrayNew = delete(array,num);
        for (int i = 0; i < arrayNew.length; i++){
            System.out.println(arrayNew[i]);
        }

    }
    public static int[] delete(int[] array, int a){
        int index_del = 0;
        for (int i =0; i < array.length; i++){
            if (a == array[i]){
                index_del = i;
            }
        }
        for (int i =  index_del; i < array.length; i++){
            if( i == array.length-1) {
                array[i] = 0;
            }else {
                array[i] = array[i+1];
            }
        }
        return array;
    }

}
