#include <iostream>
#include <fstream>
#include <list>

using namespace std;

class Field {
  string type;
  unsigned int produced_quantity;
  unsigned int needed_workers;
public:
  Field(string type, unsigned int quantity, unsigned int workers) {
    this->type = type;
    produced_quantity = quantity;
    needed_workers = workers;
  }

  string get_type() { return type; }
  unsigned int get_produced_quantity() { return produced_quantity; }
  unsigned int get_needed_workers() { return needed_workers; }

  void print() {
    cout << type << " " << produced_quantity << " " << needed_workers << endl;
  }
};

class NoFieldsException : exception {};
class NoSuchFieldException : exception {};

class Farm {
  list<Field> fields;
  string name;
  unsigned int workers = 0;
public:
  Farm(string name) {
    this->name = name;
  }

  Farm(string name, unsigned int workers) {
    this->name = name;
    this->workers = workers;
  }

  Farm(string name, unsigned int workers, list<Field> fields) {
    this->fields = fields;
    this->name = name;
    this->workers = workers;
  }

  void add_field(Field field) {
    fields.push_back(field);
  }

  int get_production(string type) {
    if(fields.size() <= 0) throw NoFieldsException();

    int total_produced = 0;
    unsigned int available_workers = workers;
    bool has_such_field = false;

    for(list<Field>::iterator it = fields.begin(); it != fields.end(); it++) {
      Field field = *it;
      if(field.get_type() == type) {
        has_such_field = true;

        if(field.get_needed_workers() <= available_workers) {
          total_produced += field.get_produced_quantity();
          available_workers -= field.get_needed_workers();

          if(available_workers <= 0) break;
        }
      }
    }

    if(!has_such_field) throw NoSuchFieldException();

    return total_produced;
  }

  void print() {
    cout << endl << name << " " << workers << endl;

    for(list<Field>::iterator it = fields.begin(); it != fields.end(); it++) {
      cout << "\t";
      (*it).print();
    }
  }

  void read_file(string file_name) {
    ifstream in = ifstream(file_name);

    if(in.is_open()) {
      getline(in, name);
      in >> workers;

      int field_count = 0;
      in >> field_count;
      in.ignore();

      for(int i=0; i < field_count; i++) {
        string type;
        unsigned int quantity;
        unsigned int workers;

        getline(in, type);
        in >> quantity >> workers;
        in.ignore();

        add_field(Field(type, quantity, workers));
      }

      in.close();

      cout << "Successfully read " << file_name << endl;
    }
  }

  void save_to_file(string file_name) {
    ofstream out = ofstream(file_name);

    if(out.is_open()) {
      out << name << endl;
      out << workers << endl;
      out << fields.size() << endl;

      for(list<Field>::iterator it = fields.begin(); it != fields.end(); it++) {
        Field field = *it;
        out << field.get_type() << endl;
        out << field.get_produced_quantity() << " ";
        out << field.get_needed_workers() << endl;
      }

      out.close();

      cout << "Successfully wrote to " << file_name << endl;
    }
  }
};

void input_fields(Farm* farm) {
  while(!cin.eof() && cin.good()) {
    string type;
    unsigned int quantity;
    unsigned int workers;

    cout << "Enter field type: ";
    getline(cin, type);
    if(cin.eof() || !cin.good()) return;

    cout << "Enter produced quantity: ";
    cin >> quantity;
    if(cin.eof() || !cin.good()) return;

    cout << "Enter needed workers: ";
    cin >> workers;
    if(cin.eof() || !cin.good()) return;
    cin.ignore();

    farm->add_field(Field(type, quantity, workers));
  }
}

void test_get_production(Farm* farm) {
  try {
    cout << "Enter field type: ";
    string type;
    getline(cin, type);

    if(cin.eof() || !cin.good()) return;

    int produced = farm->get_production(type);
    cout << "Production for " << type << " is " << produced << endl;
  } catch(NoFieldsException ex) {
    cout << "The list of fields is empty" << endl;
  } catch(NoSuchFieldException ex) {
    cout << "The farm does not have this field" << endl;
  }
}

int main() {
  Farm my_farm = Farm("OOP Farm", 30);

  cout << "== Demo for inputting fields ==" << endl;
  input_fields(&my_farm);
  cin.clear();

  cout << endl;
  my_farm.print();
  cout << endl;

  cout << "== Demo for reading from file ==" << endl;
  my_farm.read_file("test-in.txt");

  my_farm.print();
  cout << endl;

  cout << "== Demo for saving to file ==" << endl;
  my_farm.save_to_file("test-out.txt");

  cout << "== Demo for get_production ==" << endl;
  test_get_production(&my_farm);

  return 0;
}
