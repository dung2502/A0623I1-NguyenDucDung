package arraylist_linkedlist.linkedlist;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class testLinkedList {
    public static void main(String[] args) {
        List<String> linkedList = new LinkedList<>();
        linkedList.add("New York");
        linkedList.add("Atlanta");
        linkedList.add("Dallas");
        linkedList.add("Madison");

        System.out.println(linkedList);

        ListIterator<String> listiterator = linkedList.listIterator();
        while (listiterator.hasNext()){
            System.out.println(listiterator.next()+ " ");
        }

    }
}
