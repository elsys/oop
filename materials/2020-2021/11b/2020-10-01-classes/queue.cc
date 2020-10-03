#include <iostream>
using namespace std;

class Node{
public:
    double var;
    Node* next;
    Node(double x, Node* y){
        var = x;
        next = y;
    }
};

class Queue_h{
    Node* first;
public:
    Queue_h(){
        first = NULL;
    }
    void Push(double x){
        Node* end = new Node(x, NULL);
        if(first == NULL){
            first = end;
        }
        else{
            Node* curr = first;
            while(curr->next != NULL){
                curr = curr->next;
            }
            curr->next = end;
        }

    }
    double Pop(){
        double result = first->var;
        Node* curr_2;
        curr_2 = first->next;
        delete first;
        first = curr_2;
        return result;

    }
};

int main()
{
    Queue_h numbers;
    numbers.Push(4);
    numbers.Push(7);
    numbers.Push(9);
    numbers.Push(1);
    numbers.Pop(7);


    return 0;
}
