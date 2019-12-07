#ifndef INDUSTRIAL_CLIENT_DOUBLE_HH
#define INDUSTRIAL_CLIENT_DOUBLE_HH

#include "./industrial_client.hh"
#include "./double_rate.hh"

class IndustrialClientDouble : public IndustrialClient, public DoubleRate {
public:
  float calcBill() {
    return usedPowerDay * (rateDay + deliveryRate + distributionRate + highVoltageRate)
         + usedPowerNight * (rateNight + deliveryRate + distributionRate + highVoltageRate);
  }
};

#endif
