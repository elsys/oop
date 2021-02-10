class JavaIntro {
  public void doWork() {
    System.out.println("I'm working");

    int a = 10;
    long b = 15;
    float c = 1.4f;
    double d = 2.6;
    char e = 'e';
    boolean f = false;

    String g = "asdf";
    String h = g.substring(2, 4);

    Integer a2 = (Integer)a;
    String astr = a2.toString();
    System.out.println(astr);

    //List<Integer> l;

    for(int i = 0; i < 10; i++) {
      System.out.println(i);
    }

    int[] arr = {1,2,3,4,5};// = new int[15];
    for(int i=0; i<arr.length;i++) {
      System.out.println(arr[i]);
    }

    try {
      throw new Exception("aaaaaa");
    } catch (Exception ex) {
      System.out.println(ex);
      System.out.println(ex.getStackTrace());
    }

    if(true) {
      // ...
    } else if(...) {
      // ...
    } else {
      // ...
    }

    // == != > < >= <=
    // && || !
    // (a || b) + c
    // + - * / += -= ++ -- %
    // & | ^ >> << !
    // "asd" + "zxc" + 13
  }

  public static void main(String[] args) {
    System.out.println("HELLO"); // Java
    System.out.print("WORLD\n"); // Java
    //printf("HELLO\n"); C
    //std::cout << "HELLO" << std::endl; C++

    JavaIntro my_instance; // my_instance == NULL;

    JavaIntro myInstance = new JavaIntro();
    myInstance.doWork();
  }

  public void doWork_() {
    System.out.println("I'm working");
  }
}
