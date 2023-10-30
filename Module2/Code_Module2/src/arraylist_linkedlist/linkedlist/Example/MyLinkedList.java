package arraylist_linkedlist.linkedlist.Example;

import javax.xml.soap.Node;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes;

    public MyLinkedList() {
        head = null;
    }

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public void add(int index, Object data) {
        Node temp = head;
        Node holder;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }

    public void addLast(Object data) {
        Node temp = head;
        Node last;
        for (int i = 0; i < numNodes - 1; i++) {
            temp = temp.next;
        }
        temp.next = new Node(data);
        numNodes++;
    }

    public E remove(int index) {
        if (index < 0 || index >= numNodes) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == numNodes - 1) {
            return removeLast();
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            Node remove = temp.next;
            temp.next = null;
            numNodes--;
            return (E) remove;
        }
    }
    public E removeFirst () {
        if (numNodes == 0) {
            return null;
        }
        else {
            Node temp = head;
            head = head.next;
            numNodes--;
            return (E) temp;
        }
    }

    public E removeLast () {
        if (numNodes == 0){
            return null;
        } else if (numNodes == 1) {
            Node temp = head;
            head =  null;
            numNodes--;
            return (E) temp;

        }
        else {
            Node temp = head;
            for(int i = 0; i < numNodes -1; i++){
                temp = temp.next;
            }
            Node remove = temp.next;
            temp.next = null;
            numNodes--;
            return (E) remove;
        }
    }
    public E remove(Object o){
        Node temp = head;
        for (int i = 0; i < numNodes; i++){
            if (temp.equals(o)){
                Node remove = temp;
                temp = null;
                numNodes--;
                return (E) remove;
            }
            temp = temp.next;
        }
        return null;
    }
    public int size(){
        return numNodes;
    }

    public MyLinkedList<E> clone(){
        MyLinkedList<E> linkedListClone = new MyLinkedList<>();
        Node temp = head;
        for (int i = 0; i < numNodes; i++){
            linkedListClone.addFirst((E) temp);
            temp = temp.next;
        }
        return linkedListClone;
    }
    public boolean cotain(E e){
        Node temp = head;
        for ( int i =0; i < numNodes; i++){
            if (temp.data == e){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public int indexOf(E o){
        Node temp = head;
        for (int i = 0; i < numNodes; i++){
            if(temp.equals(o)){
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }
    public boolean add(E e){
        Node temp = head;
        for( int i = 0; i< numNodes; i++){
            if (temp.data == e){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public boolean contain(E e){
        Node temp = head;
        for (int i = 0; i<numNodes; i++){
            if(temp.data == e){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public E get(int index){
        if (index < 0 || index >= numNodes){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node temp = head;
        if (index != 0){
            for(int i = 0; i < index; i++){
                temp = temp.next;
            }
        }
        return (E) temp.next;
    }
    public void clear(){
        head = null;
        numNodes = 0;
    }
    public void printList(){
        Node temp = head;
        for(int i = 0; i < numNodes; i++){
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }
}