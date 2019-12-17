#include <iostream>
#include "Airport.h"
#include <vector>
#include "Plane.h"

class CantLand {};

using namespace std;

Airport::Airport() {}

Airport::Airport(int planes_amount, int max_plane_size, bool is_plane_allowed, vector<Plane> planes, float x) : planes_amount(planes_amount), max_plane_size(max_plane_size), is_plane_allowed(is_plane_allowed), planes(planes), x(x) {}

Airport::Airport(const Airport& airp) : planes_amount(airp.planes_amount), max_plane_size(airp.max_plane_size), is_plane_allowed(airp.is_plane_allowed), x(airp.x) {}

bool Airport::can_fit_plane(const Plane& p) {return planes.size() != planes.max_size() && max_plane_size <= p.size && p.is_allowed == is_plane_allowed;}
void Airport::land_plane(const Plane& p) {
	if(!can_fit_plane(p)) throw CantLand();
	planes.push_back(p);
}
