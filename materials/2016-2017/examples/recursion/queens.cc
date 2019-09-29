/*
 * queens.cc
 *
 *  Created on: Feb 14, 2017
 *      Author: lubo
 */

#include <vector>
#include <cstdlib>
#include <iostream>

class QueensBoard {
    int size_;
    std::vector<int> board_;

public:
    QueensBoard(int size)
            : size_(size), board_(size_, -1) {
    }

    int size() const {
        return size_;
    }

    bool under_attack(int row, int col) const {
        for (int i = 0; i < col; ++i) {
            if (board_[i] == -1) {
                continue;
            }
            if (board_[i] == row) {
                return true;
            }
            if (std::abs(i - col) == std::abs(board_[i] - row)) {
                return true;
            }
        }
        return false;
    }

    bool solve(int col = 0) {
        if (col == size()) {
            return true;
        }
        std::cout << "exploring col " << col << std::endl;
        for (int row = 0; row < size(); ++row) {
            if (!under_attack(row, col)) {
                board_[col] = row;
                std::cout << "placing queen on row " << row
                        << std::endl;
                if (solve(col + 1)) {
                    return true;
                }
            }
        }
        board_[col] = -1;
        return false;
    }

    void pretty_print() const {
        std::cout << std::endl;
        for (int row = 0; row < size(); ++row) {
            for (int col = 0; col < size(); ++col) {
                std::cout << '|';
                if (board_[col] == row) {
                    std::cout << '*';
                } else {
                    std::cout << ' ';
                }
            }
            std::cout << '|' << std::endl;
        }
    }
};

int main() {

    QueensBoard qb(4);
    bool has_solution = qb.solve();
    std::cout << "has_solution=" << has_solution << std::endl;
    qb.pretty_print();

    return 0;
}

