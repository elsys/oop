#include <iostream>
#include <list>

using namespace std;

class MyList {
  list<int> internal_list;
public:
  class iterator {
      list<int>::iterator internal_it;
    public:
        iterator(list<int>::iterator it) : internal_it(it) {}

        void operator++(int v) {
            internal_it++;
        }

        int operator*() {
            return *internal_it;
        }

        bool operator!=(const iterator &other) const {
            return internal_it != other.internal_it;
        }
  };

  void operator+=(int val) {
    internal_list.push_back(val);
  }

  MyList operator+(int val) {
    MyList new_list = *this;
    new_list += val;
    return new_list;
  }

  void operator-=(int val) {
    internal_list.remove(val);
  }

  int operator--() {
    int val = internal_list.front();
    internal_list.pop_front();
    return val;
  }

  MyList operator-(int val) {
    MyList new_list = *this;
    new_list -= val;
    return new_list;
  }

  friend ostream& operator<<(ostream& out, const MyList& ml);
  friend istream& operator>>(istream& in, const MyList& ml);

  iterator begin() {
      return iterator(internal_list.begin());
  }

  iterator end() {
      return iterator(internal_list.end());
  }
};

ostream& operator<<(ostream& out, const MyList& ml) {
  out << "[";
  for(list<int>::const_iterator it = ml.internal_list.begin(); it != ml.internal_list.end(); it++) {
    out << *it << ", ";
  }
  out << "]";
  return out;
}

istream& operator>>(istream& in, MyList& ml) {
  int val;
  in >> val;
  ml += val;
  return in;
}

int main() {
  MyList l1;
  l1 += 5;

  MyList l2 = l1 + 7;

  MyList l3 = l2;
  l3 -= 5;

  MyList l4;
  cout << "Enter 3 numbers: ";
  cin >> l4 >> l4 >> l4;
  int val = --l4;

  MyList l5 = l4 - 12;

  cout << "l1 (should be [5]): " << l1 << endl;
  cout << "l2 (should be [5, 7]): " << l2 << endl;
  cout << "l3 (should be [7]): " << l3 << endl;
  cout << "l4 (should be [entered numbers 2 and 3]): " << l4 << endl;
  cout << "first value from l4: " << val << endl;
  cout << "l5 (should be [l4 without any 12]): " << l5 << endl;

  cout << "l1, but using iterator:" << endl;
  for(MyList::iterator it = l1.begin(); it != l1.end(); it++) {
    cout << *it << endl;
  }

  return 0;
}
