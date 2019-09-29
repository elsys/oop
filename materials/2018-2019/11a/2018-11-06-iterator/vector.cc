

class Vector {

	int capacity_;
	int size_;
	int* buffer_;
	
	void resize();
	
public:
	Vector();
	Vector(int capacity);
	
	~Vector();
	
	void push_back(int val);
	void pop_back();
	int& front();
	int& back();
	const int& front() const;
	const int& back() const;
	
	bool empty() const;
	int size() const;
	int capacity() const;
	
	Vector(const Vector& other);
	Vector& operator=(const Vector& other);

	int& operator[](int index);
	const int& operator[](int index) const;
	
};

int main() {


	return 0;
}

