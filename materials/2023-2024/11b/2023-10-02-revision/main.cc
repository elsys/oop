#include <iostream>
#include "vector.hh"
#include "list.hh"

using namespace std;

// ostream cout;

int main() {
    cout << "Hello" << std::endl;

    // Collection* col1 = new Collection();
    // col1.push(10);

    Collection* col2 = new Vector();

    for(int i = 0; i < 10; i++)
        col2->push(i);

    for(int i = 0; i < 5; i++)
        cout << col2->pop() << endl;

    cout << col2->size() << endl;

    col2->clear();
    cout << col2->size() << endl;

    Vector* col3 = new Vector();

    // ...

    delete col3;

    Collection* col4 = new List();

    for(int i = 0; i < 10; i++)
        col4->push(i);

    for(int i = 0; i < 5; i++)
        cout << col4->pop() << endl;

    cout << col4->size() << endl;

    col4->clear();
    cout << col4->size() << endl;

    return 0;
}