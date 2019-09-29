

class Vector {
	int capacity_;
	int size_;
	int* buffer_;
	
	void resize();
	
public:
	
	Vector();
	Vector(int capacity);
	
	bool empty() const;
	int size() const;
	int capacity() const;
	
	int& front();
	const int& front() const;
	int& back();
	const int& back() const;
	
	void push_back(int val);
	void pop_back();
	
	Vector(const Vector& other);
	Vector& operator=(const Vector& other);
	
	int& operator[](int index);
	const int& operator[](int index) const;
	
	int& at(int index);
	const int& at(int index) const;

};


int main() {

	return 0;
}

