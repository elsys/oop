#include <stdio.h>
#include <stdlib.h>

int main() {
  int a = 15;
  int *b = &a;
  int **c = &b;
  
 //printf("a=%d &b=%d b=%d *b=%d **c=%d b+1=%d\n", a, &b, b, *b, **c, b+1);
 
  int *d = (int*)malloc(sizeof(int) * 5);
  
  for(int i=0; i < 5; i++) {
    d[i] = i * 5;
  }
  
  for(int i=0; i < 5; i++) {
    printf("d[%d]=%d\n", i, *(d + i));
  }
  
  free(d);
  d = NULL;
  
  /*for(int i=0; i < 5; i++) {
    printf("d[%d]=%d\n", i, *(d + i));
  }*/
  
  int **arr = NULL;
  arr = malloc(sizeof(int*) * 5);
  for(int i=0; i<5; i++) {
    arr[i] = malloc(sizeof(int) * 3);
  }
  
  for(int i=0; i<5; i++) {
    for(int j=0; j<3; j++) {
      arr[i][j] = i * j;
    }
  }
  
  for(int i=0; i<5; i++) {
    for(int j=0; j<3; j++) {
      printf("arr[%d][%d]=%d\n", i, j, arr[i][j]);
    }
  }
  
  int *arr2 = malloc(sizeof(int) * 3 * 5);
  
  for(int i=0; i<5; i++) {
    for(int j=0; j<3; j++) {
      arr2[(i * 3) + j] = i * j;
    }
  }
  
  for(int i=0; i<5; i++) {
    for(int j=0; j<3; j++) {
      printf("arr2[%d][%d]=%d\n", i, j, arr2[(i * 3) + j]);
    }
  }

  return 0;
}
