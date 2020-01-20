#include <iostream>

template <typename T>
void array_copy(T* destination, T* source, size_t size) {
  for (int i = 0; i < size; ++i) {
    destination[i] = source[i];
  }
}

int main() {
  int array1[10];
  for (int i = 0; i < 10; ++i) {
    array1[i] = i;
  }

  int array2[10];
  array_copy(array2, array1, 10);
  for (int i = 0; i < 10; ++i) {
    std::cout << array2[i] << ", ";
  }
  std::cout << '\n';

  double array3[10];
  for (int i = 0; i < 10; ++i) {
    array3[i] = i;
  }
  double array4[10];
  array_copy(array4, array3, 10);

  for (int i = 0; i < 10; ++i) {
    std::cout << array4[i] << ", ";
  }
  std::cout << '\n';

  return 0;
}
