#ifndef _STACK_H_
#define _STACK_H_

#include <stdexcept>

template<class T>
class Stack {
	static const unsigned int chunk = 2;
	int size;
	T* data;
	int top;
	public:
		Stack();
		Stack(const Stack& other);
		~Stack();
		Stack& operator=(const Stack& other);
		void push(const T& value);
		T pop();
	private:
		void resize();
};
/*
template<class T>
Stack<T>::Stack() {
	size = chunk;
	top = -1;
	data = new T[size];
}

template<class T>
Stack<T>::Stack(const Stack& other) {
	size = other.size;
	top = other.top;
	data = new T[size];
	for(int i = 0; i < top; i++) {
		data[i] = other.data[i];
	}
}

template<class T>
Stack<T>::~Stack() {
	delete [] data;
}

template<class T>
Stack<T>& Stack<T>::operator=(const Stack& other) {
	if(this != &other) {
		delete [] data;
		top = other.top;
		size = other.size;
		data = new T[size];
		for(int i = 0; i < top; i++) {
			data[i] = other.data[i];
		}
	}
	
	return *this;
}

template<class T>
void Stack<T>::push(const T& value) {
	if(top >= (size -1)) {
		resize();
	}
	
	data[++top] = value;
}

template<class T>
T Stack<T>::pop() {
	if(top < 0) {
		throw std::out_of_range("Stack<>::pop(): empty stack");
	}
	
	return data[top--];
}

template<class T>
void Stack<T>::resize() {
	T* oldData = data;
	data = new T[size + chunk];
	for(int i = 0; i < size; i++) {
		data[i] = oldData[i];
	}
	
	delete [] oldData;
	size += chunk;
}
*/
#endif
