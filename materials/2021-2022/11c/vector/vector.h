class Vector
{
	private:
		int size;
		int capacity;
		int *data;
		void resize(int new_size);
		
		class iterator
		{
			private:
				int index;
				const Vector *vector;
			public:
				iterator(const Vector *vector);
				iterator(const Vector *vector, int index);
				
				iterator &operator++();
				iterator &operator++(int);
				iterator &operator--(int);
								
				int operator*();
				bool operator>=(iterator other);
				bool operator<=(iterator other);
				
				bool operator>(iterator other);
				bool operator<(iterator other);
		};

	public:		
		Vector();
		Vector(const Vector &other);
		
		Vector &operator=(const Vector &other);
		~Vector();
	
		int get_size() const;
		int get_capacity() const;
		bool is_empty() const;
		
		void reserve(int reserve_capacity);
		void shrink_to_fit();
		
		int at(int index) const;
		int operator[](int index) const;
		
		void push_back(int value);
		void pop_back();
		int front() const;
		int back() const;
		
		iterator begin() const;
		iterator end() const;
};
