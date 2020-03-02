#include "stack.h"
#include <stdexcept>

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
	delete [] data;
	data = new T[other.size];
	top = other.top;
	for(int i = 0; i < other.top; i++) {
		data[i] = other.data[i];
	}
	size = other.size;
	
	return *this;
}

template<class T>
void Stack<T>::push(const T& value) {
	if (top >= (size - 1)) {
		resize();
	}
	
	data[++top] = value;
}

template<class T>
T Stack<T>::pop() {
	if(top < 0) {
		throw std::out_of_range("Stack<>::top(): empty stack");
	}
	
	return data[top--];
}

template<class T>
void Stack<T>::resize() {
	T* temp = data;
	data = new T[size + chunk];
	for(int i = 0; i < size; i++) {
		data[i] = temp[i];
	}
	
	size += chunk;
	delete [] temp;
}

