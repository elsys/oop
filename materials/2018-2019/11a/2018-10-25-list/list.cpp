#include <iostream>

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
};

int main(){
    List list;

    list.push_back(1);
    list.push_back(2);

    List list2 = list;

    std::cout << list.pop_back() << std::endl;

    std::cout << list2.back() << std::endl;


    return  0;
}
