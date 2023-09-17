package Introduction_to_java;
import java.util.Scanner;
public class Day_in_month {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Month: ");
         int month = scanner.nextInt();

         switch (month){
             case 2:
                 System.out.println("This month is 28 day or 29 day;");
                 break;
             case 1:
             case 3:
             case 5:
             case 7:
             case 8:
             case 10:
                 System.out.println("This month is 31 day;");
                 break;
             case 4:
             case 6:
             case 9:
             case 11:
                 System.out.println("This month is 30 day;");
                 break;
             default:
                 System.out.println("This month is not have;");
         }
    }
}
