#include <iostream>
#include <string>

int main(int argc, char *argv[])
{
    std::string age;
    std::string name;
    
    std::cout << "Enter your name: ";
    std::cin >> name;
    
    std::cout << "Enter your age: ";
    std::cin >> age;
	
	try {
		int realAge = std::stoi(age);
		std::cout << "Hello, " << name << ". Your age is " << age << "\n";
	} catch (const std::invalid_argument) {
		std::cout << "Could not parse the 'age' from input." << std::endl;
		std::cout << "The input was: '" << age << "'" << std::endl;
	}
	
    return 0;
}
