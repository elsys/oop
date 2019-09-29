#include <iostream>
using namespace std;

int gcd(int first, int second);

class Rational {
    int numerator_;
    int denominator_;
    
    public:
    
    Rational(int numerator, int denominator)
        : numerator_(numerator), denominator_(denominator) {
            simplify();    
        }
    
    void simplify() {
        int divisor = gcd(numerator_, denominator_);
        numerator_ /= divisor;
        denominator_ /= divisor;
        
    }
    
    void print() const {
        cout << numerator_ << '/' << denominator_ << endl;
    }
    
};

int gcd(int first, int second) {  
    int divisor = 1;
    int lower = first < second ? first : second;
        
    for (int counter = 1; counter <= lower; counter++) {
        if (first % counter == 0
                && second % counter == 0)   {
            divisor = counter;
        }
    }
    
    return divisor;    
}

int main() {
    Rational r1(1,2);
    Rational r2(2,4);
    Rational r3(4,2);
    r1.print();
    r2.print();
    r3.print();
    return 0;
}
