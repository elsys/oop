#include <iostream>
using namespace std;

class QueueEmptyException : public exception {
};

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
        if(first == NULL) {
          //exception e1;
          //throw e1;
          //throw "Hello";
          //throw -13;
          throw QueueEmptyException();
        }

        double result = first->var;
        //(*result) = first->var;
        Node* curr_2;
        curr_2 = first->next;
        delete first;
        first = curr_2;
        return result;
        //return 1;
    }
};

int main()
{
    Queue_h numbers;
   /* numbers.Push(4);
    numbers.Push(7);
    numbers.Push(9);
    numbers.Push(1);*/
    try {
      for(int i=0; i < 5; i++) {
        //double result = 0;
        //cout << numbers.Pop(&result) << " " << result << endl;
        cout << numbers.Pop() << endl;
      }
    } catch(int ex) {
      cout << "Error code is " << ex << endl;
    } catch(const char* ex) {
      cout << ex << endl;
    } catch(QueueEmptyException ex) {
      cout << "Queue is empty!!!" << endl;
    } catch(exception ex) {
      cout << ex.what() << endl;
    } catch(...) {
      cout << "Queue is empty?" << endl;
    }

    return 0;
}
