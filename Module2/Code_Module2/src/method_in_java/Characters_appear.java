package method_in_java;
import java.util.Scanner;
public class Characters_appear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ar = ("this is a string");
        System.out.println("Enter a character: ");
        char cha = sc.next().charAt(0);
        int count = 0;
        for (int i = 0; i < ar.length(); i++){
            if(ar.charAt(i) == cha){
                count++;
            }
        }
        System.out.println(count);
    }
}
