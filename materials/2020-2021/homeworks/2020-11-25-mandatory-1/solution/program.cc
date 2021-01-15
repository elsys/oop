#include <string.h>

#include <iostream>
#include <fstream>
#include <list>
#include <map>
#include <vector>
using namespace std;

class Package {
  static unsigned int package_counter;
public:
  static void validate_address(const string address) {
    if(address == "0.0.0.0") throw invalid_argument("Address cannot be 0.0.0.0");
    if(address == "127.0.0.0") throw invalid_argument("Address cannot be 127.0.0.0");
  }

  static void validate_content(const char* content) {
    if(strlen(content) <= 0) throw invalid_argument("Content cannot be empty");
  }

  char* const content;
  const int content_length;
  const string destination;
  const string source;
  const unsigned int package_number;

  Package(const char* const content, const string source, const string destination) :
    content_length(strlen(content)),
    package_number(package_counter++),
    content(new char[strlen(content)]),
    source(source),
    destination(destination)
  {
    validate_content(content);
    validate_address(source);
    validate_address(destination);

    strcpy(this->content, content);
  }

  ~Package() {
    delete content;
  }

  int validate() {
    return strlen(content) == content_length;
  }

  friend ostream& operator<<(ostream& out, const Package& package);
};

ostream& operator<<(ostream& out, const Package& package) {
  out << "[" << package.package_number << "]" << endl;
  out << "Content: " << package.content << " (" << package.content_length << ")" << endl;
  out << package.source << " -> " << package.destination;
  return out;
}

unsigned int Package::package_counter = 0;



class Route {
public:
  string address;
  int index;
  int sent_packages;

  Route(string address, int index) : address(address), index(index), sent_packages(0) { }

  friend ostream& operator<<(ostream& out, const Route& route);
};

ostream& operator<<(ostream& out, const Route& route) {
  out << route.address << " " << route.index << " " << route.sent_packages;
  return out;
}



class Router {
  static const unsigned int max_routes = 10;
  static const unsigned int max_hops = 5;

  vector<Router*> neighbors;
  list<Route*> routes;
  unsigned int package_counter = 0;
public:
  const string name;
  const string address;

  Router(string name, string address) : name(name), address(address) {}

  void add_router(Router& router) {
    Package::validate_address(router.address);

    Router* ref = &router;
    for(auto it = neighbors.begin(); it != neighbors.end(); it++) {
      // Router is already added
      if(*it == ref) return;
    }
    neighbors.push_back(ref);
  }

  int query_route(const string address, const int hop_count) {
    log() << "query_route(" << address << " " << hop_count << ")" << endl;
    // It's the current router
    if(this->address == address) {
      log() << "It's the current router." << endl;
      return 1;
    }

    // There is a known route
    for(auto it = routes.begin(); it != routes.end(); it++) {
      const Route* route = *it;
      if(route->address == address) {
        log() << "Found known route " << *route << endl;
        return 1;
      }
    }

    // No more hops allowed
    if(hop_count <= 0) {
      log() << "Max hop count reached." << endl;
      return 0;
    }

    // A neighbor is the target or knows where the target is
    unsigned int index = 0;
    for(auto it = neighbors.begin(); it != neighbors.end(); it++, index++) {
      Router* router = *it;
      log() << "Qurying neighbor " << *router << endl;
      if(router->query_route(address, hop_count - 1)) {
        Route* new_route = new Route(address, index);
        this->add_route(new_route);
        log() << "Route found " << new_route << endl;
        return 1;
      }
    }

    log() << "Route not found." << endl;
    // Target not found - either doesn't exist or max hops reached
    return 0;
  }

  void send_package(const Package& package) {
    Package::validate_address(package.source);
    Package::validate_address(package.destination);
    Package::validate_content(package.content);

    log() << "send_package(" << package << ")" << endl;
    if(address == package.destination) {
      log() << "Target is the current router. No more actions." << endl;
      return;
    }

    log() << "Checking in the known routes." << endl;
    for(auto it = routes.begin(); it != routes.end(); it++) {
      Route* route = *it;
      if(route->address == package.destination) {
        log() << "Route found " << *route << endl;
        route->sent_packages++;
        neighbors.at(route->index)->send_package(package);
        package_counter++;
        if(package_counter >= 10) consolidate_routes();
        return;
      }
    }

    log() << "Search for route to " << package.destination << endl;
    if(!query_route(package.destination, max_hops)) {
      log() << "Route not found. Dropping the package." << endl;
      return;
    }

    Route* new_route = routes.back();
    new_route->sent_packages++;
    neighbors.at(new_route->index)->send_package(package);
    package_counter++;
    if(package_counter >= 10) consolidate_routes();
  }

