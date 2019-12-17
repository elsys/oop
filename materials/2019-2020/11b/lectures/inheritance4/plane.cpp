#include "plane.h"

Plane::Plane(int size, std::string flight_number, 
				 std::string flight_model, bool is_civilian, 
				 bool is_military, float speed, float amount_fuel, 
				 float expense, float position_x) : 
	size(size), flight_number(flight_number),
	flight_model(flight_model), is_civilian(is_civilian),
	is_military(is_military), speed(speed), 
	amount_fuel(amount_fuel), expense(expense),
	position_x(position_x){};

Plane::Plane(const Plane& plane){
	this->size = plane.size;
	this->flight_number = plane.flight_number;
	this->flight_model = plane.flight_model;
	this->is_civilian = plane.is_civilian;
	this->is_military = plane.is_military;
	this->speed = plane.speed;
	this->amount_fuel = plane.amount_fuel;
	this->expense = plane.expense;
	this->position_x = plane.position_x;
};

ostream& Plane::operator<<(ostream& stream){
	stream << this->size << " " << this->flight_number << " " << 
	this->flight_model << " " << this->is_civilian << " " << 
	this->is_military << " " << this->speed << " " << 
	this->amount_fuel << " " << this->expense << " " << 
	this->position_x << std::endl;
	
	return stream;
}
