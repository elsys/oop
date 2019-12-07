#ifndef INDUSTRIAL_CLIENT_DOUBLE_HH
#define INDUSTRIAL_CLIENT_DOUBLE_HH

#include "./industrial_client.hh"

class IndustrialClientDouble : public IndustrialClient {
public:
  float usedPowerDay;
  float usedPowerNight;
  float rateDay;
  float rateNight;

  float calcBill() {
    return usedPowerDay * (rateDay + deliveryRate + distributionRate + highVoltageRate)
         + usedPowerNight * (rateNight + deliveryRate + distributionRate + highVoltageRate);
  }
};

#endif
