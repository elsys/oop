#include <iostream>
using namespace std;

class ListError{};

class List{
    struct Node{
        int data_;
        Node* next_;
        Node* prev_;

        Node(int data):
            data_(data),
            next_(nullptr),
            prev_(nullptr){}
    };

    Node* head_;

	friend class iteraror;
public:
    List():
        head_(new Node(0)){
        head_->next_ = head_;
        head_->prev_ = head_;
    }

    ~List(){
        to_empty(); //this->to_empty();
        delete head_;
    }

    List(const List& other):
            head_(new Node(0)){

        head_->next_ = head_;
        head_->prev_ = head_;
        Node* node = other.head_->next_;
        while (node != other.head_){
            push_back(node->data_);
            node = node->next_;
        }
    }


    bool empty() const {
        return head_->next_ == head_;
    }

    void push_back(int data){
        Node* element = new Node(data);
        Node* last_element = head_->prev_;

        last_element->next_ = element;
        element->prev_ = last_element;

        element->next_ = head_;
        head_->prev_ = element;
    }

    int back() const{
        if(empty()){
            throw ListError();
        }
        return head_->prev_->data_;
    }

    int pop_back(){
        if(empty()){
            throw ListError();
        }

        Node* last_element = head_->prev_;
        Node* new_last_element = last_element -> prev_;

        new_last_element->next_ = head_;
        head_->prev_ = new_last_element;

        int data = last_element->data_;
        delete last_element;

        return data;
    }


    List& operator=(const List& other){

        if (this != &other) {
            to_empty(); //this->to_empty();
            Node* node = other.head_ -> next_;
            while (node != other.head_) {
                push_back(node -> data_);
                node = node -> next_;
            }
        }
        return *this;

    }


    bool to_empty() {
        while (!empty()) {
            pop_back();
        }
    }
    
    class iterator {
    	Node* current_;
    	
    	iterator(Node* node)
    	: current_(node)
    	{}
    	friend class List;
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

		iterator& operator++() {
			current_ = current_ -> next_;
			return *this;
		}

		iterator operator++(int) {
			iterator res(current_);
			current_ = current_ -> next_;
			return res;
		}

		bool operator==(const iterator& other) const {
			return current_ == other.current_;
		}
		
		bool operator!=(const iterator& other) const {
			return ! operator==(other);
		}
		/*
		operator--();
		operator--(int);
		*/
    };
    
    iterator begin() {
    	return iterator(head_-> next_);
    }
    
    iterator end() {
    	return iterator(head_);
    }
    
    // iterator rbegin();
    // iterator rend();
    
    
};

int main(){
    List list;

    list.push_back(1);
    list.push_back(2);


	List::iterator it = list.begin();
	int v1 = *it;
	cout << "*it=" << (*it) << endl;

	*it = 18;
	cout << "*it=" << (*it) << endl;
	
	// ++it;
	it ++;
	
	int v2 = *it;
	cout << "*it=" << (*it) << endl;
	
	int v3 = *(it++);
	
	cout << "v3=" << v3 << endl;
	
	if(it==list.end()) {
		cout << "at the end of the list" << endl;
	}

	for(List::iterator it=list.begin(); it!=list.end(); ++it) {
		cout << *it << endl;
	}
	
	/*
	for(List::iterator it = list.rbegin(); it!= list.rend(); --it) {
		cout << *it << endl;
	}
	*/
	
   return  0;
}
