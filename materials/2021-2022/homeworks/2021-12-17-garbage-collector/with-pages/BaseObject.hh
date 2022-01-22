#pragma once

class BaseObject {
public:
  void* operator new(size_t size);
  void* operator new[](size_t size);

  void operator delete(void* ptr);
  void operator delete[](void* ptr);
};