  int has_route(string address) {
    for(auto it = routes.begin(); it != routes.end(); it++) {
      if((*it)->address == address) return 1;
    }
    return 0;
  }

  void add_route(Route* new_route) {
    if(has_route(new_route->address)) return;
    log() << "Add route entry " << *new_route << endl;
    if(routes.size() >= max_routes) {
      routes.pop_back();
    }
    routes.push_back(new_route);
  }

  void consolidate_routes() {
    log() << "Consolidate routes" << endl;
    package_counter = 0;

    routes.sort([](const Route* a, const Route* b) { return a->sent_packages > b->sent_packages; });
  }

  ostream& log() {
    cout << "Router " << this->name << "(" << this->address << "): ";
    return cout;
  }

  ostream& print_neighbors() const {
    int i = 0;
    for(auto it = neighbors.begin(); it != neighbors.end(); it++) {
      cout << "\t[" << i++ << "] " << **it << endl;
    }
    return cout;
  }

  ostream& print_routes() const {
    int i = 0;
    for(auto it = routes.begin(); it != routes.end(); it++) {
      cout << "\t[" << i++ << "] " << **it << endl;
    }
    return cout;
  }

  friend ostream& operator<<(ostream& out, const Router& router);
};

ostream& operator<<(ostream& out, const Router& router) {
  out << router.name << " " << router.address << endl;
  out << "Neighbors:" << endl;
  int i = 0 ;
  for(auto it = router.neighbors.begin(); it != router.neighbors.end(); it++) {
    cout << "\t[" << i++ << "] " << (*it)->name << " " << (*it)->address << endl;
  }
  out << "Routing table:" << endl;
  router.print_routes();
  return out;
}



map<string, Router*> read_routers() {
  map<string, Router*> routers;

  ifstream routers_stream = ifstream("./routers.txt", std::ifstream::in);
  while(routers_stream.good()) {
    string router_name;
    string router_address;

    routers_stream >> router_name;
    if(router_name.length() > 0) {
      routers_stream >> router_address;
      try {
        routers[router_address] = new Router(router_name, router_address);
      } catch (exception& ex) {
        // Cannot create router
        cout << ex.what() << endl;
      }
    }
  }
  routers_stream.close();

  return routers;
}


void read_network(map<string, Router*>& routers) {
  ifstream network_stream = ifstream("./network.txt", std::ifstream::in);

  while(network_stream.good()) {
    string left_name = "";
    string right_name = "";

    network_stream >> left_name;
    if(left_name.length() > 0) {
      network_stream >> right_name;
      try {
        string left_address = "";
        string right_address = "";

        for(auto it = routers.begin(); it != routers.end(); it++) {
          if(!left_address.length() && it->second->name == left_name) left_address = it->second->address;
          if(!right_address.length() && it->second->name == right_name) right_address = it->second->address;
        }

        routers[left_address]->add_router(*routers[right_address]);
        routers[right_address]->add_router(*routers[left_address]);
      } catch (exception& ex) {
        // Cannot add router
        cout << ex.what() << endl;
      }
    }
  }

  network_stream.close();
}


void read_and_send_packages(map<string, Router*>& routers) {
  ifstream package_stream = ifstream("./packages.txt", std::ifstream::in);

  while(package_stream.good()) {
    string source = "";
    string destination = "";
    string content = "";

    package_stream >> source;
    if(source.length() > 0) {
      package_stream >> destination;
      package_stream.ignore(2);
      getline(package_stream, content, '\"');

      try {
        routers[source]->send_package(Package(content.c_str(), source, destination));
      } catch (exception& ex) {
        // Cannot send package
        cerr << ex.what() << endl;
      }
    }
  }

  package_stream.close();
}


int main() {
  // Mapping of address -> router
  map<string, Router*> routers;

  try {
    routers = read_routers();
  } catch (exception& ex) {
    // IO error
    cout << ex.what() << endl;
    return 1;
  }

  try {
    read_network(routers);
  } catch (exception& ex) {
    // IO error
    cout << ex.what() << endl;
    return 1;
  }

  for(auto it = routers.begin(); it != routers.end(); it++) {
    cout << *(it->second) << endl;
  }

  read_and_send_packages(routers);

  for(auto it = routers.begin(); it != routers.end(); it++) {
    cout << *(it->second) << endl;
  }

  return 0;
}
