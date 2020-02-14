class Sorting {
  public static void selectionSort(int[] array) {
    for (int i = 0; i < array.length - 1; ++i) {
      int minIndex = i;
      for (int j = i + 1; j < array.length; ++j) {
        if (array[minIndex] > array[j]) {
          minIndex = j;
        }
      }
      int temp = array[minIndex];
      array[minIndex] = array[i];
      array[i] = temp;
    }
  }
}

class Main {
  public static void main(String[] args) {
    int[] numbers = new int[] { 42, 1, 6, 4, 2, -42 };

    Sorting.selectionSort(numbers);

    for (int x : numbers) {
      System.out.println(x);
    }
  }
}
