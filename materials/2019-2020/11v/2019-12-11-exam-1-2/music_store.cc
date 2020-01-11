#include "music_store.hh"

std::vector<Acoustic>::const_iterator MusicStore::find_acoustic(
    unsigned int id) const {
  for (auto iter = acoustics.begin(); iter != acoustics.end(); ++iter) {
    if (iter->get_id() == id) {
      return iter;
    }
  }
  return acoustics.end();
}

std::vector<Electric>::const_iterator MusicStore::find_electric(
    unsigned int id) const {
  for (auto iter = electrics.begin(); iter != electrics.end(); ++iter) {
    if (iter->get_id() == id) {
      return iter;
    }
  }
  return electrics.end();
}

std::vector<Guitar> MusicStore::get_all_in_price_range(
    double from_price,
    double to_price) const {
  std::vector<Guitar> result;
  for (auto iter = acoustics.begin(); iter != acoustics.end(); ++iter) {
    if (iter->get_price() >= from_price && iter->get_price() <= to_price) {
      result.push_back(*iter);
    }
  }
  for (auto iter = electrics.begin(); iter != electrics.end(); ++iter) {
    if (iter->get_price() >= from_price && iter->get_price() <= to_price) {
      result.push_back(*iter);
    }
  }
  return result;
}

std::vector<Guitar> MusicStore::get_all_twelve_strings() const {
  std::vector<Guitar> result;
  for (auto iter = acoustics.begin(); iter != acoustics.end(); ++iter) {
    if (iter->get_strings() == 12) {
      result.push_back(*iter);
    }
  }
  for (auto iter = electrics.begin(); iter != electrics.end(); ++iter) {
    if (iter->get_strings() == 12) {
      result.push_back(*iter);
    }
  }
  return result;
}

Acoustic const& MusicStore::get_most_powerful_acoustic() const {
  if (acoustics.empty()) {
    throw NoAcousticsError();
  }

  auto most_powerful = acoustics.begin();
  for (auto iter = most_powerful + 1; iter != acoustics.end(); ++iter) {
    if (iter->get_sound_power() > most_powerful->get_sound_power()) {
      most_powerful = iter;
    }
  }
  return *most_powerful;
}

Electric const& MusicStore::get_most_powerful_electric() const {
  if (electrics.empty()) {
    throw NoAcousticsError();
  }

  auto most_powerful = electrics.begin();
  for (auto iter = most_powerful + 1; iter != electrics.end(); ++iter) {
    if (iter->get_pickups_output() > most_powerful->get_pickups_output()) {
      most_powerful = iter;
    }
  }
  return *most_powerful;
}

void MusicStore::add_acoustic(Acoustic const& acoustic) {
  if (find_acoustic(acoustic.get_id()) != acoustics.end()) {
    throw MusicalInstrumentAlreadyExistsError();
  }
  if (find_electric(acoustic.get_id()) != electrics.end()) {
    throw MusicalInstrumentAlreadyExistsError();
  }

  acoustics.push_back(acoustic);
}

void MusicStore::add_electric(Electric const& electric) {
  if (find_electric(electric.get_id()) != electrics.end()) {
    throw MusicalInstrumentAlreadyExistsError();
  }
  if (find_acoustic(electric.get_id()) != acoustics.end()) {
    throw MusicalInstrumentAlreadyExistsError();
  }

  electrics.push_back(electric);
}

void MusicStore::buy(Guitar const& guitar) {
  auto acoustic = find_acoustic(guitar.get_id());
  if (acoustic != acoustics.end()) {
    acoustics.erase(acoustic);
    return;
  }

  auto electric = find_electric(guitar.get_id());
  if (electric != electrics.end()) {
    electrics.erase(electric);
    return;
  }

  throw MusicalInstrumentDoesNotExistError();
}
