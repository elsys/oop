#include <math.h>
#include <stdio.h>
#include <stdlib.h>

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

struct vector_t {
  int size;
  int *data;
};

int main(int argc, char *argv[]) {
  int numbers_count = atoi(argv[1]);
  struct vector_t numbers = {
		numbers_count,
		(int*)malloc(numbers_count * sizeof(int))
	};

  for (int i = 0; i < numbers_count; ++i) {
    int number;
    scanf("%d", &number);
    numbers.data[i] = number;
  }
  for (int i = 0; i < numbers.size; ++i) {
    print_digits(numbers.data[i]);
  }
	
	free(numbers.data);

  return 0;
}
