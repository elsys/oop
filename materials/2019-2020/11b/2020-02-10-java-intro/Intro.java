class Intro {
  public static void main(String[] args) {
    Intro intro = new Intro();
    intro.hello();
  }
  
  public void hello() {
    System.out.println("Hello");
    
    int a = 10;
    long b = 15;
    float c = 1.4f;
    double d = 2.6;
    char e = 'e';
    boolean f = false;
    String g = "asdf";
    
    Integer a2 = (Integer)a;
    String str = a2.toString();
    Double d3 = (Double)d;
    
    for(int i=0; i< 10; i++) {
      System.out.println(i);
    }
    
    try {
      throw new Exception("aaaaaa");
    } catch (Exception ex) {
      System.out.println(ex);
    }
    
    int[] arr = new int[15];
    for(int i=0; i<arr.length;i++) {
      System.out.println(arr[i]);
    }
  }
}
