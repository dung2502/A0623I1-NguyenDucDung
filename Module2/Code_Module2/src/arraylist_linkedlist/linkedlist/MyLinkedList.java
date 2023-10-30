package arraylist_linkedlist.linkedlist;


import javax.xml.soap.Node;

class MyLinkedListEx {
    private Node head;
    private int numNodes;
    public MyLinkedListEx(Object data){
        head =  new Node(data);
    }
    private class Node{
        private Node next;
        private Object data;
        public Node(Object data){
            this.data = data;
        }
        public Object getData(){
            return this.data;
        }
    }
    public void add(int index, Object data){
        Node tmp = head;
        Node holder;
        for(int i =0; i < index-1 && tmp.next != null; i++){
            tmp = tmp.next;

        }
        holder = tmp.next;
        tmp.next = new Node(data);
        tmp.next.next = holder;
        numNodes++;
    }
    public void addFirst(Object data){
        Node tmp = head;
        head = new Node(data);
        head.next = tmp;
        numNodes++;
    }
    public Node get(int index){
        Node tmp = head;
        for(int i =0; i <index; i++){
            tmp = tmp.next;
        }
        return tmp;
    }
    public void printList(){
        Node tmp = head;
        while(tmp != null){
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }
}
public class MyLinkedList{
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedListEx ll = new MyLinkedListEx(10);
//        ll.addFirst(11);
//        ll.addFirst(12);
//        ll.addFirst(13);

        ll.add(4,9);
        ll.add(4,9);
        ll.printList();
    }
}