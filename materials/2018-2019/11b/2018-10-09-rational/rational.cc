#include <iostream>
using namespace std;


class RationalException {};

class Rational {
	long num_, den_;
	
	long gcd(long a, long b) {
		long r = a % b;
		while(r!=0) {
			a = b;
			b = r;
			r = a % b;
		}
		return b;
	}
	
	void reduce() {
		if(num_ == 0) {
			den_ = 1;
		} else {
			long tempnum = (num_ < 0)? -num_: num_;
			long r = gcd(tempnum, den_);
			
			num_ /= r;
			den_ /= r;
		}
	}
	
	void standardize() {
		if(den_ < 0) {
			num_ = - num_;
			den_ = - den_;
		}
		reduce();
	}
	
public:
	Rational(long num, long den) {
		if(den == 0) {
			throw RationalException();
		}
		
		num_ = num;
		den_ = den;
		
		standardize();
	}
	
	void dump() {
		cout << "(" << num_ << "/" << den_ << ")" << endl;
	}
	
	void add(Rational other);
	void sub(Rational other);
	
};

Rational add(Rational r1, Rational r2);
Rational sub(Rational r1, Rational r2);


int main() {
	Rational r1(1,2), r2(2,4), r3(3, -6);
	
	r1.dump();
	r2.dump();
	r3.dump();
	
	r1.add(r2);
	// r1 += r2;
	r1.dump();
	
	r1.sub(r2);
	// r1 -= r2;
	r1.dump();

	r3 = add(r1, r2);
	r3.dump();
	
	r3 = sub(r1, r2);
	r3.dump();
	
	return 0;
}

