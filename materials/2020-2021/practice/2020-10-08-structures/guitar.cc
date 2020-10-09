#include <iostream>
#include <stdexcept>

using namespace std;

class GuitarString {
  double thicness;
public:
  GuitarString() {
    thicness = -1.0;
  }
  GuitarString(double thicness) {
    this->thicness = thicness;
  }

  double getThicness() {
    return thicness;
  }
};

const double MIN_THICNESS = 0.2;
const double MAX_THICNESS = 5.0;

class InvalidThicnessException : exception {};
class InvalidOrderException : exception {};

class Guitar {
  GuitarString strings[6];
public:
  void addString(int index, GuitarString new_string) {
    if(index < 0 || index > 5) throw out_of_range("Invalid index");

    if(new_string.getThicness() < MIN_THICNESS || new_string.getThicness() > MAX_THICNESS) {
      throw InvalidThicnessException();
    }

    for(int i = 0; i < index; i++) {
      if(strings[i].getThicness() >= new_string.getThicness()) {
        throw InvalidThicnessException();
      }
    }

    for(int i = index + 1; i < 6; i++) {
      if(strings[i].getThicness() > 0 &&
         strings[i].getThicness() <= new_string.getThicness()) {
        throw InvalidOrderException();
      }
    }

    strings[index] = new_string;
  }
};

int main() {
  Guitar my_guitar;

  try {
    my_guitar.addString(0, GuitarString(0.3));
    my_guitar.addString(2, GuitarString(2.9));
    my_guitar.addString(1, GuitarString(2.8));
  } catch(InvalidThicnessException ex) {
    cout << "Invalid thicness" << endl;
  } catch(InvalidOrderException ex) {
    cout << "Invalid order" << endl;
  } catch(out_of_range ex) {
    cout << "Invalid index" << endl;
  }

  return 0;
}
