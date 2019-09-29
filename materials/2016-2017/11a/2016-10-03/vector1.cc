#include <iostream>
#include <vector>

using namespace std;

void print_all(vector<int> v) {
    cout << "Vector(size=" << v.size() << ", cap="
        << v.capacity() << "): ";
    for (vector<int>::iterator it = v.begin();
         it != v.end(); ++it) {
        cout << *it << " ";
    }
    cout << endl;
}

int main() {
    vector<int> v;
    v.push_back(1);
    v.push_back(2);
    print_all(v);
    v.push_back(3);
    v.pop_back();
    print_all(v);
    
    cout << v[0] << endl;
    return 0;
}
