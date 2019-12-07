#ifndef HOME_CLIENT_SINGLE_HH
#define HOME_CLIENT_SINGLE_HH

#include "./home_client.hh"

class HomeClientSingle : public HomeClient {
public:
  float usedPower;
  float rate;

  float calcBill() {
    return usedPower * (rate + deliveryRate + distributionRate);
  }
};

#endif
