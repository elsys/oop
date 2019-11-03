#include <string>
#include <vector>
#include <sstream>
#include <iostream>

class Product {
public:
  std::string name;
  float price;
  unsigned int quantity;
};

class Supermarket {
  std::vector<Product> products;

  std::vector<Product>::iterator findProduct(std::string name) {
    for (std::vector<Product>::iterator iter = products.begin();
        iter != products.end();
        ++iter) {
      if (iter->name == name) {
        return iter;
      }
    }

    return products.end();
  }

public:
  class ProductNotFoundError {
  public:
    std::string message;

    ProductNotFoundError() {
      this->message = "Product not found";
    }
  };

  class InvalidProductError {
  public:
    std::string message;

    InvalidProductError() {
      this->message = "Invalid product: price or quantity is zero";
    }
  };

  class NotEnoughQuantityError {
  public:
    std::string message;

    NotEnoughQuantityError() {
      this->message = "Not enough quantity";
    }
  };

  Supermarket() {}

  Supermarket(std::vector<Product> products) {
    this->products = products;
  }

  std::vector<Product> getProducts() {
    return products;
  }

  void addProduct(Product newProduct) {
    if (newProduct.price == 0 || newProduct.quantity == 0) {
      throw new InvalidProductError();
    }

    std::vector<Product>::iterator iter = findProduct(newProduct.name);
    if (iter == products.end()) {
      products.push_back(newProduct);
    } else {
      iter->price = newProduct.price;
      iter->quantity += newProduct.quantity;
    }
  }

  void removeQuantity(Product toRemove) {
    std::vector<Product>::iterator iter = findProduct(toRemove.name);

    if (iter == products.end()) {
      throw ProductNotFoundError();
    }
    if (toRemove.quantity > iter->quantity) {
      throw NotEnoughQuantityError();
    }

    if (toRemove.quantity == iter->quantity) {
      products.erase(iter);
    } else {
      iter->quantity -= toRemove.quantity;
    }
  }

  std::string toString() {
    std::ostringstream oss;
    for (std::vector<Product>::iterator iter = products.begin();
        iter != products.end();
        ++iter) {
      oss
        << iter->name << " - "
        << iter->price << " ("
        << iter->quantity << ")\n";
    }
    return oss.str();
  }

  void fromString(std::string results) {
    std::istringstream productsInputStream(results);
    std::string productString;
    while (std::getline(productsInputStream, productString, ':')) {
      std::istringstream productInputStream(productString);
      if (productInputStream.peek() == ' ') {
        productInputStream.ignore();
      }

      std::string name;
      std::string priceString;
      unsigned int quantity;
      std::getline(productInputStream, name, ',').ignore();
      std::getline(productInputStream, priceString, ',').ignore();
      productInputStream >> quantity;

      std::stringstream parseStream;
      float price;
      parseStream << priceString;
      parseStream >> price;

      addProduct(Product { name, price, quantity });
    }
  }
};

int main() {
  Supermarket supermarket;
  supermarket.fromString("Water, 1.99, 42 : Bread, 0.99, 12 : Water, 0.55, 20");
  supermarket.removeQuantity(Product { "Bread", 0.99, 2 });
  std::cout << supermarket.toString();

  return 0;
}
