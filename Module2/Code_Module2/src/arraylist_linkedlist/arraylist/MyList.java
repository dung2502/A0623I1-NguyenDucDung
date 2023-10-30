package arraylist_linkedlist.arraylist;

import java.util.Arrays;

 class MyList1<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList1(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCpa(){
        int newSize = elements.length*2;
        elements = Arrays.copyOf(elements, newSize);
    }
    public void add(E e){
        if (size ==  elements.length){
            ensureCpa();
        }
        elements[size++] = e;
    }
    public E get (int i){
        if (i >= size || i <0){
            throw new IndexOutOfBoundsException("Index" + i + ", Size" + i);
        }
        return (E) elements[i];
    }
}
public class MyList {
    public static void main(String[] args) {
        MyList1<Integer> listInteger = new MyList1<Integer>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(3);
        listInteger.add(4);

        System.out.println("element 4: "+listInteger.get(4));
        System.out.println("element 1: "+listInteger.get(1));
        System.out.println("element 2: "+listInteger.get(2));

        listInteger.get(6);
        System.out.println("element 6: "+listInteger.get(6));
    }
}
