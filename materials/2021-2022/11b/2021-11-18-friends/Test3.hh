#pragma once

// Forward declaration to avoid circular includes
class Test1;

// Only the baz method will have private access to Test1
class Test3 {
public:
    void baz(const Test1 &arg);
};
