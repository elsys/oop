#include <iostream>

using namespace std;

class ListError {};

class List {
    class Node {
    public:
        int data_;
        Node* next_;
        Node* prev_;
        
        Node(int data) : next_(0), prev_(0), data_(data) {}
    };
    
    Node* head_; 
    
public:
    
    List() : head_(new Node(0)) {
        head_ -> next_ = head_;
        head_ -> prev_ = head_;
    }
    
    ~List() {
        cout << "calling destructor" << endl;
        while(!empty()) {
            pop_front();
        }
        delete head_;
    }
    
    class Iterator {
        Node* current_;
        
        public:
        
        Iterator(Node* current) : current_(current) {}
        
        int operator*() const {
            return current_ -> data_;
        }
        
        Iterator& operator++() {
            current_ = current_ -> next_;
            return *this;
        }
        
        Iterator operator++(int) {
            Iterator result(current_);
            current_ = current_ -> next_;
            return result;
        }
        
        bool operator!=(const Iterator& other) const {
            return current_ != other.current_;
        }
        
        bool operator==(const Iterator& other) const {
            return current_ == other.current_;
        }
    };
    
    Iterator begin() {
        return Iterator(head_ -> next_);
    }
    
    Iterator end() {
        return Iterator(head_);
    }

    void push_front(int value) {
        Node* new_data = new Node(value);
        Node* old_first = head_ -> next_;
        old_first -> prev_ = new_data;
        new_data -> next_ = old_first;
        head_ -> next_ = new_data;
        new_data -> prev_ = head_;
    }
    
    void push_back(int value) {
        Node* new_data = new Node(value);
        Node* last = head_ -> prev_;
        last -> next_ = new_data;
        new_data -> prev_ = last;
        head_ -> prev_ = new_data;
        new_data -> next_ = head_;
    }
    
    void pop_front() {
        if (empty()) {
            throw ListError();
        }
        Node* first = head_ -> next_;
        head_ -> next_ = first -> next_;
        first -> next_ -> prev_ = head_;
        delete first;
    }
    
    void pop_back() {
        if (empty()) {
            throw ListError();
        }
        Node* last = head_ -> prev_;
        head_ -> prev_ = last -> prev_;
        last -> prev_ -> next_ = head_;
        delete last;
    }
    
    int front() {
        if (empty()) {
            throw ListError();
        }
        return head_ -> next_ -> data_;
    }
    
    int back() {
        if (empty()) {
            throw ListError();
        }
        return head_ -> prev_ -> data_;
    }
    
    bool empty() {
        return head_ -> next_ == head_;
    }
    
    int size() {
        Node* next = head_ -> next_;
        int size = 0;
        while (next != head_) {
            size++;
            next = next -> next_;
        }
        return size;
    }
};

int main() {
    List l1;
    cout << boolalpha << l1.empty() << " " << l1.size() << endl;
    for (int i = 0; i < 10; i++) {
        l1.push_front(i);
    }
    for (int i = 0; i < 10; i++) {
        l1.push_back(i);
    }
    cout << l1.empty() << " " << l1.size() << endl;
    try {
        for (int i = 0; i < 20; i++) {
            cout << l1.front() << " " << l1.back() << "; ";
            l1.pop_front();
        }    
        cout << endl;
        cout << l1.back() << endl;
        cout << "This won't be executed" << endl;
    } catch (ListError e) {
        cerr << "List error" << endl;
    }
    cout << l1.empty() << " " << l1.size() << endl;
    l1.push_front(100);
    List::Iterator it = l1.begin();
    cout << "From iterator: " << *it << endl;
    
    for (int i = 0; i < 10; i++) {
        l1.push_back(i);
    }
    
    for (List::Iterator it = l1.begin(); it != l1.end(); it++) {
        cout << *it << " ";
    }
    cout << endl;
    return 0;
}
