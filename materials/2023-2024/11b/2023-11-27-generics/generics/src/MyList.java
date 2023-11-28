import java.io.Serializable;
import java.util.Comparator;

public class MyList<E extends Comparable & Serializable> {
    private class Node {
        E value;
        Node next = null;

        public Node(E value) {
            this.value = value;
        }
    };

    private Node head = null;

    public void add(E e) {
        if(head == null) {
            head = new Node(e);
            return;
        }

        //        ...
    }

    public static <K extends Comparable & Serializable> MyList<K> fromArray(K[] arr) {
        MyList<K> l = new MyList<>();
        // ...
//        l.add(1);
        l.add(arr[0]);

        return l;
    }

    public <O> void foo() {}

    public void sort(Comparator<E> comp) {
        E o1 = head.value;
        E o2 = head.next.value;
        // for( ... )
        int result = comp.compare(o1, o2);
//        if(result < 0)
//            swap();
    }

    public void sort() {
        E o1 = head.value;
        E o2 = head.next.value;
        // for( ... )
//        int result = ((Comparable)o1).compareTo(o2);
        int result = o1.compareTo(o2);
//        if(result < 0)
//            swap();
    }
}
