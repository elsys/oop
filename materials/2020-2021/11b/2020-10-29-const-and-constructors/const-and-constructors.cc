#include <iostream>

using namespace std;

#define SOME_CONST 9

class my_exception : exception {
public:
  const char* what() {
    return "hello there";
  }
};

class vet {
public:
  int worker_count = 3;
  int animal_count = 5;
  const string name = "vet 1";
  int* animal_ids = NULL;
  
  vet() {
    animal_ids = new int[animal_count];
    for(int i=0; i < animal_count; i++) {
      animal_ids[i] = i * 5;
    }
  }
  
  vet(int _worker_count_, int animal_count, string name) : worker_count(_worker_count_), animal_count(animal_count), name(name) {
    animal_ids = new int[animal_count];
    for(int i=0; i < animal_count; i++) {
      animal_ids[i] = i * 5;
    }
    //worker_count = _worker_count_;
    //this->animal_count = animal_count;
    //this->name = name;
  }
  
  vet(const vet& other) : worker_count(other.worker_count), animal_count(other.animal_count), name(other.name)  {
    animal_ids = new int[animal_count];
    for(int i=0; i < animal_count; i++) {
      animal_ids[i] = other.animal_ids[i];
    }
  }
  
  void print() {
    cout << worker_count << " " << animal_count << " " << name << endl;
    for(int i=0; i < animal_count; i++) {
      cout << animal_ids[i] << " ";
    }
    cout << endl;
  }
};

int main() {
  /*int a = 65;
  int b = 8;
  
  const int c = SOME_CONST;
  int const d = c;
  
  //SOME_CONST = a;
  
  //c = 32;
  
  // int* a, b, c;
  // int *a, b, c;  
  
  const int * ptr_to_const_1 = &c;
  int const * ptr_to_const_2 = &c;
  
  int * const const_ptr = &a;
  
  const int * const const_ptr_to_const = &c;
  
  // (*ptr_to_const_1) = 4;
  // const_ptr = &b;
  
  cout << a << " " << b << " " << c << endl;
  
  my_exception ex;
  const char* str = ex.what();
  
  //str[2] = 'j';
  
  cout << str << endl;*/
  
  vet vet1 = vet(5, 3, "Veterinar 1");
  //vet1.worker_count = 5;
  //vet1.animal_count = 3;
  //vet1.name = "Veterianr 1";
  vet vet2;
  
  vet vet3 = vet1;
  vet1.animal_ids[0] = 500;
  
  //cout << vet1.worker_count << " " << vet1.animal_count << " " << vet1.name << endl;
  //cout << vet2.worker_count << " " << vet2.animal_count << " " << vet2.name << endl;
    
  cout << &vet1 << " " << &vet2 << " " << &vet3 << endl;
  
  vet1.print();
  vet2.print();
  vet3.print();

  return 0;
}
