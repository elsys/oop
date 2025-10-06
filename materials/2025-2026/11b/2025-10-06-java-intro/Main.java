public class Main {
  public class Inner {}
  public static class Inner2 {}

  public static void main(String[] args) {
    System.out.println("Hello, World!");

    Other o = new Other();
    // Other o2 = Other(); // Invalid syntax
    Main m = new Main();
    Inner i = m.new Inner();
    Inner2 i2 = new Inner2();
    Other.Inner3 i3 = new Other.Inner3();

    int x = 5;
    double y = 3.14;
    float z = 2.71f;
    char c = 'A';
    boolean b = true;
    String s = "Hello";

    Integer xi = 5; // new Integer(5);
    Double yd = 3.14; // new Double(3.14);

    int[] arr = new int[10];
    for(int j = 0; j < arr.length; j++) {
      arr[j] = j * j;
    }
    for(int j = 0; j < arr.length; j++) {
      int v = arr[j];
      System.out.println(v);
    }
    for(int v : arr) {
      System.out.println(v);
    }

    foo();
    m.bar();
  }

  private static void foo() {
    System.out.println("foo");
  }

  private void bar() {
    System.out.println("bar");
  }

  private static void baz(int[] arr) {
    for(int v : arr) {
      System.out.println(v);
    }
    arr[0] = 42;
  }

}





