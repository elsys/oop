#include <iostream>
#include <string>
#include <list>
using namespace std;

class Cat {
  public:
  const string name;
  short age;
  Cat(string name, short age) : name(name), age(age) {}
};

class Dog {
  public:
  const string name;
  short age;
  Dog(string name, short age) : name(name), age(age) {}
};

class Shelter {
  Shelter() {}
  public:
  static list<Cat> cats;
  static list<Dog> dogs;
  
  static void addAnimal(string kind, string name, short age) {
    if(kind == "cat") {
      Cat newCat = Cat(name, age);
      cats.push_back(newCat);
    }
    if(kind == "dog") {
      Dog newDog = Dog(name, age);
      dogs.push_back(newDog);
    }
  }
};

list<Cat> Shelter::cats;
list<Dog> Shelter::dogs;

int main() {
  Shelter::addAnimal("cat", "Cat1", 1);
  Shelter::addAnimal("cat", "Cat2", 5);
  Shelter::addAnimal("dog", "Dog1", 3);

  cout << Shelter::cats.size() << " " << Shelter::dogs.size() << endl; 

  return 0;
}
