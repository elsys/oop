#pragma once

// Forward declaration to avoid circular includes
class Test1;

// All methods in Test2 will have private access to Test1
class Test2 {
public:
    void bar(const Test1 &arg);
};
