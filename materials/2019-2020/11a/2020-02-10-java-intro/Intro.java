class Intro {
  public static void main(String[] argv) {
    System.out.println("Hello!");
  }
  
  public void hello() throws Exception {
    System.out.println("Hello!");
    
    int a = 10;
    long b = 10;
    float c = 1.3f;
    double d = 4.5;
    char e = 'e';
    boolean f = false;
    String g = "asdf";
    
    Integer a2 = (Integer)a;
    String g2 = a2.toString();
    
    for(int i = 0; i < 10; i++) {
      System.out.println(i);
    }
    
    /*try {
      throw new Exception("aaaaaa");
    } finally {
      System.out.println("the finally");
    }  */
    // bhjbhj 
    
    int[] arr;// = new int[20];
//    int[15] arr2;
    for(int i=0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }   
  }
}
