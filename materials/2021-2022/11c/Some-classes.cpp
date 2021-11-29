#include <iostream>
#include <string>
#include <vector>

using std::cout;
using std::endl;

class Resource
{
	private:
		std::string name;
	public:
		Resource(std::string name);
		~Resource(void);
		std::string getName() const { return name; }
};

class Person
{
	private:
		std::string firstname;
		std::string lastname;
		int age;
	public:
		Person(std::string fname, std::string lname, int age);
		Person() = default;
		~Person();
		std::string getName() const;
};

class Tweeter : public Person
{
	private:
		std::string handle;
	public:
		Tweeter(std::string fname, std::string lname, int age, std::string handle);
		~Tweeter();
};

Person::Person(std::string fname, std::string lname, int age) :
	firstname(fname), lastname(lname), age(age)
{
	cout << "constructing " << getName();
}
	
Person::~Person()
{
	cout << "destructing " << getName();
}

std::string Person::getName()
{
	return firstname + " " + lastname;
}


Tweeter::Tweeter(
	std::string fname,
	std::string lname,
	int age,
	std::string handle) :
	Person(fname, lname, age), handle(handle)
{
	cout << "constructing " << getName() << " with handle " << handle << endl;
}

Resource::Resource(std::string n) : name(n)
{
	cout << "constructing '" << name << "'" <<endl;
}

Resource::~Resource()
{
	cout << "destructing '" << name << "'" << endl;
}


void changeNumber(int num)
{
	num++;
	cout << "value is " << num << endl;
}

void changeNumber2(int &num)
{
	num++;
	cout << "value is " << num << endl;
}

int main(int argc, char *argv[])
{

	auto n = 1'000'000;
	auto h = 0xFF;
	auto b = 0b111;
	
	cout << n << endl;
	cout << h << endl;
	cout << b << endl;
	
	int num = 5;
	
	changeNumber(num);
	cout << num << endl;
	
	changeNumber2(num);
	cout << num << endl;
	
	// pointers
	int i = 3;
	int j = 10;
	int* pi = &i;
	
	int const * pci = pi; // pointer to a const
	pci = &j;
	j = *pci;
	
	int * const cpi = pi; // const pointer
	*cpi = 4;
	
	int const * const c = pi; // const pointer to a const
	j = *c;
	

	// comparing classes pointers
	Resource local ("local");
	std::string localStrig = local.getName();
	
	Resource* pResource = new Resource("created with new");
	std::string newString = pResource->getName();
	pResource = nullptr;
	delete pResource;
	
	// ... some other operations
	// bad stuff will happen here
	//std::string string2 = pResource->getName(); // using deleted variable
	//delete pResource; // double deletion
	

    return 0;
}
