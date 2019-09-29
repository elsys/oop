#include <iostream>
using namespace std;

int max_common_divisor(int number1, int number2);

class rational {
    int numerator_, denominator_;
    
    public:
    
    rational(int numerator, int denominator) : numerator_(numerator),   denominator_(denominator) {
        reduce();
    }
    
    void print() {
        cout << numerator_ << "/" << denominator_ << endl;
    }
    
    void reduce() {
        int mcd = max_common_divisor(numerator_, denominator_);
        numerator_ /= mcd;
        denominator_ /= mcd;        
    }
     
};

int max_common_divisor(int number1, int number2) {
    int min = number1 < number2 ? number1 : number2;
    while (number1 % min != 0 || number2 % min != 0) {
        min--; 
    }
    return min;
}

int main() {
    rational num1(4,5), num2(6,7);
    num1.print();
    num2.print();
    
    rational num3(8,10);
    num3.print();
    return 0;
}
