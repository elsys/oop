#include <iostream>
using namespace std;

class Stack {
	static const int chunk = 2;
	int size;
	int* data;
	int top;
	
	public:
		Stack() {
			size = chunk;
			data = new int[size];
			top = -1;
		}
		
		~Stack() {
			delete data;
		}
		
		void push(int v) {
			if(top >= size -1) {
				resize();
			}
			
			data[++top] = v;
		}
		
		int pop() {
			if(top < 0) {
				throw exception();
			}
			
			return data[top--];
		}
		
		private:
			void resize() {
				cout << "Resize stack is called" << endl;
				int* temp = data;
				data = new int[size + chunk];
				for(int i = 0; i < size; i++) {
					data[i] = temp[i];
				}
				size += chunk;
				delete temp;
				cout << "New size: " << size << endl;
 			}
};

void function() {
	Stack st;
	st.push(2);
}

int main() {
	Stack st;
	st.push(3);
	st.push(2);
	st.push(1);
	st.push(0);
	
	try {
		cout << st.pop() << endl;
		cout << st.pop() << endl;
		cout << st.pop() << endl;
	} catch (const exception& e) {
		cout << "Error while poping!" << endl;
	}
	
	Stack* pst = new Stack();
	delete pst;
}
