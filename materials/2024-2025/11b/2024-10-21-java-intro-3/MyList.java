class MyList extends MyCollection {
  private class Node {
    private int value = 0;
    private Node next = null;

    Node(int value) {
      this.value = value;
    }
  }

  private class Iterator {
    private Node curr = null;

    Iterator(Node head) {
      curr = head;
    }

    public boolean hasNext() {
      return curr != null;
    }

    public int next() {
      int value = curr.value;

      curr = curr.next;
      return value;
    }
  }

  private Node head = null;
  private int length = 0;

  public MyList() {}
  public MyList(MyCollection other) {
    Iterator it = new Iterator(((MyList)other).head);

    while(it.hasNext()) {
      push(it.next());
      // push(it.current());
      // it.next();
    }

    // C++ iterator
    // while(it->next()) {
    //   push(*it);
    // }
  }

  public void push(int value) {
    if(head == null) {
      head = new Node(value);
      length++;
      return;
    }

    Node curr = head;
    while(curr.next != null) curr = curr.next;

    Node newNode = new Node(value);
    curr.next = newNode;

    length++;
  }

  public int getLength() {
    return length;
  }

  public void print() {
    Node curr = head;
    while(curr != null) {
      System.out.println(curr.value);
      curr = curr.next;
    }
  }
}