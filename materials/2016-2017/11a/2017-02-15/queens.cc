#include <vector>
#include <cstdlib>
#include <iostream>

class QueensBoard {
	int size_;
	std::vector<int> board_;

public:

	QueensBoard(int size)
	: size_(size), board_(size, -1)
	{}
	
	int size() const {
		return size_;
	}

	bool under_attack(int row, int col) const {
		for(int c=0; c <size();++c) {
			if(board_[c] == -1) {
				continue;
			}
			if(board_[c] == row) {
				return true;
			}
			if(std::abs(c - col) == std::abs(row - board_[c])) {
				return true;
			}
		}
		return false;
	}


	bool solve(int col) {
		if(col == size()) {
			return true;
		}
		for(int row=0; row < size(); ++row) {
			if(!under_attack(row, col)) {
				board_[col] = row;
				if(solve(col+1)) {
					return true;
				}
			}
		}
		board_[col] = -1;
		return false;
	}
	
	void print() const {
		for(int row = 0; row<size(); ++row) {
			for(int col=0; col < size(); ++col) {
				std::cout << "|";
				if(board_[col] == row) {
					std::cout << "*";
				} else {
					std::cout << " ";
				}
			}
			std::cout << "|" << std::endl;
		}
	}
};


int main() {
	QueensBoard qb(8);
	bool result = qb.solve(0);
	std::cout << result << std::endl;
	qb.print();
	
	return 0;
}

