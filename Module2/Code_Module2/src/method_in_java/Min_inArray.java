package method_in_java;
public class Min_inArray {
    public static void main(String[] args) {
        int[] array = {4, 12, 7, 8, 1, 6, 9};
        int index = check(array);
        System.out.println("The smallest element in the array is: " + array[index]);

    }
    public static int check(int[] a){
        int index = 0;
        for (int j = 1 ; j < a.length; j++){
            if ( a[j] < a[index] ){
                index = j + 1;
            }
        }
        return index;
    }
}
