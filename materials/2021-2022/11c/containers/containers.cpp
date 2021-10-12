#include <iostream>
#include <string>
#include <array>
#include <list>

using std::cout;

using std::string;
using std::array;
using std::list;

bool comparator (const int first, const int second)
{
	// if equal first element goes first, then second
	if (first == second)
	{
		return 0;
	}
	return ( first < second );
}

bool isOdd(const int value)
{
	return (value % 2)==1;
}




void StringContainerDemo()
{
	string str ("There are two needles in this haystack with needles.");
	string str2 ("needle");
	string str3 ("six");
	string str4 ("haystack");
	
	for (auto it = str.cbegin(); it != str.cend(); ++it)
	{
		cout << *it << " ";
	}
	cout << "\n";
	

	cout << "length() of " << str2 << " is " << str2.length() << "\n";
	cout << "substr(14,str2.length()) method: " << str.substr (14, str2.length()) << "\n";


	size_t found = str.find(str2);
	if (found != string::npos)
	{
		cout << "first '" << str2 << "' found at: " << found << "\n";
	}
	
	
	found = str.find("two");
	str.replace(found, 3, str3);
	cout << str << "\n";
	
	
	found = str.find(str4);
	str.erase (found + str4.length(), str.length() - found);
	cout << "'" << str << "'\n";
}


void ArrayContainerDemo()
{
	array<int,6> first  = { 2, 4, 6, 8, 10, 12 };
	array<int,6> second = { 1, 3, 5, 7, 9, 11  };

	first.swap (second);

	cout << "array is " << (first.empty() ? "empty" : "not empty") << "\n";
	cout << "first is: " << first.front() <<  "\n";
	cout << "last is: " << first.back() <<  "\n";
	
	cout << "size is: " << first.size() << "\n";
	cout << "max size is: " << first.max_size() << "\n";
	
	cout << "array values are: ";

	for ( auto it = first.cbegin(); it != first.cend(); ++it )
	{
		cout << *it << ", ";
	}

	cout << "\nset all values of the array to 5\n";
	first.fill(5);
	
	for ( auto it = first.cbegin(); it != first.cend(); ++it )
	{
		cout << *it << ", ";
	}
	
	cout << "\n";
}


void ListContainerDemo()
{
	std::list<int> list = { 1, 3, 5, 7, 9 };

	cout << "list is " << (list.empty() ? "empty" : "not empty") << "\n";
	cout << "first is: " << list.front() <<  "\n";
	cout << "last is: " << list.back() <<  "\n";
	
	cout << "size is: " << list.size() << "\n";
	cout << "max size is: " << list.max_size() << "\n";
	
	cout << "list values are: ";

	for (auto it = list.cbegin(); it != list.cend(); ++it)
	{
		cout << *it << ", ";
	}
	
	cout << "\nreverse\n";
	list.reverse();
	for (auto it = list.cbegin(); it != list.cend(); ++it)
	{
		cout << *it << ", ";
	}
	
	cout << "\nmerge\n";
	std::list<int> even = { 2, 4, 6, 8, 10, 1, 3 };
	list.merge(even,comparator);
	for (auto it = list.cbegin(); it != list.cend(); ++it)
	{
		cout << *it << ", ";
	}
	
	cout << "\nsort\n";
	list.sort();
	for (auto it = list.cbegin(); it != list.cend(); ++it)
	{
		cout << *it << ", ";
	}
	
	cout << "\nunique\n";
	list.unique();
	for (auto it = list.cbegin(); it != list.cend(); ++it)
	{
		cout << *it << ", ";
	}
	
	cout << "\nremove_if\n";
	list.remove_if (isOdd);
	for (auto it = list.cbegin(); it != list.cend(); ++it)
	{
		cout << *it << ", ";
	}
	
	cout << '\n';
}


int main ()
{

	ListContainerDemo();
	
	return 0;
}