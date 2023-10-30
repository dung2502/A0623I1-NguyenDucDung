package arraylist_linkedlist.arraylist;

import java.util.ArrayList;
import java.util.List;

public class testArraylist {
    public static void main(String[] args) {
        List<String> arraylist = new ArrayList<>(1);
        arraylist.add("name");
        arraylist.add("age");

        System.out.println(arraylist);
    }
}
