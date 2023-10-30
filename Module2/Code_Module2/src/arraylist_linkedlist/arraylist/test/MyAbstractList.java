package arraylist_linkedlist.arraylist.test;

public abstract class MyAbstractList<E> implements MyList<E> {
    protected int size = 0;

    public MyAbstractList(){

    }

    protected MyAbstractList(E[] object){
        for (int i =0; i<object.length;i++){
            add(object[i]);
        }
    }

    @Override
    public void add(E e) {
        add(size,e);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(E e) {
        if (indexOf(e) >= 0) {
            remove(indexOf(e));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return size;
    }
}
