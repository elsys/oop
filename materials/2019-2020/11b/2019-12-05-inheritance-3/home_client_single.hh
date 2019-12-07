#ifndef HOME_CLIENT_SINGLE_HH
#define HOME_CLIENT_SINGLE_HH

#include "./client.hh"
#include "./single_rate.hh"

class HomeClientSingle : public Client, public SingleRate {
public:
  float calcBill() {
    return usedPower * (rate + deliveryRate + distributionRate);
  }
};

#endif
