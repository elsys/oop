#ifndef CASE_HH
#define CASE_HH

#include "component.hh"
#include "mother_board.hh"
#include "ps.hh"
#include "hd.hh"

class Case : public Component {
  MotherBoard mother_board;
  PS ps;
  HD hds[6];
  unsigned int hd_count;

public:
  Case(
      double price,
      MotherBoard mother_board,
      PS ps,
      HD hds[6],
      unsigned int hd_count);

  Case(Case const& other);

  Case& operator=(Case const& other);

  double get_own_score() const;

  double get_total_score() const;

  double get_total_price() const;
};

#endif
