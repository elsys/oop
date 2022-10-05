#ifndef _HUMAN_HH_
#define _HUMAN_HH_

class human
{
    int var = 0;
public:
    virtual void sayHello() const = 0;
    int getVar() const;
};

#endif