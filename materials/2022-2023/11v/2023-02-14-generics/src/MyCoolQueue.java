public class MyCoolQueue<T> {
    protected class Node {
        public Node next;
        public T value;

        public Node(Node next, T value) {
            this.next = next;
            this.value = value;
        }
    }

    protected Node head = null;
    protected Node tail = null;

    public void add(T value) {
        Node newNode = new Node(null, value);

        if(head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public T remove() throws IndexOutOfBoundsException {
        if(head == null) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }

        T value = head.value;
        head = head.next;

        return value;
    }
}
