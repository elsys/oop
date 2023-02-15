public class MyPriorityQueue<T extends Comparable<T>> extends MyCoolQueue<T> {
    @Override
    public void add(T value) {
        System.out.println("Added " + value);
        Node newNode = new Node(null, value);

        if(head == null) {
            head = tail = newNode;
        } else {
            if(head.value.compareTo(value) > 0) {
                newNode.next = head;
                head = newNode;
            } else {
                Node curr = head;
                while(curr.next != null) {
                    if(curr.next.value.compareTo(value) > 0) {
                        newNode.next = curr.next;
                        curr.next = newNode;
                        return;
                    }
                    curr = curr.next;
                }

                tail.next = newNode;
                tail = tail.next;
            }
        }
    }
}
