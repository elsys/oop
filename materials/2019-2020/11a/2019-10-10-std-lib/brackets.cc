#include <string>
#include <queue>
#include <iostream>

using namespace std;

class BracketCounter {
  void reset() {
    openCount = 0;
    closeCount = 0;
    isBalanced = 1;
  }
  
public:
  int openCount;
  int closeCount;
  int isBalanced;
  
  BracketCounter() {
    reset();
  }
  
  string read() {
    string str;
    cin >> str;
    
    return str;
  }
  
  void check(string str) {
    reset();
  
    queue<char> brackets;
    for(int i=0; i< str.length(); i++) {
      char c = str[i];
      if(c == '(' || c == ')') {
        brackets.push(c);
      }
    }
    
    while(!brackets.empty()) {
      char b = brackets.front();
      switch(b) {
        case '(': openCount++; break;
        case ')': closeCount++; break;
      }
      brackets.pop();
      // Closing bracket before opening
      if(closeCount > openCount) {
        isBalanced = 0;
      }
    }
    
    isBalanced = isBalanced && openCount == closeCount;
  }
};

int main() {
  BracketCounter bc;
  string str = bc.read();
  bc.check(str);
  
  cout << bc.openCount << " " << bc.closeCount << " " << bc.isBalanced << endl;
  
  str = bc.read();
  bc.check(str);
  
  cout << bc.openCount << " " << bc.closeCount << " " << bc.isBalanced << endl;
  return 0;
}
