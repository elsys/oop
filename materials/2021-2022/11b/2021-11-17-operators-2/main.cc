#include <iostream>

using namespace std;

class Vector {
  float x = 0, y = 0, z = 0;
public:
  Vector() {}
  Vector(float x, float y, float z) : x(x), y(y), z(z) {}

  friend ostream& operator<<(ostream& out, const Vector& vec) {
    out << "(" << vec.x << ", " << vec.y << ", " << vec.z << ")";

    return out;
  }

  friend istream& operator>>(istream& in, Vector& vec) {
    in >> vec.x >> vec.y >> vec.z;

    return in;
  }

  Vector operator+(const int scalar) const {
    return Vector(x + scalar, y + scalar, z + scalar);
  }

  Vector operator+(const Vector& other) const {
    return Vector(x + other.x, y + other.y, z + other.z);
  }

  Vector& operator+=(const int scalar) {
    //*this = *this + scalar;
    x += scalar;
    y += scalar;
    z += scalar;

    return *this;
  }

  Vector& operator+=(const Vector& other) {
    x += other.x;
    y += other.y;
    z += other.z;

    return *this;
  }

  bool operator==(const Vector& other) {
    return x == other.x && y == other.y && z == other.z;
  }

  bool operator!=(const Vector& other) {
    return !(*this == other);
    //return x != other.x || y != other.y || z != other.z;
  }

  Vector& operator++() {
    cout << "prefix++" << endl;
    x++; y++; z++;
    return *this;
  }

  //(b = a)++
  //b = (++a)

  //vec2 = ++vec1

  Vector operator++(int) {
    cout << "postfix++" << endl;
    Vector old(x, y, z);
    x++; y++; z++;
    return old;
    //return Vector(x++, y++, z++);
  }
};

int main() {
  /*int a = 3;
  int b = (a += 5);

  cout << a << " " << b << endl;*/

  Vector vec1;
  Vector vec2(3, 4, 5);

  vec1 = vec1 + 4;
  vec2 = vec1 + vec2;
  vec1 += 4;
  vec2 += vec1;
  //vec2 = Vector(8,8,8);

  //vec2 = vec1++;
  //vec3 = ++vec1;
  //vec1.operator++(3)

  cout << vec1 << endl;
  cout << vec2 << endl;

  cout << (vec1 == vec2) << endl;
  cout << (vec1 != vec2) << endl;

  /*Vector vec3;
  cin >> vec3;

  cout << vec3 << endl;*/

  return 0;
}
