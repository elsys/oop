#include <stdio.h>

typedef struct point
{
	int x, y;
} Point;

void setpoint(Point *p, int x0, int y0)
{
	p->x = x0;
	p->y = y0;
}

void movepoint(Point *p, int dx, int dy)
{
	p->x += dx;
	p->y += dy;
}

void printpoint(Point *p)
{
	printf("(%d, %d)", p->x, p->y);
} 


int main(int argc, char **argv)
{
	Point p1;
	Point p2;
	
	int nx, ny;
	int dx, dy;
	
	printf("Enter p1: ");
	scanf("%d %d", &nx, &ny);
	setpoint(&p1, nx, ny);

	printf("Enter p2: ");
	scanf("%d %d", &nx, &ny);
	setpoint(&p2, nx, ny);
	printpoint(&p1);
	printf(", ");
	printpoint(&p2);
	printf("\n");

	printf("Enter p2 changes: ");
	while(scanf("%d %d", &dx, &dy) == 2)
	{
		movepoint(&p2, dx, dy);
		printpoint(&p2);
		printf("\n");
	}
	return 0;
}


