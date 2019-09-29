#include <iostream>

using namespace std;

class ListException {};

class List {

	struct Node {
		int data_;
		Node *next_, *prev_;
		
		Node(int data)
				: data_(data), next_(nullptr), prev_(nullptr) {}
	};

	Node* head_;
	
public:

	List() : head_(new Node(0)) {
		head_ -> next_ = head_;
		head_ -> prev_ = head_;
	}

	List(const List& other) : List() {
		cout << "Copy constructor" << endl;
		Node* node = other.head_ -> next_;
		while (node != other.head_) {
			push_back(node -> data_);
			node = node -> next_;
		}
	}
	
	~List() {
		cout << "Destructor" << endl;
		clear();
		delete head_;
	}
	
	List& operator=(const List& other) {
		if (this != &other) {
			clear();
			Node* node = other.head_ -> next_;
			while (node != other.head_) {
				push_back(node -> data_);
				node = node -> next_;
			}
		}
		return *this;
	}
	
	bool clear() {
		while (!empty()) {
			pop_back();
		}
	}
	
	bool empty() const {
		return head_ -> prev_ == head_;
	}
	
	void push_back(int value) {
		Node* new_node = new Node(value);
		Node* last = head_ -> prev_;

		last -> next_ = new_node;
		new_node -> prev_ = last;
		
		head_ -> prev_ = new_node;
		new_node -> next_ = head_;
	}
	
	int pop_back() {
		if (empty()) {
			throw ListException();
		}
		Node* last = head_ -> prev_;
		Node* new_last = last -> prev_;
		
		new_last -> next_ = head_;
		head_ -> prev_ = new_last;
		
		int result = last -> data_;
		delete last;
		return result;
	}
	
	int back() const {
		if (empty()) {
			throw ListException();
		}
		return head_->prev_->data_;
	}
	
	class iterator {
		friend class List;
		
		Node* current_;
		
		iterator(Node* node)
		: current_(node)
		{}
		
	public:
		iterator()
		: current_(nullptr)
		{}
	
		int& operator*() {
			return current_ -> data_;
		}
		/*
			*it = 18;
		*/
	
		iterator& operator--();
			
		iterator& operator++() {
			current_ = current_ -> next_;
			return *this;
		}
		
		iterator operator++(int) {
			iterator res(current_);
			current_ = current_ -> next_;
			return res;
		}

		bool operator==(const iterator& other) {
			return current_ == other.current_;
		}
		
		bool operator!=(const iterator& other) {
			return ! operator==(other);
		}
	}; /* iterator end */
	
	iterator begin() {
		return iterator(head_->next_);
	}
	
	iterator end() {
		return iterator(head_);
	}

	/*
	iterator rbegin();
	iterator rend();
	*/
};

int main() {
	List l1;
	l1.push_back(10);
	l1.push_back(20);
	cout << l1.back() << endl;
	
	List::iterator it= l1.begin();

	int v1 = *it;
	cout << "*it=" << *it << endl;
	
	*it = 18;
	cout << "*it=" << *it << endl;

	++it;

	int v2 = *it;
	cout << "*it=" << *it << endl;
	
	int v3 = *(it++);
	
	cout << "v3=" << v3 << endl;
	
	if(it == l1.end()) {
		cout << "at the end of the list" << endl;
	}

	for(List::iterator it=l1.begin(); it!=l1.end(); ++it) {
		cout << *it << endl;
	}

/*
	for(List::iterator it=l1.rbegin(); it!=l1.rend(); --it) {
		cout << *it << endl;
	}
*/
	return 0;
}





