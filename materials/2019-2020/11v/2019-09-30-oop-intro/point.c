#include <math.h>
#include <stdio.h>

struct point_t {
  double x;
  double y;
};

struct point_t point_init(struct point_t *point, double x, double y) {
	point->x = x;
	point->y = y;
}

double point_get_x(struct point_t point) {
  return point.x;
}

double point_get_y(struct point_t point) {
  return point.y;
}

double distance(struct point_t first, struct point_t second) {
  double dx = point_get_x(first) - point_get_x(second);
  double dy = point_get_y(first) - point_get_y(second);

  return sqrt(dx * dx + dy * dy);
}

int main() {
  struct point_t first_point;
	point_init(&first_point, 3, 4);
  struct point_t second_point;
	point_init(&second_point, 42, 312);

  printf("Distance: %f\n", distance(first_point, second_point));

  return 0;
}
