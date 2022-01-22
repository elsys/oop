#include <cstddef>

#include "BaseObject.hh"
#include "GC.hh"

void* BaseObject::operator new(size_t size) {
  return GC::allocate(size);
}

void* BaseObject::operator new[](size_t size) {
  return GC::allocate(size);
}

void BaseObject::operator delete(void* ptr) {
  GC::free(ptr);
}

void BaseObject::operator delete[](void* ptr) {
  GC::free(ptr);
}
