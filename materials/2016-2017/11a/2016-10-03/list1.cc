#include <iostream>
#include <list>

using namespace std;

void print_first_last(list<int> l) {
    cout << "First: " << l.front() << " Last: "
        << l.back() << endl;
}

void print_all(list<int> l) {
    cout << "List: ";
    for (list<int>::iterator it = l.begin();
         it != l.end(); it++) {
         cout << *it << " ";
    }
    cout << endl;
}

int main() {
    list<int> l1;
    l1.push_front(1);
    print_all(l1);
    l1.push_front(12);
    print_all(l1);
    l1.push_back(13);
    print_all(l1);
    l1.pop_front();
    print_all(l1);
 
    int a[] = {1, 2, 3, 4, 5, 6};
    list<int> l2(a, a + 6);
    print_all(l2);
    
    list<int>::iterator it2 = l2.end();
    --it2;
    l2.insert(it2, 7);
    print_all(l2);
    cout << "Position of it2 " << *it2 << endl;
    
    l2.erase(--l2.end());
    print_all(l2);
    return 0;
}





