#include <iostream>
#include <vector>
#include <string>
#include <cstdlib>
using namespace std;

enum Direction {
	NONE = 0,
	UP = 1,           // 0001
	RIGHT = 1 << 1,   // 0010
	DOWN = 1 << 2,    // 0100
	LEFT = 1 << 3     // 1000
};

class Cell {
	static const int PS_SIZE = 25;
	
	unsigned int row_;
	unsigned int col_;
	unsigned int walls_;
	
	bool visited_;
	
	string draw_wall(bool has_wall) const {
		return has_wall? "rlineto": "rmoveto";
	}
public:
	Cell(unsigned int row, unsigned int col)
	: row_(row),
	  col_(col),
	  walls_(UP | RIGHT | DOWN | LEFT), // 1111
	  visited_(false)
	{}
	
	bool is_visited() const {
		return visited_;
	}
	
	Cell& visit() {
		visited_=true;
		return *this;
	}
	
	unsigned int get_row() const {
		return row_;
	}
	
	unsigned int get_col() const {
		return col_;
	}
	
	Cell& set_row(unsigned int row) {
		row_=row;
		return *this;
	}
	
	Cell& set_col(unsigned int col) {
		col_=col;
		return *this;
	}
	
	//  1100 1100
	//  0001 1000
	//  0000 1000
	
	bool has_wall(Direction dir) const {
		return walls_ & dir;
	}
	
	// 1100 1100 
	// 0001 1000
	// 1101 1100
	
	void set_wall(Direction dir) {
		// walls_ = walls_ | dir;
		walls_ |= dir;   
	}
	
	//  1100 1100
	//  1000 0001
	//~ 0111 1110
	//  0100 1100
	
	void unset_wall(Direction dir) {
		// walls_ = walls_ & ~dir;
		walls_ &= ~dir;
	}	
	
	void draw() const {
		cout << col_*PS_SIZE << ' ' << row_*PS_SIZE
		     << " moveto" << endl;
		cout << PS_SIZE << " " << 0 << " " 
			<< draw_wall(has_wall(DOWN)) << endl;
		cout << 0 << " " << PS_SIZE << " " 
			<< draw_wall(has_wall(RIGHT)) << endl;
		cout << -PS_SIZE << " " << 0 << " "
			 << draw_wall(has_wall(UP)) << endl;
		cout << 0 << " " << -PS_SIZE << " " 
			 << draw_wall(has_wall(LEFT)) << endl;
	}
};

class BoardError {};

class Board {

	unsigned int width_;
	unsigned int height_;
	vector<Cell> board_;

public:
	Board(unsigned int width, unsigned int height)
	: width_(width),
	  height_(height)
	{
		for(unsigned int row=0; row<height_; row++) {
			for(unsigned int col=0; col<width_; col++) {
				board_.push_back(Cell(row, col));
			}
		}
	}
	
	Cell& at(unsigned int row, unsigned int col) {
		return board_[row*width_+col];
	}
	
	const Cell& at(unsigned int row, unsigned int col) const {
		return board_[row*width_+col];
	}
	
	void draw() const {
		cout << "newpath" << endl;
		for(unsigned int row=0;row<height_; ++row) {
			for(unsigned int col=0; col<width_; ++ col) {
				at(row, col).draw();
			}
		}
		cout << "stroke" << endl;
		cout << "showpage" << endl;
	}
	
	bool has_neighbour(unsigned int row, unsigned int col, 
						Direction dir) const {
		if(row==0 && dir==DOWN) {
			return false;
		}
		if(row==(height_-1) && dir==UP) {
			return false;
		}
		if(col==0 && dir==LEFT) {
			return false;
		}
		if(col==(width_-1) && dir==RIGHT) {
			return false;
		}
		return true;
	}
	
	Cell& get_neighbour(unsigned int row, unsigned int col,
						Direction dir) {
		if(!has_neighbour(row, col, dir)) {
			cerr << "heighbour not found: (" << row << "," << col
				<< ")" << endl;
			throw BoardError();
		}
		unsigned int nr=(dir==UP)?row+1:((dir==DOWN)?row-1:row);
		unsigned int nc=(dir==LEFT)?col-1:((dir==RIGHT)?col+1:col);
		return at(nr, nc);
	}
	
	Cell& drill(Cell& cell, Direction dir) {
		Cell& n=get_neighbour(cell.get_row(), cell.get_col(), dir);
		
		cell.unset_wall(dir);
		switch(dir) {
		case UP:
			n.unset_wall(DOWN);
			break;
		case DOWN:
			n.unset_wall(UP);
			break;
		case LEFT:
			n.unset_wall(RIGHT);
			break;
		case RIGHT:
			n.unset_wall(LEFT);
			break;
		default:
			cerr << "ala bala" << endl;
			throw BoardError();
		}
		return n;
	}
		
private:
	const static Direction DIRECTIONS[];
	const static unsigned int NDIR = 4;
public:	

	bool has_unvisited_neighbour(unsigned row, unsigned col) {
		for(unsigned int d=0; d < NDIR; d++) {
			Direction dir = DIRECTIONS[d];
			if(has_neighbour(row, col, dir)) {
				Cell& c=get_neighbour(row, col, dir);
				if(!c.is_visited()) {
					return true;
				}
			}
		}
		return false;
	}

	Direction get_random_unvisited_neighbour(unsigned row,
											 unsigned col) {
		if(!has_unvisited_neighbour(row, col)) {
			throw BoardError();
		}
		while(true) {
			unsigned d=rand()%NDIR;
			Direction dir = DIRECTIONS[d];
			if(has_neighbour(row, col, dir)) {
				Cell& c=get_neighbour(row, col,dir);
				if(!c.is_visited()) {
					return dir;
				}
			}
		}
	}

	void generate_maze(unsigned row, unsigned col) {
		Cell& c = at(row, col);
		c.visit();
		while(true) {
			if(!has_unvisited_neighbour(row, col)) {
				return;
			}
			Direction dir=get_random_unvisited_neighbour(row, col);
			Cell& n=drill(c, dir);
			generate_maze(n.get_row(),
						  n.get_col());
		}
	}
};

const Direction Board::DIRECTIONS[]={DOWN, UP, LEFT, RIGHT};
//const Direction DIRECTIONS[]

int main() {
/*
	Cell c1(0,1);
	
	cout << c1.has_wall(UP) << endl;
	c1.unset_wall(UP);
	cout << c1.has_wall(UP) << endl;
	c1.set_wall(UP);
	cout << c1.has_wall(UP) << endl;
*/
	Board b(20,20);

	b.generate_maze(0, 10);
		
	b.draw();
	/*
	cout << b.has_neighbour(0,1,DOWN)
	     << b.has_neighbour(0,1,UP)
	     << b.has_neighbour(0,1,LEFT)
	     << b.has_neighbour(0,1,RIGHT) << endl;
	cout << b.has_neighbour(0,0,DOWN)
		 << b.has_neighbour(0,0,LEFT) 
		 << b.has_neighbour(0,0,RIGHT)
		 << b.has_neighbour(0,0,UP) << endl;
	*/		 
	return 0;
}



