#ifndef INDUSTRIAL_CLIENT_SINGLE_HH
#define INDUSTRIAL_CLIENT_SINGLE_HH

#include "./industrial_client.hh"

class IndustrialClientSingle : public IndustrialClient {
public:
  float usedPower;
  float rate;

  float calcBill() {
    return usedPower * (rate + deliveryRate + distributionRate + highVoltageRate);
  }
};

#endif
