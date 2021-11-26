#include <iostream>

using std::cout;
using std::endl;

class MyString
{
	private:
		char* data;
		int length;
	public:
		MyString(const char* data, int length)
		{
			if(length > 0)
			{
				this->data = new char[length];
				
				for(int idx = 0; idx < length; idx++)
				{
					this->data[idx] = data[idx];
				}
			}
		}
		
		MyString(const MyString& str)
		{
			length = str.getLength();
			data = new char[length];
			data = str.getData();
		}
		
		~MyString()
		{
			delete[] data;
		}
		
		int getLength() { return this->length; }
		char* getData() { return this->data; }
			
		MyString& operator=(const MyString& str)
		{
			if(this->data)
			{
				delete[] data;
			}
			
			this->length = str.length;
			
			data = new char[this->length];
			
			for(int idx = 0; idx < this->length; idx++)
			{
				this->data[idx] = str.data[idx];
			}
			
			*this;
		}
};

int main()
{
	MyString s ("qwerty");
	MyString s1;
	
	s1 = s;
	
	
	
	return 0;
}