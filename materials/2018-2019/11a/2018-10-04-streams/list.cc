#include <list>
#include <iostream>

using namespace std;

void print_list(list<int> li) {
    for(list<int>::iterator it = li.begin(); it != li.end(); it++) {
        cout << *it << endl;
    }
}

int main() {
    list<int> l1;

    // cout << l1.size() << endl;
    l1.push_front(5);
    l1.push_front(10);

    // print_list(l1);

    l1.push_back(15);

    // print_list(l1);

    auto it = l1.begin();
    it++;
    it = l1.insert(it, 7);
    // print_list(l1);

    // cout << "-------------" << endl;

    l1.erase(it);
    // print_list(l1);

    list<int> l4(10, 14);
    print_list(l4);

    int a[] = {0, 1, 2, 3, 4};
    list<int> l2(a, a+3);
    // print_list(l2);
    auto it1 = l2.end();
    it1--;

    list<int> l3(l2.begin(), l4.end());
    // print_list(l3);

    return 0;
}
