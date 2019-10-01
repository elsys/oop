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
  int capacity;
  int *data;
};

void vector_init(struct vector_t *vector) {
  vector->size = 0;
  vector->capacity = 8;
  vector->data = (int*)malloc(vector->capacity * sizeof(int));
}

void vector_push(struct vector_t *vector, int number) {
  if (vector->size == vector->capacity) {
    vector->capacity *= 2;
    vector->data = (int*)realloc(vector->data, vector->capacity * sizeof(int));
  }
  vector->data[vector->size++] = number;
}

int vector_get(struct vector_t *vector, int index) {
  return vector->data[index];
}

int vector_size(struct vector_t *vector) {
  return vector->size;
}

void vector_free(struct vector_t *vector) {
  free(vector->data);
}

int main(int argc, char *argv[]) {
  int numbers_count = atoi(argv[1]);
  struct vector_t numbers;
  vector_init(&numbers);

  for (int i = 0; i < numbers_count; ++i) {
    int number;
    scanf("%d", &number);
    vector_push(&numbers, number);
  }
  for (int i = 0; i < vector_size(&numbers); ++i) {
    print_digits(vector_get(&numbers, i));
  }

  vector_free(&numbers);

  return 0;
}
