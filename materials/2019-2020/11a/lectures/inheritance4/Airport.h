#ifndef AIRPORT_H
#define AIRPORT_H

#include "Plane.h"
#include <vector>

using namespace std;

class Airport {
	public:
		int planes_amount;
		int max_plane_size;
		bool is_plane_allowed;
		vector<Plane> planes;
		float x;
		
		Airport();
		Airport(int planes_amount, int max_plane_size, bool is_plane_allowed, vector<Plane> planes, float x);
		Airport(const Airport& airp);
		
		bool can_fit_plane(const Plane& p);
		void land_plane(const Plane& p);
};

#endif
