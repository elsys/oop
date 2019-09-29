#include <iostream>
#include <vector>

using namespace std;

void print_with_iterator(vector<int>& v) {
    cout << "Vector(size=" << v.size() << ", cap="
         << v.capacity() << "): ";
    for (vector<int>::iterator it = v.begin();
         it != v.end(); it++) {
         cout << *it << " ";
    }
    cout << endl;
}

void print(vector<int>& v) {
    cout << "Vector(size=" << v.size() << ", cap="
         << v.capacity() << "): ";
    for (int i = 0; i < v.size(); i++) {
         cout << v[i] << " ";
    }
    cout << endl;
}

int main() {
    vector<int> v1;
    print(v1);
    for (int i = 0; i < 10; i++) {
        v1.push_back(i);
    }
    print(v1);
    
    vector<int> v2(15);
    v2[10] = 10;
    v2[13] = 11;
    print(v2);
    v2[20] = 10;
    return 0;
}








