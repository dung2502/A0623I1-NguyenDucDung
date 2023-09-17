package loop_in_java;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while(choice != 0) {
            System.out.println("Menu");
            System.out.println("1.Print the rectangle");
            System.out.println("2. Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)");
            System.out.println("3. Print isosceles triangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    for (int i = 0; i <3; i++ ){
                        String text = "";
                        for (int j = 0; j < 7; j++){
                            text += '*';
                        }
                        System.out.println(text );
                    }
                    break;
                case 2:
                    for (int i=1; i<=5;i++) {
                        String text = "";
                        for(int j = 1; j<=i ; j++ ){
                            text += "*";
                        }
                        System.out.println(text);
                    }
                    System.out.println(" ");

                    for (int i=1; i<=5;i++) {
                        String text = "";
                        for(int j = 1; j<=(6-i) ; j++ ){
                            text += "*";
                        }
                        System.out.println(text);;
                    }
                    System.out.println(" ");
                    for (int i=1; i<=5;i++) {
                        String text = "";
                        for (int kc=1; kc<=(5-i); kc++){
                            text +=" ";
                        }
                        for(int j = 1; j<=i ; j++ ){
                            text += "*";
                        }
                        System.out.println(text);;
                    }
                    System.out.println(" ");

                    for (int i=1; i<=5;i++) {
                        String text = "";
                        for (int kc=1; kc<=(i -1); kc++){
                            text +=" ";
                        }
                        for(int j = 1; j<=(6-i) ; j++ ){
                            text += "*";
                        }
                        System.out.println(text);;
                    }
                    break;
                case 3:
                    for (int i=1; i<=5;i++) {
                        String text = "";
                        for (int kc=1; kc<=(5 - i); kc++){
                            text +=" ";
                        }
                        for(int j = 1; j<=(i*2 -1) ; j++ ){
                            text += "*";
                        }
                        System.out.println(text);;
                    }
                    break;
                case 4:
                    System.exit(4);
                default:
                    System.out.println("No choice!");
            }
        }

    }
}
