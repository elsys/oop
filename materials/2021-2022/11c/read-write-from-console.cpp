#include <iostream>
 
int main(int argc, char *argv[])
{
    std::cout << argc << " arguments passed.\n";
    std::cout << "Name of program: '" << argv[0] << "'.\n";

    if( argc > 1 )
    {
        for(int index = 1; index < argc; index++)
        {
            std::cout << "argv[" << index << "] = " << argv[index] << '\n';
        }
    }
}
