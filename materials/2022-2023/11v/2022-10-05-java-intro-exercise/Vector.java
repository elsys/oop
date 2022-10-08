class Vector {
  private int[] data;
  private int size = 0;

  public Vector() {
    data = null;
    //size = 0;
  }

  public Vector(int capacity) {
   // this.capacity = capacity;
    data = new int[capacity];
  //  size = 0;
  }

  public void pushBack(int value) {
    if(data == null) {
      data = new int[1];
    }

    if(data.length <= size) {
      resize(data.length * 2);
    }

    data[size++] = value;
  }

  public void popBack() {
    if(size == 0) return;

    data[--size] = 0;
  }

  public void resize(int newCapacity) {
    int[] tmp = new int[newCapacity];

    if(newCapacity < size)
      size = newCapacity;

    for(int i = 0; i < size; i++)
      tmp[i] = data[i];

    data = tmp;
  }

  public int getSize() {
    return size;
  }

  public int getAt(int index) {
    if(index < 0 || index >= size) return -1;

    return data[index];
  }

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