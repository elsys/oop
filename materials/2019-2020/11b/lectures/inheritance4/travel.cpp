#include "travel.h"

TravelPlane::TravelPlane(int size, std::string flight_number, 
								 std::string flight_model, bool is_civilian, 
								 bool is_military, float speed, float amount_fuel, 
								 float expense, float position_x, int passengers,
								 int seats, int exits) : 
	Plane(size, flight_number, flight_model, is_civilian, is_military,
			speed, amount_fuel, expense, position_x),
	passengers(passengers), seats(seats), exits(exits){};

TravelPlane::TravelPlane(const TravelPlane& travel_plane){
	this->size = travel_plane.size;
	this->flight_number = travel_plane.flight_number;
	this->flight_model = travel_plane.flight_model;
	this->is_civilian = travel_plane.is_civilian;
	this->is_military = travel_plane.is_military;
	this->speed = travel_plane.speed;
	this->amount_fuel = travel_plane.amount_fuel;
	this->expense = travel_plane.expense;
	this->position_x = travel_plane.position_x;
	this->passengers = travel_plane.passengers;
	this->seats = travel_plane.seats;
	this->exits = travel_plane.exits;
};

