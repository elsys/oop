import java.util.List;
import java.util.LinkedList;

class Main {
  public static void main(String[] args) {
    int[] numbers1 = {1, 2, 3, 4, 5};
    int[] numbers2 = new int[5];
    int[] numbers3;

    System.out.println(numbers1);
    System.out.println(numbers2);
    // System.out.println(numbers3);

    List<Integer> numbers4 = new LinkedList<>();
    numbers4.add(1);
    int val = numbers4.get(0);
  }
}