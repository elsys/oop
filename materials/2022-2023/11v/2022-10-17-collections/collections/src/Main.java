import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        int[] arr2 = new int[4];
        int[] arr3;

       // arr3 = {4,5,6};

        System.out.println(arr1[0]);
        System.out.println(arr2[0]);
        //System.out.println(arr3);

        Vector<Integer> vec1 = new Vector<>();
        vec1.add(4);
        vec1.add(new Integer(6));
        vec1.add(7);
        vec1.remove((Integer)4);

        for(int i = 0; i < vec1.size(); i++) {
            int a = vec1.get(i);
            System.out.println(a);
        }

        for(Iterator<Integer> it = vec1.iterator(); it.hasNext();) {
            int a = it.next();
            System.out.println(a);
        }

        for(int a : vec1) {
            System.out.println(a);
        }

        for (int a : arr1) {
            System.out.println(a);
        }

        vec1.stream().forEach(System.out::println);

        List<Integer> a = new LinkedList<>();
        a.add(123);
        a = new ArrayList<>(a);
        a = new Vector<>();
        a = new Stack<>();

        new Stack<Integer>();
        new ArrayDeque<>();
    }
}











