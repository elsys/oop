#include <iostream>

using std::cout;
using std::endl;
using std::ostream;

class Number
{
	private:
		int value;
	public:
		Number(int v) : value(v)
		{}
		
		static Number zero()
		{
			return Number(0);
		}
		
		Number operator+(Number &other)
		{
			return Number(this->value + other.value);
		}
		
		//The postfix version of the increment operator takes a dummy int parameter in order to disambiguate:
		void operator++(int)
		{
			this->value++;
		}
		
		Number operator-(Number &other)
		{
			return Number(this->value - other.value);
		}
		
		friend ostream& operator<<(ostream& out, const Number& n)
		{
			out << "Number value is " << n.value << ".\n";
			return out;
		}
		
		int getValue()
		{
			return this->value;
		}
};

class ComplexNumber
{
	private:
		double real, imaginary;
	public:
		ComplexNumber(double r, double i) : real(r), imaginary(i)
		{}
		
		static ComplexNumber zero()
		{
			return ComplexNumber(0,0);
		}
		
		void operator+=(ComplexNumber &other)
		{
			this->real      += other.real;
			this->imaginary += other.imaginary;
		}
		
		friend ostream& operator<<(ostream& out, const ComplexNumber& cn)
		{
			out << "(" << cn.real << ", " << cn.imaginary << ")";
			return out;
		}
};

int main() {
	
	// https://en.cppreference.com/w/cpp/language/operators
	// https://www.cplusplus.com/reference/ostream/ostream/operator%3C%3C/
	// https://en.cppreference.com/w/cpp/language/friend
	// Increment/decrement operators
	
	Number n1(10);
	Number n2(20);
	
	Number result = n1 + n2;
	
	cout << "result = " << result << endl;
	cout << "result = " << result.getValue() << endl;
	
	result++;
	cout << "result = " << result << endl;
	
	ComplexNumber c1 (1.1, 2.2);
	ComplexNumber c2 (3.3, 4.4);
	c1+=c2;
	cout << c1 << endl;

	return 0;
}
