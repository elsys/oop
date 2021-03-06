#include <math.h>
#include <stdio.h>

int digits_count(int number) {
  int count = 1;
  while (number > 9) {
    ++count;
    number /= 10;
  }
  return count;
}

void print_digits(int number) {
  int count = digits_count(number);
  int power = pow(10, count - 1);

  while (count > 1) {
    printf("%d,", (number / power) % 10);
    power /= 10;
    --count;
  }
  printf("%d\n", (number / power) % 10);
}

int main() {
  int numbers[] = {42, 312, 6, 1312};

  for (int i = 0; i < 4; ++i) {
    print_digits(numbers[i]);
  }

  return 0;
}
