#include <vector>
#include <iostream>
#include <stdlib.h>

using namespace std;

class Figure {
private:
  int value = 0;

public:
  int getValue() {
    return value;
  }

  // Figure(int value) {
  //   this->value = value;
  // }

  Figure(int value) : value(value) {}

  virtual void checkAndDestroy() = 0;
};

class Candy : public Figure {
public:
  Candy(int value) : Figure(value) {}

  void checkAndDestroy() {
    for(int i = x - 2; i < x + 2; i++) {
      // ...
    }
    for(int i = x; i > 0 && board3[i][y] == board3[x][y]; i--) {
      // ...
    }
  }
};

class CandyGame {
private:
  // Figure** board;
  // vector<Figure*> board2;
  vector<vector<Figure*>> board3;

  int isInBounds(int x, int y) {
    return x >= 0 && x < getRows() && y >= 0 && y < getCols();
  }

public:
  int getRows() {
    return board3.size();
  }

  int getCols() {
    if(getRows() == 0) {
      return 0;
    }

    return board3[0].size();
  }

  CandyGame(int rows, int cols) {
    board3.resize(rows);
    for(int i = 0; i < rows; i++) {
      board3[i].resize(cols, nullptr);

      // for(int j = 0; j < cols; j++) {
      //   board3[i][j] = nullptr;
      // }

      for(int j = 0; j < cols; j++) {
        board3[i][j] = new Candy(rand() % 4);
      }
    }
  }

  void print() {
    for(int i = 0; i < getRows(); i++) {
      for(int j = 0; j < getCols(); j++) {
        if(board3[i][j] == nullptr) {
          cout << "N";
        } else {
          cout << board3[i][j]->getValue();
        }
      }
      cout << endl;
    }
  }

  void swapFigs(int x1, int y1, int x2, int y2) {
    if(!isInBounds(x1, y1) || !isInBounds(x2, y2)) {
      throw "Invalid coordinates";
    }

    if(abs(x1 - x2) + abs(y1 - y2) != 1) {
      throw "Not neighboring";
    }

    Figure* temp = board3[x1][y1];
    board3[x1][y1] = board3[x2][y2];
    board3[x2][y2] = temp;

    destroyFigures(x1, y1);
    destroyFigures(x2, y2);
  }

  void destroyFigures(int x, int y) {
    board3[x][y].checkAndDestroy();
  }
};

int main() {
  CandyGame game = CandyGame(5, 3);

  game.print();
cout << endl;
  game.swapFigs(0, 0, 0, 1);
  game.print();

  return 0;
}