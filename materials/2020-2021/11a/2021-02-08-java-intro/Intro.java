class JavaIntro {
  public static void main(String[] args) {
    System.out.println("HELLO");
    System.out.print("WORLD\n");
    // printf("HELLO\n");
    // std:cout << "HELLO" << std::endl;
    
    JavaIntro myInstance = new JavaIntro();
    //JavaIntro myInstance = null;
    myInstance.doWork();
  }
  
  public void doWork() {
    System.out.println("I'm working...");
    
    int a = 10;
    long b = 15;
    float c = 1.4f;
    double d = 2.6;
    char e = 'e';
    boolean f = false;
    
    String g = "asdf";
    String h = g.substring(2, 4);
    
    Integer a2 = a; // (Integer)a;
    Integer a3 = 10;
    String asr = ((Integer)a).toString(); // "10"
    
    for(int i = 0; i < 10; i++) {
      System.out.println(i);
    }
    
    int[] arr = {1,2,3,4,5}; //new int[15];
    for(int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
    
    try {
      throw new Exception("aaaaaa");
    } catch (Exception ex) {
      System.out.println(ex);
    } finally {
      System.out.println("Entered the finally block");
    }
    
    if(true) {
      // ...
    } else if(...) {
      // ...
    } else {
      // ...
    }
    
    == != > < >= <=
    = += -+ 
    ++ --
    && || !
    (a || b) + c
    + - / * %
    & | ! ^ >> <<
    "abc" + "def" + 13
  }
}

// JavaIntro.main(args);













