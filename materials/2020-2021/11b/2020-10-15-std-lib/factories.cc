#include <iostream>
#include <queue>
#include <list>
#include <string>

using namespace std;

class Product {
public:
  string name;
  int quantity;

  Product() {
    name = "";
    quantity = 0;
  }

  Product(string name, int quantity) {
    this->name = name;
    this->quantity = quantity;
  }
};

class Order {
public:
  Product product;
  bool is_complete;

  Order() {
    is_complete = false;
  }

  Order(Product product) {
    this->product = product;
    is_complete = false;
  }
};

class Factory {
public:
  list<Product> possible;
  Factory(list<Product> possible) {
    this->possible = possible;
  }

  bool can_produce(Product product) {
    for(list<Product>::iterator it = possible.begin(); it != possible.end(); it++) {
      Product produced = *it;
      if(produced.name == product.name && produced.quantity >= product.quantity) return true;
    }

    return false;
  }
};

int main() {
  // Create factories
  list<Factory> factories;
  factories.push_back(
    Factory(
      list<Product>({
        Product("apple", 100),
        Product("peach", 50),
        Product("banana", 35)
      })
    )
  );
  factories.push_back(
    Factory(
      list<Product>({
        Product("chair", 10),
        Product("table", 5),
        Product("sofa", 3)
      })
    )
  );

  queue<Order> orders;
  list<Order> complete;
  list<Order> failed;

  // Input orders
  string input = "";
  int quantity = 0;
  do {
    cout << "Enter product or stop: ";
    cin >> input;
    if(input != "stop") {
      cout << "Enter quantity: ";
      cin >> quantity;
      orders.push(Order(Product(input, quantity)));
    }
  } while(input != "stop");

  // Find orders that can be completed
  while(!orders.empty()) {
    Order order = orders.front();
    orders.pop();

    for(list<Factory>::iterator it = factories.begin(); it != factories.end(); it++) {
      Factory factory = *it;
      if(factory.can_produce(order.product)) {
        order.is_complete = true;
        break;
      }
    }

    if(order.is_complete) {
      complete.push_back(order);
    } else {
      failed.push_back(order);
    }
  }

  // Print results
  cout << "Successful orders: " << complete.size() << endl;
  for(list<Order>::iterator it = complete.begin(); it != complete.end(); it++) {
    Order order = *it;
    cout << order.product.name << " " << order.product.quantity << endl;
  }

  cout << endl;

  cout << "Failed orders: " << failed.size() << endl;
  for(list<Order>::iterator it = failed.begin(); it != failed.end(); it++) {
    Order order = *it;
    cout << order.product.name << " " << order.product.quantity << endl;
  }

  return 0;
}
