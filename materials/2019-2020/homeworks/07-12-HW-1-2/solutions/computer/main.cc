#include "cpu.hh"
#include "ram.hh"
#include "hd.hh"
#include "ps.hh"
#include "mother_board.hh"
#include "case.hh"
#include <iostream>

int main() {
  CPU cpu(200, 4, 2);
  RAM ram(60, 16, 4);
  HD hd(30, 1000, 42);
  PS ps(50, 200);

  RAM rams[] = { ram };
  MotherBoard mother_board(70, cpu, rams, 1);

  HD hds[] = { hd };
  Case case1(20, mother_board, ps, hds, 1);

  std::cout
    << case1.get_total_price() << '\n'
    << case1.get_total_score() << '\n';

  return 0;
}
