#include <iostream>
#include <string>
using namespace std;
int const STACK_SIZE = 10;

class StackException {
	string message;
	
	public:
		StackException(string message) {
			this -> message = message;
		}
		
		string what() {
			return message;
		}
};

class Stack {
	int data[STACK_SIZE];
	int top;
	
	public:
		Stack() {
			top = 0;
		}
		
		void push(int value) {
			if(!isFull()) {
				data[top++] = value;
			} else {
				throw StackException("Stack is full!");
			}
		}
		
		int pop() {
			if(isEmpty()) {
				throw StackException("Stack is empty!");
			}
			return data[--top];
		}
		
		bool isFull() {
			return top == STACK_SIZE;
		}
		
		bool isEmpty() {
			return top == 0;
		}
};

int main() {
	Stack s;
	try {
		s.pop();
		for (int i =0; i<12; i++) {
			s.push(i);
		}
	} catch (StackException ex) {
		cout << ex.what() << endl;
	}
}





