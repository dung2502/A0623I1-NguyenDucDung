package arraylist_linkedlist.linkedlist.test;
public class LinkedList {
    public static void main(String[] args) {
        Node<String> head = null;
        Node<String> tail = null;

        head = new  Node<>("Chicago");
        tail = head;
        tail.next = new Node<>("Denver");
        tail = tail.next;
        tail.next = new Node<>("Dallas");
        tail = tail.next;


        // Check Node last

        Node<String> current = head;
        while(current != null){
            System.out.println(current.element);
            current = current.next;
        }


    }
}

class Node<E> {
    public Node<String> next;
    E element;
   Node(E e){
       element = e;

    }
}
