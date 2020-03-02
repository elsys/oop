#ifndef _STACK_H_
#define _STACK_H_

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
		T pop();
		void push(const T& value);
	private:
		void resize();

};

#endif
