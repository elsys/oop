class Bar {
  private int var;

  Bar() {
    var = 0;
  }

  Bar(int var) {
    this.var = var;
  }

  public void foo() {
    System.out.println("Hello, World! from Bar.foo");
  }
}

class Main {
  static void foo() {
    System.out.println("Hello, World! from foo");
  }

  public static void main(String[] args) {
    System.out.println("Hello, World!");

    int a = 5;
    float b = 3.14f;
    int[] c;
    int[] d = {1,2,3,4,5,6};
    int[] e = new int[10];

    for(int i = 0; i < 5; i++) {
      System.out.println(d[i]);
    }

    for(int i = 0; i < d.length; i++) {
      System.out.println(d[i]);
    }

    foo();
    Main myMain = new Main();
    myMain.foo();

    Bar myBar = new Bar();
    myBar.foo();
  }
}

// Main.main();