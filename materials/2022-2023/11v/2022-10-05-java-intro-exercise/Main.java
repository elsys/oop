class Main {
  public static void main(String[] args) {
    Vector v1 = new Vector();

    v1.pushBack(5);
    v1.pushBack(10);
    v1.pushBack(15);
    v1.popBack();
    v1.resize(20);

    for(int i = 0; i < v1.getSize(); i++) {
      System.out.println(i + " => " + v1.getAt(i));
    }
  }
}

