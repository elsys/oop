#include <vector>
#include <cstdlib>
#include <iostream>


class QueenBoard {
	int size_;
	std::vector<int> board_;

public:

	QueenBoard(int n)
	: size_(n), board_(n, -1)
	{}
	
	int size() const {
		return size_;
	}

	bool under_attack(int row, int col) const {
		for(int i=0; i<size(); ++i) {
			if(board_[i] == -1) {
				continue;
			}
			if(board_[i] == row) {
				return true;
			}
			if( std::abs(i - col) == std::abs(row - board_[i]) ) {
				return true;
			}
		}
		return false;
	}
	
	
	bool solve(int col) {
		if(col == size()) {
			return true;
		}
		for(int row = 0; row < size(); ++row) {
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
		for(int row=0; row<size(); ++row) {
			for(int col=0; col<size(); ++col) {
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

	QueenBoard qb(8);
	qb.solve(0);
	qb.print();

	return 0;
}

