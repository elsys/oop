#include "./pistol_sword.hh"

PistolSword::PistolSword(int damage, int minRange, int maxRange, int meleRange) : Shooty(damage, minRange, maxRange), Stabby(damage, meleRange) {};
