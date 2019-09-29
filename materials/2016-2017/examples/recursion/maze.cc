/*
 * maze.cc
 *
 *  Created on: Feb 22, 2017
 *      Author: lubo
 */
#include <vector>
#include <iostream>

enum Direction {
    NONE = 0, UP = 1 << 0, LEFT = 1 << 1, DOWN = 1 << 2, RIGHT = 1
            << 3
};

class Cell {
    unsigned int walls_;
    unsigned int row_;
    unsigned int col_;

public:
    Cell(unsigned int row, unsigned int col,
            unsigned walls = UP | LEFT | DOWN | RIGHT)
            : walls_(walls), row_(row), col_(col) {
    }

    bool has_wall(Direction dir) const {
        return dir & walls_;
    }

    Cell& set_wall(Direction dir) {
        walls_ |= dir;
        return *this;
    }

    Cell& unset_wall(Direction dir) {
        walls_ &= ~dir;
        return *this;
    }

    unsigned row() const {
        return row_;
    }
    unsigned col() const {
        return col_;
    }

};

class BoardError {
};

class Board {
    unsigned width_;
    unsigned height_;
    std::vector<Cell> cells_;

    unsigned index(unsigned row, unsigned col) const {
        if (row >= height() || col >= width()) {
            throw BoardError();
        }
        return row * col;
    }

    unsigned nindex(unsigned row, unsigned col, Direction dir) const {
        int nrow =
                dir == UP ? row + 1 : (dir == DOWN ? row - 1 : row);
        int ncol =
                dir == LEFT ?
                        col - 1 : (dir == RIGHT ? col + 1 : col);
        if (nrow < 0 || nrow >= height() || ncol < 0
                || ncol >= width()) {
            throw BoardError();
        }
        return index((unsigned) nrow, (unsigned) ncol);
    }
public:

    Board(unsigned w, unsigned h)
            : width_(w), height_(h) {
        for (unsigned row = 0; row < height(); ++row) {
            for (unsigned col = 0; col < width(); ++col) {
                cells_.push_back(Cell(row, col));
            }
        }
    }

    unsigned width() const {
        return width_;
    }
    unsigned height() const {
        return height_;
    }

    Cell& at(unsigned row, unsigned col) {
        return cells_[index(row, col)];
    }

    const Cell& at(unsigned row, unsigned col) const {
        return cells_[index(row, col)];
    }

    Cell& neighbour(unsigned row, unsigned col, Direction dir) {
        return cells_[nindex(row, col, dir)];
    }

    const Cell& neighbour(unsigned row, unsigned col,
            Direction dir) const {
        return cells_[nindex(row, col, dir)];
    }

    Cell& neighbour(const Cell& cell, Direction dir) {
        return cells_[nindex(cell.row(), cell.col(), dir)];
    }

    const Cell& neighbour(const Cell& cell, Direction dir) const {
        return cells_[nindex(cell.row(), cell.col(), dir)];
    }

    static Direction oposite_direction(Direction dir) {
        switch (dir) {
        case UP:
            return DOWN;
        case DOWN:
            return UP;
        case LEFT:
            return RIGHT;
        case RIGHT:
            return LEFT;
        default:
            throw BoardError();
        }
    }

    Cell& drill(Cell& cell, Direction dir) {
        cell.unset_wall(dir);
        Cell& ncell = neighbour(cell, dir);
        Direction oposite = oposite_direction(dir);
        ncell.unset_wall(oposite);
        return ncell;
    }

	bool has_neighbour(const Cell& cell, Direction dir) const {
		if(dir == DOWN && cell.row() == 0) {
			return false;
		}
		if(dir == UP && cell.row() == height() - 1) {
			return false;
		}
		if(dir == LEFT && cell.col() == 0) {
			return false;
		}
		if(dir == RIGHT && cell.col() == width() -1 ) {
			return false;
		}
		return true;
	}
};

int main() {
    Board b(10, 10);

    return 0;
}
