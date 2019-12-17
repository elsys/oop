#include "load.h"

LoadPlane::LoadPlane(int size, std::string flight_number, 
							std::string flight_model, bool is_civilian, 
							bool is_military, float speed, float amount_fuel, 
							float expense, float position_x, int curr_load, int max_load) : 
	Plane(size, flight_number, flight_model, is_civilian, is_military,
			speed, amount_fuel, expense, position_x),
	curr_load(curr_load), max_load(max_load){};

LoadPlane::LoadPlane(const LoadPlane& load_plane){
	this->size = load_plane.size;
	this->flight_number = load_plane.flight_number;
	this->flight_model = load_plane.flight_model;
	this->is_civilian = load_plane.is_civilian;
	this->is_military = load_plane.is_military;
	this->speed = load_plane.speed;
	this->amount_fuel = load_plane.amount_fuel;
	this->expense = load_plane.expense;
	this->position_x = load_plane.position_x;
	this->curr_load = load_plane.curr_load;
	this->max_load = load_plane.max_load;
};

