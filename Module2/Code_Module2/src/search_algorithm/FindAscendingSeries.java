package search_algorithm;
import java.util.LinkedList;
import java.util.Scanner;
public class FindAscendingSeries {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please input a string: ");
        String text = sc.nextLine();

        LinkedList<Character> ascending = new LinkedList<>();

        for (int i = 0; i < text.length(); i++){
            LinkedList<Character> textChar = new LinkedList<>();
            textChar.add(text.charAt(i));
//            System.out.println(textChar);
            for (int j = i +1; j < text.length(); j++){
                if (text.charAt(j) > textChar.getLast()){
                    textChar.add(text.charAt(j));
                }
            }
            if (textChar.size() > ascending.size()){
                ascending.clear();
                ascending.addAll(textChar);
            }
            textChar.clear();
        }
        for(Character character: ascending){
            System.out.print(character);
        }
    }
}
