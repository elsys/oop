#include <stdio.h>
#include <stdlib.h>

//////////////////////////////////////////////////

struct list_node_t {
    struct list_node_t* next;
    int val;
};

struct list_t {
    struct list_node_t* head;
    struct list_node_t* tail;
};

void init_list(struct list_t* list) {
    list -> head = NULL;
    list -> tail = NULL;
}

void push_to_list(struct list_t* list, int val) {
    struct list_node_t* node = (struct list_node_t*)malloc(sizeof(struct list_node_t));
    node -> next = NULL;
    node -> val = val;

    if(list -> head == NULL) {
        list -> head = node;
    } else {
        list -> tail -> next = node;
    }
    list -> tail = node;
}

int pop_from_list(struct list_t* list) {
    if(list -> head == NULL) {
        return 0;
    }
    int val = list -> head -> val;
    struct list_node_t* oldHead = list -> head;
    list -> head = list -> head -> next;
    free(oldHead);

    return val;
}

//////////////////////////////////////////////////

struct stack_node_t {
    struct stack_node_t* prev;
    int val;
};

struct stack_t {
    struct stack_node_t* head;
    struct stack_node_t* tail;
};

void init_stack(struct stack_t* stack) {
    stack -> head = NULL;
    stack -> tail = NULL;
}

void push_to_stack(struct stack_t* stack, int val) {
    struct stack_node_t* node = (struct stack_node_t*)malloc(sizeof(struct stack_node_t));
    node -> prev = NULL;
    node -> val = val;

    if(stack -> head == NULL) {
        stack -> head = node;
    } else {
        node -> prev = stack -> tail;
    }
    stack -> tail = node;
}

int pop_from_stack(struct stack_t* stack) {
    if(stack -> tail == NULL) {
        return 0;
    }
    int val = stack -> tail -> val;
    struct stack_node_t* oldTail = stack -> tail;
    stack -> tail = stack -> tail -> prev;
    free(oldTail);

    return val;
}

//////////////////////////////////////////////////

struct float_list_node_t {
    struct float_list_node_t* next;
    float val;
};

struct float_list_t {
    struct float_list_node_t* head;
    struct float_list_node_t* tail;
};

void init_float_list(struct float_list_t* list) {
    list -> head = NULL;
    list -> tail = NULL;
}

void push_to_float_list(struct float_list_t* list, float val) {
    struct float_list_node_t* node = (struct float_list_node_t*)malloc(sizeof(struct float_list_node_t));
    node -> next = NULL;
    node -> val = val;

    if(list -> head == NULL) {
        list -> head = node;
    } else {
        list -> tail -> next = node;
    }
    list -> tail = node;
}

float pop_from_float_list(struct float_list_t* list) {
    if(list -> head == NULL) {
        return 0.0;
    }
    float val = list -> head -> val;
    struct float_list_node_t* oldHead = list -> head;
    list -> head = list -> head -> next;
    free(oldHead);

    return val;
}

//////////////////////////////////////////////////

int main()
{
    struct list_t l1;
    init_list(&l1);

    for(int i=0; i< 10; i++) {
        push_to_list(&l1, i+1);
    }

    while(l1.head != NULL) {
        int val = pop_from_list(&l1);
        printf("%d\n", val);
    }

    struct stack_t s1;
    init_stack(&s1);

    for(int i=0; i< 10; i++) {
        push_to_stack(&s1, i+1);
    }

    while(s1.tail != NULL) {
        int val = pop_from_stack(&s1);
        printf("%d\n", val);
    }

    struct float_list_t l2;
    init_float_list(&l2);

    for(int i=0; i< 10; i++) {
        push_to_float_list(&l2, i+1);
    }

    while(l2.head != NULL) {
        float val = pop_from_float_list(&l2);
        printf("%f\n", val);
    }

    return 0;
}
