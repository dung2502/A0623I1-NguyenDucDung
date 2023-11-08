package stackAndQueue.reverseStack;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Arrays;
import java.util.List;
public class reverseStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Choose your function you want : ");
            System.out.println("1. Reverse Stack Integer ");
            System.out.println("2. Reverse Stack String");
            System.out.println("0. Exit");
            int choose = sc.nextInt();
            switch (choose){
                case 1:
                    LinkedList<Integer> ListInter = new LinkedList<>();
                    System.out.println("Enter the number of elements of ListInter ");
                    int length = sc.nextInt();
                    for (int i = 0; i < length; i++){
                        System.out.println("Enter the " + (i + 1) + " number");
                        int num = sc.nextInt();
                        ListInter.addFirst(num);
                    }
                    System.out.println("Your LinkedList");
                    for (Integer element : ListInter){
                        System.out.println( element + " ");
                    }
                    reverseInterList(ListInter);
                    System.out.println("After reverse your LinkedList");
                    for (Integer element : ListInter){
                        System.out.println(element + "");
                    }
                    break;
                case 2:
                    System.out.println("Enter the string: ");
                    String characters = sc.nextLine();
                    String[] words = characters.split("");
                    LinkedList<String> mWord = new LinkedList<>();

            }
        }
    }
    public static void reverseInterList(LinkedList<Integer> list){
        Stack<Integer> stack = new Stack<>();
        for (Integer element : list){
            stack.push(element);
        }
        list.clear();
        while (!stack.empty()){
            list.addLast(stack.pop());
        }
    }

}
