#include <iostream>

#include "./home_client_single.hh"
#include "./home_client_double.hh"
#include "./industrial_client_single.hh"
#include "./industrial_client_double.hh"

using namespace std;

int main() {
  HomeClientSingle h1;
  h1.deliveryRate = 1;
  h1.distributionRate = 1;
  h1.rate = 1;
  h1.usedPower = 10;
  HomeClientDouble h2;
  h2.deliveryRate = 1;
  h2.distributionRate = 1;
  h2.rateDay = 1;
  h2.rateNight = 0.5;
  h2.usedPowerDay = 10;
  h2.usedPowerNight = 100;

  IndustrialClientSingle i1;
  i1.deliveryRate = 1;
  i1.distributionRate = 1;
  i1.rate = 1;
  i1.highVoltageRate = 1;
  i1.usedPower = 10;
  IndustrialClientDouble i2;
  i2.deliveryRate = 1;
  i2.distributionRate = 1;
  i2.rateDay = 1;
  i2.rateNight = 0.5;
  i2.highVoltageRate = 1;
  i2.usedPowerDay = 10;
  i2.usedPowerNight = 100;

  cout << h1.calcBill() << endl;
  cout << h2.calcBill() << endl;
  cout << i1.calcBill() << endl;
  cout << i2.calcBill() << endl;
  return 0;
}
