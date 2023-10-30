package introduction_to_java;
import java.util.Scanner;

public class Read_number {
    public static String less_than10(int num) {
        String resul_num = "";
        switch (num){
            case 1:
                resul_num = "one";
                break;
            case 2:
                resul_num = "two";
                break;
            case 3:
                resul_num = "three";
                break;
            case 4:
                resul_num = "four";
                break;
            case 5:
                resul_num = "five";
                break;
            case 6:
                resul_num = "six";
                break;
            case 7:
                resul_num = "seven";
                break;
            case 8:
                resul_num = "eight";
                break;
            case 9:
                resul_num = "nine";
                break;
            case 0:
                resul_num = "zero";
                break;

        }
        return resul_num;
    }
    public static String less_than20(int num) {
        String resul_num = "";
        switch (num){
            case 11:
                resul_num = "eleven";
                break;
            case 12:
                resul_num = "twelve";
                break;
            case 13:
                resul_num = "thirteen";
                break;
            case 14:
                resul_num = "fourteen";
                break;
            case 15:
                resul_num = "fifteen";
                break;
            case 16:
                resul_num = "sixteen";
                break;
            case 17:
                resul_num = "seventeen";
                break;
            case 18:
                resul_num = "eightteen";
                break;
            case 19:
                resul_num = "nineteen";
                break;
            case 10:
                resul_num = "ten";
                break;

        }
        return resul_num;
    }
    public static String two_digits(int num){
        String[] dozens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] unit   = {"","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        if (num % 10 ==0){
            return dozens[num / 10];
        }
        else{
            return dozens[num / 10] + " " + unit[num %10];
        }
    }
    public static String three_digits(int num){
        String[] unit   = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        if (num % 100 == 0){
            return unit[num / 100] + "hundred";
        }
        else if(( num % 100) < 10){
            return unit[num / 100] + " hundred" + " and " + less_than10(num%100);
        } else if ((num % 100)< 20) {
            return unit[num / 100] + " hundred" + " and " + less_than20(num%100);
        }
        else {
            return unit[num / 100] + " hundred" + " and " + two_digits(num%100);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number 1 -> 999: ");
        int num = sc.nextInt();
        if (num < 0 ) {
            System.out.println("Enter a number 1 -> 999: ");
             num = sc.nextInt();
        }
        if (num < 10){
            System.out.println(less_than10(num));
        }
        else if (num < 20){
            System.out.println(less_than20(num));
        }
        else if (num < 100){
            System.out.println(two_digits(num));
        }
        else{
            System.out.println(three_digits(num));
        }
    }
}
