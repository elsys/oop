#include <iostream>
 
int main(int argc, char *argv[])
{
    std::cout << std::fixed;
    std::cout.precision(8);
    
    float sum_f = 0.0;
    for (int i = 0; i < 10; ++i)
    {
        sum_f+= 0.1;
    }
    std::cout << "result: " << sum_f << std::endl;
}
