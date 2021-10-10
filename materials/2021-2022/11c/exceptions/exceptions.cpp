#include <iostream>
#include <string>
#include <exception>
#include <stdexcept>
#include "color.h"
#include "myexeption.h"

using std::cout;
using std::cerr;

using std::endl;
using std::string;

int AddPositiveIntegers(int a, int b)
{
    if (a < 0 || b < 0)
	{
        throw std::invalid_argument("AddPositiveIntegers arguments must be positive");
	}
    return (a + b);
}

int main()
{
	Color::Modifier red(Color::FG_RED);
	Color::Modifier green(Color::FG_GREEN);
    Color::Modifier def(Color::FG_DEFAULT);
	
    cout << green << "Example with user defined exception" << def << endl;
	
	// -------------------------------------------------------------------------

	try
	{
		throw MyException();
	}
	catch(MyException& mex)
	{
		cout << "MyException caught: " << mex.what() << endl;
	}
	catch(std::exception& ex)
	{
		cout << "default exception caught" << endl;
	}
	
	// -------------------------------------------------------------------------
	
	cout << green << "\n\nexample with try-catch, contains throw\n" << def << endl;

	try
	{
		throw 'a';
	}
	catch (int param)
	{
		cout << "int exception: "<< param << endl;
	}
	catch (char param)
	{
		cout << "char exception: " << param << endl;
	}
	
	// -------------------------------------------------------------------------
	
	cout << green << "\n\nexample with exception thrown from function\n" << def << endl;
	
    try
	{
        cout << AddPositiveIntegers(-1, 2);
    }
    catch (std::invalid_argument& e)
	{
        cerr << e.what() << endl;
    }
	
	return 0;
}