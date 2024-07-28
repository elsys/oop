import java.util.LinkedList;
import java.util.List;

public class Main {
//    public:
//        const int operator+(const Main& other) const
//        {
//            const int val = 5;
//            const int val2;
//            val2 = 5;
//
//            int val3 = 5;
//            const int val4 = val3;
//            val3 = val4;
//            val4 = 10;
//
//            (const int*) const val5;
//        }
//    }

    public int val1 = 5;
    public int val4;
    public final int val2 = 6;
    public final int val3;
    public final List<Integer> val5 = new LinkedList<>();

    public Main(int arg3) {
        val3 = arg3;
        //val3 = arg3;
        //val2 = 5;
    }

    public final List<Integer> getVal5() {
        return val5;
    }

    public void baz() {
        List<Integer> val6 = getVal5();
        val6 = new LinkedList<>();
//        getVal5() = new LinkedList<>();
    }

    public void bad(final Main arg) {
        arg = new Main(5);
        arg.val1 = 10;

        final List<Integer> val7 = new LinkedList<>();
        val7.add(arg.val1);
        val7 = val5;
    }

    public void foo() {
        val1 = 55;
        val4 = 77;

        val5.add(5);
        val5.remove(5);
        val5.clear();
        val5 = new LinkedList<>();

        val2 = 66;
        val3 = 88;
    }

    public final void bar() {
        val1 = 55;
        val4 = 77;
        val2 = 66;
        val3 = 88;
    }
}

public class Main2 extends Main {
    @Override
    public void bar() {
    }


}






