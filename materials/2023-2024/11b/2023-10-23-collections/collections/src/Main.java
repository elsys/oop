import java.util.*;

public class Main extends Object {
    public static void main(String[] args) {
//        String addr = "1.2.3.4";
//        String[] parts = addr.split(".");
//
//        if(parts.length != 4) return false;
//        for(int i = 0; i < parts.length; i++) {
//            int val = Number(parts[i]);
//            if(val < 0 || val > 255) return false;
//        }

//        int[] vals = new int[5];
//        int[] vals2 = {1,2,3,4,5};
//        Object[] vals3 = {new Object(), new Main(), Integer.valueOf(5)};
//        for(int i = 0; i < vals2.length; i++) {
//            System.out.println(vals2[i]);
//        }

        Vector<Integer> vec = new Vector<>();
        vec.add(0);
        vec.remove(0);
        vec.remove(Integer.valueOf(0));
        vec.size();
        vec.elementAt(5);
        vec.set(3, 10);

        List<Integer> l1 = new LinkedList<>();
        l1.add(0);
        l1.remove(0);
        l1.remove(Integer.valueOf(0));
        l1.size();
//        l1.elementAt(5);
        l1.set(3, 10);

        List<Integer> l2 = new ArrayList<>();
        l2.add(0);
        l2.remove(0);
        l2.remove(Integer.valueOf(0));
        l2.size();
        l2.set(3, 10);

        Stack<Integer> st1 = new Stack<>();
        st1.add(5);
        st1.remove(5);
        st1.peek();
        st1.pop();

        Queue<Integer> q1 = new ArrayDeque<>();
        q1 = new LinkedList<>();
        q1.add(5);
        q1.peek();
        q1.poll();

        Collection<Integer> col1 = new LinkedList<>();
        col1.add(5);


        for(int i = 0; i < vec.size(); i++) {
            System.out.println(vec.get(i));
        }

        for(int i = 0; i < l1.size(); i++) {
            System.out.println(l1.get(i));
        }

        for(int val : vec) {
            System.out.println(val);
        }

//        l1.forEach((val) -> System.out.println(val));

        for(Iterator<Integer> it = vec.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
    }
}
