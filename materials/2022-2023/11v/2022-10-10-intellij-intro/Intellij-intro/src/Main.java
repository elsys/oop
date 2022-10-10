import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(Test.var1);
        Test.baz();
        Test t = new Test();
        t.baz();
        t.var1++;
        new Test.InnerClass();
//        (new Test())
//                .foo()
//                .bar();

//        Stream
//                .of(1,2,3)
//                .map(v -> v + 1)
//                .count();


    }
}

