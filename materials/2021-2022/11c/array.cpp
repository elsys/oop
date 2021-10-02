#include <iostream>
#include<cmath>

using std::cout;
using std::endl;

#define SIZE 6

int main(int argc, char *argv[])
{
	int array [SIZE] = { };
	int index, result = 0;
	
	for ( index = 0 ; index < SIZE ; index++ )
	{
		array[index] = pow(2, (index+1) );
	}
	
	// regular for
	for ( index = 0 ; index < SIZE ; index++ )
	{
		cout << "array[" << index << "] = " << array[index] << endl;
		result += array[index];
	}
	
	// this is known as "foreach" cycle
	// you can not change the value of the element
	for (int element : array)
	{
		cout << element << endl;
	}
	
	
	cout << "reult is " << result << endl;
	
    return 0;
}
