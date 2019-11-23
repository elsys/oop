#ifndef BASE_OBJECT_HH
#define BASE_OBJECT_HH

#include "./position.hh"
#include "./rotation.hh"
#include "./scale.hh"
#include "./model.hh"

class BaseObject {
public:
  Position pos;
  Rotation rot;
  Scale scale;
  Model model;
};

#endif
