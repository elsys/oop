#include <iostream>

using namespace std;

class ListError {
	string message_;
public:
	ListError(string message) : message_(message) {}

	ListError() {}

	string get_message() const {
		return message_;
	}
};

template<class T>
class List {
	struct Node {
		T data_;
		Node* next_;
		Node* prev_;
		Node() {}
		Node(T data, Node* next, Node* prev)
			: data_(data), next_(next), prev_(prev) {}
	};
	
	Node* head_;

public:

	List() : head_(new Node(T(), NULL, NULL)) {
		head_ -> next_ = head_;
		head_ -> prev_ = head_;
	}

	~List() {
		while(!empty()) {
			pop_back();
		}
		delete head_;
	}

	void push_back(const T& value) {
		Node* new_node = new Node(value, head_, head_ -> prev_);
		head_ -> prev_ -> next_ = new_node;
		head_ -> prev_ = new_node;
	}

	void pop_back() {
		if (empty()) {
			throw ListError("Wrong call List::pop_back()");
		}
		Node* last = head_ -> prev_;
		head_ -> prev_ = last -> prev_;
		last -> prev_ -> next_ = head_;
		delete last;
	}

	T back() const {
		if (empty()) {
			throw ListError("Wrong call List::back()!");
		}
		return head_ -> prev_ -> data_;
	}

	bool empty() const {
		return head_ -> next_ == head_;
	}
};

int main() {

	List<ListError> errors;
	
	try {
		List<double> doubles;
		for (int i = 0; i < 10; i++) {
			doubles.push_back(i * 0.11);
		}
		for (int i = 0; i < 11; i++) {
			cout << doubles.back() << endl;
			doubles.pop_back();
		}
	} catch (ListError lerr) {
		errors.push_back(lerr);
	}
	
	cout << errors.back().get_message() << endl;
}








