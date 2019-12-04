#include "./base_object.hh"

float BaseObject::distanceTo(BaseObject other) {
  return pos.distanceTo(other.pos);
}
