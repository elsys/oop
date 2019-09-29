

#include <iostream>
#include <string>
#include <vector>
#include <sstream>

using namespace std;


int avg(vector<int>& v) {
    int result = 0;
    for (int i = 0; i < v.size(); i++) {
         result += v[i];
    }
    return result / v.size();
}

int main() {
    string input;
    vector<int> numbers;
    
    while (true) {
        cin >> input;
        if (input == "=") {
            break;
        }
        istringstream in_str(input);
        int value;
        in_str >> value;
        if (!in_str) {
            continue;
        }
        numbers.push_back(value);
    }
    cout << avg(numbers) << endl;

    return 0;
}
