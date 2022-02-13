/*int main() {
  return 0;
}*/

class HelloWorld {
  public static void main(String[] args) {
    System.out.println("Hello World");
    
    HelloWorld hw = new HelloWorld();
    hw.foo();
  }
  
  void foo() {
    System.out.println("foo");
    //HelloWorld.main(new String[2]);
    Point p = new Point();
  }
}


