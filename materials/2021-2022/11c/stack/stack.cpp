#include<iostream>
#include <cstdint>
#include <cstring>

using std::cout;
using std::cin;
using std::endl;

#define SIZE 4

class Stack
{
private:
	char* data;
	int top;
	int size;
	void resize();
public:
	Stack();
	
	char pop();
	void push(char c);
	void display();
};

Stack::Stack()
{
	top = -1;
	size = SIZE;
	data = new char[SIZE];
	
	cout << "Stack initial size " << size << endl;
}

void Stack::resize()
{
    char* newArr = new char[size * 2];
    std::memcpy( newArr, data, size * sizeof(char) );
    delete [] data;
	
	size = size * 2;
    data = newArr;
	
	cout << "Resize made. Size is now " << size << endl;
}

void Stack::push(char c)
{
	cout << "entered: '" << c << "', now stak size is " << size << endl;
	
	if(top == size-1)
	{
		resize();
	}
	else
	{
		top++;
		data[top] = c;
	}
}

char Stack::pop()
{
	if(top != -1)
	{
		return data[top];
		top--;
	}
	return ' ';
}

void Stack::display()
{
	int t = top;
	while(t>=0)
	{
		cout << data[t] << endl;
		t--;
	}
}

int main(int argc, char *argv[])
{
	Stack st;
	char ch;
	while ((ch = std::cin.get()) != 27)
	{
		cout << "Enter char: ";
		cin >> ch;
		st.push(ch);
		cout << endl;
	}
	return 0;
}