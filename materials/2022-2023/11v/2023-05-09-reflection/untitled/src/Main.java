import javax.print.attribute.standard.JobStateReasons;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class Main {
    private static class MyClass implements Comparable {
        @Override
        public int compareTo(Object o) {
            System.out.println(this + ".compareTo() called");
            return 0;
        }
    }

//    public static <T extends Comparable> void foo(List<T> arr) {
//        arr.get(0).compareTo(arr.get(1));
//    }

//    public static <T> void foo(List<T> arr) {
//        if(arr.get(0) instanceof Comparable) {
//            ((Comparable)arr.get(0)).compareTo(arr.get(1));
//        }
//    }

    public static void foo(List<Object> arr) {
        Object tmp = arr.get(0);
        Class tmpClass = tmp.getClass();
        Method[] tmpMethods = tmpClass.getDeclaredMethods();

        for(Method m : tmpMethods) {
            System.out.println(m.toString());
        }

//        tmp.toString(new Object());
//        try {
//            tmpMethods[3].invoke(tmp, new Object());
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            Method tmpMeth = tmpClass.getDeclaredMethod(
                    "compareTo",
                    Object.class
            );
            tmpMeth.invoke(tmp, new Object());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println("");
    }

    private static class MyClass2 {
        private PrintStream out;

        public MyClass2(PrintStream out) {
            this.out = out;
        }

        public void foo() {
            out.println("bar");
        }
    }

    public static void main(String[] args) {
//        List<Object> arr1 = new ArrayList<>();
//        arr1.add(new Object());
//        List<MyClass> arr2 = new ArrayList<>();
//        arr2.add(new MyClass());
//
//        foo(arr1);
//        foo(arr2);

        Class tmpClass = MyClass2.class;
//        try {
//            Constructor<MyClass2> tmpCtr = tmpClass.getConstructor(
//                    PrintStream.class
//            );
//            MyClass2 tmp = tmpCtr.newInstance(System.out);
//            tmp.foo();
//
//            Class[] tmpParams = tmpCtr.getParameterTypes();
//        } catch (NoSuchMethodException e) {
//            throw new RuntimeException(e);
//        } catch (InvocationTargetException e) {
//            throw new RuntimeException(e);
//        } catch (InstantiationException e) {
//            throw new RuntimeException(e);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }

        Field[] tmpFields = tmpClass.getDeclaredFields();
        for(Field f : tmpFields)
            System.out.println(f);

        MyClass2 tmp = new MyClass2(System.out);
        try {
            tmpFields[0].set(tmp, new PrintStream(System.out));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
