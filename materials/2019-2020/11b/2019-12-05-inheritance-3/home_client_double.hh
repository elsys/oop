#ifndef HOME_CLIENT_DOUBLE_HH
#define HOME_CLIENT_DOUBLE_HH

#include "./client.hh"
#include "./double_rate.hh"

class HomeClientDouble : public Client, public DoubleRate {
public:
  float calcBill() {
    return usedPowerDay * (rateDay + deliveryRate + distributionRate)
         + usedPowerNight * (rateNight + deliveryRate + distributionRate);
  }
};

#endif
