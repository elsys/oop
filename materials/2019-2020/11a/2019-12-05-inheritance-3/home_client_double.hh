#ifndef HOME_CLIENT_DOUBLE_HH
#define HOME_CLIENT_DOUBLE_HH

#include "./home_client.hh"

class HomeClientDouble : public HomeClient {
public:
  float usedPowerDay;
  float usedPowerNight;
  float rateDay;
  float rateNight;

  float calcBill() {
    return usedPowerDay * (rateDay + deliveryRate + distributionRate)
         + usedPowerNight * (rateNight + deliveryRate + distributionRate);
  }
};

#endif
