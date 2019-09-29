#include <iostream>
#include <vector>
#include <cstdlib>
using namespace std;

enum Direction {
	NONE = 0,
	UP = 1 << 0,
	LEFT = 1 << 1,
	DOWN = 1 << 2,
	RIGHT = 1 << 3
};


class Cell {
	static const int WALL_SIZE = 20;

	unsigned int walls_;
	unsigned int row_;
	unsigned int col_;
	bool visited_;
	
	string draw_wall(bool has_wall) const {
		return has_wall?" rlineto":" rmoveto";
	}
public:
	Cell(unsigned int row, unsigned int col,
		unsigned int walls=UP|LEFT|DOWN|RIGHT)
	: walls_(walls),
	  row_(row),
	  col_(col),
	  visited_(false)
	{}
	
	Cell& visit() {
		visited_=true;
		return *this;
	}
	
	bool is_visited() const {
		return visited_;
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

	unsigned get_row() const {
		return row_;
	}
	
	unsigned get_col() const {
		return col_;
	}
	
	void draw(ostream& out) const {
		out << (get_col()+1)*WALL_SIZE << ' '
			<< (get_row()+1)*WALL_SIZE << ' '
			<< "moveto" << endl;
		
		
		out << WALL_SIZE << ' ' << 0 
			<< draw_wall(has_wall(DOWN)) << endl;
		out << 0 << ' ' << WALL_SIZE 
			<< draw_wall(has_wall(RIGHT)) << endl;
		out << -WALL_SIZE << ' ' << 0 
			<< draw_wall(has_wall(UP)) << endl;
		out << 0 << ' ' << -WALL_SIZE 
			<< draw_wall(has_wall(LEFT)) << endl;
	}
};

class BoardError{};

class Board {
	unsigned width_;
	unsigned height_;
	vector<Cell> cells_;
public:
	Board(unsigned width, unsigned height)
	: width_(width),
	  height_(height)
	{
		for(unsigned row=0;row<height_;row++) {
			for(unsigned col=0;col<width_;col++) {
				cells_.push_back(Cell(row,col));
			}
		}
	}
	const Cell& get_cell(unsigned row, unsigned col) const {
		return cells_[row*width_+col];
	}
	
	Cell& get_cell(unsigned row, unsigned col) {
		return cells_[row*width_+col];
	}	
	
	
	void draw(ostream& out) const {
		out << "newpath" << endl;
		for(vector<Cell>::const_iterator it=cells_.begin();
			it!=cells_.end(); ++it) {
			
			(*it).draw(out);
		}
		
		out << "stroke" << endl;
		out << "showpage" << endl;
	}
	
	bool has_neighbour(unsigned row, unsigned col,
			   Direction dir) const {
		if(row==0 && dir==DOWN)
			return false;
		if(row==height_-1 && dir==UP) 
			return false;
		if(col==0 && dir==LEFT)
			return false;
		if(col==width_-1 && dir==RIGHT) 
			return false;
			
		return true;
	}
	
	Cell& get_neighbour(unsigned row, unsigned col,
			    Direction dir) {
		if(! has_neighbour(row, col, dir)) {
			throw BoardError();
		}
		unsigned nr= (dir==UP)? row+1:( 
				(dir == DOWN)? row-1: row);
		unsigned nc= (dir==RIGHT) ? col+1: (
				(dir == LEFT)? col-1:col);
		return get_cell(nr, nc);
	}
	
	const Cell& get_neighbour(unsigned row, unsigned col,
							  Direction dir) const {
		if(! has_neighbour(row, col, dir)) {
			throw BoardError();
		}
		unsigned nr= (dir==UP)? row+1:( 
				(dir == DOWN)? row-1: row);
		unsigned nc= (dir==RIGHT) ? col+1: (
				(dir == LEFT)? col-1:col);
		return get_cell(nr, nc);							  
	}
	
	void drill_wall(unsigned row, unsigned col, 
					Direction dir) {
		Cell& c=get_cell(row, col);
		c.unset_wall(dir);
		
		if(! has_neighbour(row, col, dir) ) {
			return;
		}
		Cell& n=get_neighbour(row, col, dir);
		Direction ndir;
		
		switch(dir) {
		case UP:
			n.unset_wall(DOWN);
			break;
		case RIGHT:
			n.unset_wall(LEFT);
			break;
		case DOWN:
			n.unset_wall(UP);
			break;
		case LEFT:
			n.unset_wall(RIGHT);
			break;
		default:
			throw BoardError();
		}
	}
	
private:
	const static Direction DIRECTIONS[];
	const static int DSIZE = 4;
public:
	
	Direction has_unvisited_neighbour(int row, 
									  int col) const {
		
		for(int i=0;i<DSIZE;++i) {
			Direction d=DIRECTIONS[i];
			if(has_neighbour(row, col, d)) {
				const Cell& c=get_neighbour(row, col, d);
				if(!c.is_visited()) {
					return d;
				}
			}
		}
		return NONE;
	}
	
	Direction get_random_unvisited_neighbour(int row,
											 int col) const {
		if(!has_unvisited_neighbour(row, col)) {
			return NONE;
		}
		while(true) {
			int ind=rand()%DSIZE;
			Direction d=DIRECTIONS[ind];
			if(has_neighbour(row,col,d)) {
				const Cell& c=get_neighbour(row, col, d);
				if(!c.is_visited()) {
					return d;
				}
			}
		}						 
	}
	
	
	void generate(int row, int col) {
		Cell& c=get_cell(row, col);
		c.visit();
		
		while(true) {
			Direction dir
				=get_random_unvisited_neighbour(row,col);
			if(dir==NONE) {
				return;
			}
			drill_wall(row, col, dir);
			Cell& n=get_neighbour(row, col, dir);
			generate(n.get_row(), n.get_col());
		}
	
	}

};

const Direction Board::DIRECTIONS[] = {UP,LEFT,DOWN,RIGHT};

int main() {

	Board b(20, 20);
	
	b.generate(0,0);
		
	b.draw(cout);



	return 0;
}






