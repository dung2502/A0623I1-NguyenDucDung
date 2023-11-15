package ss14;

public class SelectionSort {
    public static void main(String[] args) {
        double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};
        selectionSort(list);
       for (int i = 0; i < list.length; i++){
           System.out.println(list[i] + "\t");
       }

    }
    public static void selectionSort(double[] list){
        int min;
        for (int i = 0; i < list.length - 1; i++ ){
            min = i;
            for ( int j = i + 1; j < list.length; j++ ){
                if (list[min] > list[j] )
                {
                    min = j;
                }
                if (min != i){
                    double temp = list[min];
                    list[min] = list[i];
                    list[i] = temp;
                }
            }
        }
    }
}
