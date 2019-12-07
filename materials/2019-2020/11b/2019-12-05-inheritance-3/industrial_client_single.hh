#ifndef INDUSTRIAL_CLIENT_SINGLE_HH
#define INDUSTRIAL_CLIENT_SINGLE_HH

#include "./industrial_client.hh"
#include "./single_rate.hh"

class IndustrialClientSingle : public IndustrialClient, public SingleRate {
public:
  float calcBill() {
    return usedPower * (rate + deliveryRate + distributionRate + highVoltageRate);
  }
};

#endif
