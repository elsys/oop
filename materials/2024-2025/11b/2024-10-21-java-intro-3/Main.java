class Main {
  public static void main(String[] args) {
    MyCollection myList = new MyList();
    myList.push(1);
    myList.push(2);
    myList.push(3);

    System.out.println(myList.getLength());
    myList.print();

    // MyList.Node testNode = new MyList.Node(1);
    // testNode.value = 2;

    MyCollection myList2 = new MyList(myList);
    System.out.println(myList2.getLength());
    myList2.print();
  }
}