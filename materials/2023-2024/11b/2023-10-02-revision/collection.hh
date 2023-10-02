#ifndef COLLECTION_HH
#define COLLECTION_HH

class Collection {
// protected:

public:
    virtual void push(int value) = 0;
    virtual int pop() = 0;
    virtual int size() = 0;
    virtual void clear() = 0;
// private:

};

#endif
