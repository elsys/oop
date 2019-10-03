#include <stdio.h>

struct stack_t {
  int size;
  int elements[100];
};

void stack_init(struct stack_t *stack) {
  stack->size = 0;
}

int stack_empty(struct stack_t *stack) {
  return stack->size == 0;
}

int stack_peek(struct stack_t *stack) {
  return stack->elements[stack->size - 1];
}

void stack_push(struct stack_t *stack, int element) {
  stack->elements[stack->size++] = element;
}

void stack_pop(struct stack_t *stack) {
  --stack->size;
}

int main() {
  struct stack_t stack;
  stack_init(&stack);
  printf("%d\n", stack_empty(&stack));
  stack_push(&stack, 42);
  printf("%d\n", stack_empty(&stack));
  stack_push(&stack, 123);
  printf("%d\n", stack_peek(&stack));
  stack_pop(&stack);
  printf("%d\n", stack_peek(&stack));
  stack_pop(&stack);
  printf("%d\n", stack_empty(&stack));

  return 0;
}
