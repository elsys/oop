#include <iostream>

using namespace std;

class ListError {};

template<class T>
class List {
    class Node {
    public:
        T data_;
        Node* next_;
        Node* prev_;
        
        Node(T data) : next_(0), prev_(0), data_(data) {}
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
    
    bool empty() {
    	return head_ -> next_ == head_;
    }
    
    void push_front(T value) {
        Node* new_data = new Node(value);
        Node* old_first = head_ -> next_;
        old_first -> prev_ = new_data;
        new_data -> next_ = old_first;
        head_ -> next_ = new_data;
        new_data -> prev_ = head_;
    }
    
    void push_back(T value) {
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
    
    T front() {
        if (empty()) {
            throw ListError();
        }
        return head_ -> next_ -> data_;
    }
    
    T back() {
        if (empty()) {
            throw ListError();
        }
        return head_ -> prev_ -> data_;
    }
};

template<class T>
class Stack {
	List<T> data_;
public:
	Stack() {}
	
	void push(T value) {
		data_.push_back(value);
	}
	//...
};

template<class T>
List<T> merge(const List<T>& l1, const List<T>& l2) {
	// ...
}

int main() {
	List<double> l1;
	for (int i = 0; i < 10; i++) {
		l1.push_back(10.49 * i);
	}
	
	cout << l1.back() << " " << l1.front() << endl;
	
}
