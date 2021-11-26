#include <iostream>

using std::cout;
using std::endl;

class Stack
{
	private:
		int* arr;
		int top;
		int capacity;
	
	public:
		Stack()
		{
			capacity = 4;
			arr = new int[capacity];
			top = -1;
		}
		
		Stack(Stack& st)
		{
			
		}
		
		~Stack()
		{
			delete[] arr;
		}
		
		int* peek()
		{
			if(!isEmpty())
			{
				return &arr[top];
			}
			return nullptr;
		}
		
		int* pop()
		{
			if(!isEmpty())
			{
				return &arr[top--];
			}
			return nullptr;
		}
		
		bool push(int n)
		{
			if(!isFull())
			{
				arr[++top] = n;
				return true;
			}
			return false;
		}
	
		bool isEmpty() { return top == -1; }
		bool isFull()  { return top == capacity - 1; }
		int size()     { return top + 1; }
		
		/*
		friend istream& operator>>(istream& in, Stack& s)
		{
			
		}
		*/
};

int main()
{
	bool check = false;
	
	Stack st (2);
	
	check = st.push(1);
	cout << "result is " << check << endl;
	
	check = st.push(2);
	cout << "result is " << check << endl;
	
	check = st.push(3);
	cout << "result is " << check << endl;
	
	cout << "just check what last element is " << *(st.peek()) << endl;
	cout << "size is " << st.size() << endl;
	
	cout << "Now remove element!" << endl;
	
	cout << "just check what last element is " << *(st.pop()) << endl;
	cout << "just check what last element is " << *(st.pop()) << endl;
	
	int* intCheck = st.pop();
	if (intCheck == nullptr)
	{
		cout << "No more elements" << endl;
	}
	else
	{
		cout << "just check what last element is " << *intCheck << endl;
	}
	
	return 0;
}