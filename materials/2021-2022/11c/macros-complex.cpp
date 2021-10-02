#include <iostream>

#define MYLOG_ERR  1
#define MYLOG_INFO 1

#define P(a,b) a##b

#define MYLOG(x,y) do { if (P(MYLOG_,x)) { std::cerr << y << std::endl; } } while (0)


int main(int argc, char *argv[])
{
    MYLOG(ERR, "err");
    MYLOG(INFO, "info");
	return 0;
}
