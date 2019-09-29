#include <vector>
#include <iostream>

using namespace std;


enum Direction {
	NONE = 0,
	UP = 1,				// 00001
	LEFT = 1 << 1,		// 00010
	DOWN = 1 << 2,		// 00100
	RIGHT = 1 << 3		// 01000
};
						// 01011 = UP | LEFT | RIGHT

class Cell {
	friend class Board;
	
	unsigned row_;
	unsigned col_;
	unsigned walls_;
	
	const static int SIZE = 20;
	
	const char* draw_wall(bool has_wall) const {
		return has_wall? "rlineto":"rmoveto";
	}
	
	void draw(ostream& out) const {
		out << SIZE * col() << " " << SIZE * row() << " moveto" << endl;
		out << SIZE << " " << 0 << " " << draw_wall(has_wall(DOWN)) << endl;
		out << 0 << " " << SIZE << " " << draw_wall(has_wall(RIGHT)) << endl;
		out << -SIZE << " " << 0 << " " << draw_wall(has_wall(UP)) << endl;
		out << 0 << " " << -SIZE << " " << draw_wall(has_wall(LEFT)) << endl;
	}
public:
	Cell(unsigned r, unsigned c, unsigned walls=UP|LEFT|DOWN|RIGHT)
	: row_(r), col_(c), walls_(walls)
	{}
	
	unsigned row() const {
		return row_;
	}
	
	unsigned col() const {
		return col_;
	}
	
	/*
		walls_: 01100
		dir:    00100
		res:    00100
	*/
	bool has_wall(Direction dir) const {
		return walls_ & dir;
	}
	
	/*
		walls_: 01100
		dir:    00001
		res:    01101
	*/
	Cell& set_wall(Direction dir) {
		walls_ = walls_ | dir;
		return *this;
	}
	
	
	/*
		walls_: 01100
		dir:    01000
		~dir:   10111
		&:      00100
		res:    00100
	*/
	Cell& unset_wall(Direction dir) {
		walls_ &= ~dir;
		return *this;
	}
};

class BoardError {};

class Board {
	unsigned width_;
	unsigned height_;
	vector<Cell> cells_;
	
	unsigned index(unsigned row, unsigned col) const {
		if(row >= width_ || col >= height_) {
			throw BoardError();
		}
		return width_*row + col;
	}
	unsigned nindex(unsigned row, unsigned col, Direction dir) const {
		if(row >= height_ || col >= width_) {
			throw BoardError();
		}
		int nrow = dir==UP?row+1:(dir==DOWN?row-1:row);
		int ncol = dir==RIGHT?col+1:(dir==LEFT?col-1:col);
		
		if(nrow < 0 || nrow >= height_ || ncol < 0 || ncol >= width_) {
			throw BoardError();
		}
		return index(nrow, ncol);
	}
	
public:
	Board(unsigned w, unsigned h)
	: width_(w), height_(h)
	{
		for(unsigned row=0; row<height_; ++row) {
			for(unsigned col=0; col<width_; ++col) {
				cells_.push_back(Cell(row, col));
			}
		}
	}
	
	Cell& at(unsigned row, unsigned col) {
		return cells_[index(row, col)];
	}
	
	const Cell& at(unsigned row, unsigned col) const {
		return cells_[index(row,col)];
	}
	
	Cell& neighbour(const Cell& cell, Direction dir) {
		return cells_[nindex(cell.row(), cell.col(), dir)];
	}
	
	const Cell& neighbour(const Cell& cell, Direction dir) const {
		return cells_[nindex(cell.row(), cell.col(), dir)];
	}
	
	Cell& drill(Cell& cell, Direction dir) {
		Cell& ncell = neighbour(cell, dir);
		
		cell.unset_wall(dir);
		Direction opposite = opposite_direction(dir);
		ncell.unset_wall(opposite);
		
		return ncell;
	}
	
	static Direction opposite_direction(Direction dir) {
		switch(dir) {
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
	
	void draw(ostream& out) const {
		out << "newpath" << endl;
		for(int row=0; row < height_; ++row) {
			for(int col=0; col < width_; ++col) {
				at(row, col).draw(out);
			}
		}
		out << "1 setlinewidth" << endl;
		out << "stroke" << endl;
	}
};

int main() {
	Board b(4, 4);
	
	b.drill(b.at(2,2), UP);
	
	b.draw(cout);
	
	
	
	return 0;
}

