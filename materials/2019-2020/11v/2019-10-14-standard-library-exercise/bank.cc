#include <iostream>
#include <string>
#include <vector>

class BankAccount {
  std::string client_name;
  std::string number;
  double balance;

public:
  BankAccount() {
    balance = 0;
  }

  BankAccount(std::string client_name, std::string number) {
    this->client_name = client_name;
    this->number = number;
    balance = 0;
  }

  BankAccount(std::string client_name, std::string number, double amount) {
    this->client_name = client_name;
    this->number = number;
    balance = amount;
  }

  std::string get_client_name() {
    return client_name;
  }

  std::string get_number() {
    return number;
  }

  double get_balance() {
    return balance;
  }

  bool is_empty() {
    return get_balance() == 0;
  }

  void deposit(double amount) {
    balance += amount;
  }

  void draw(double amount) {
    balance -= amount;
  }

  void print() {
    std::cout
      << get_client_name() << ", "
      << get_number() << ", "
      << get_balance() << " leva\n";
  }
};

class Bank {
  std::vector<BankAccount> bank_accounts;

  std::vector<BankAccount>::iterator find_account(std::string number) {
    for (std::vector<BankAccount>::iterator iter = bank_accounts.begin();
        iter != bank_accounts.end();
        ++iter
        ) {
      if (iter->get_number() == number) {
        return iter;
      }
    }
    return bank_accounts.end();
  }

public:
  Bank() {}

  Bank(std::vector<BankAccount> bank_accounts) {
    this->bank_accounts = bank_accounts;
  }

  void add_account(BankAccount account) {
    bank_accounts.push_back(account);
  }

  void remove_account(std::string number) {
    std::vector<BankAccount>::iterator iter = find_account(number);
    if (iter != bank_accounts.end()) {
      bank_accounts.erase(iter);
    }
  }

  double get_account_balance(std::string number) {
    std::vector<BankAccount>::iterator iter = find_account(number);
    if (iter != bank_accounts.end()) {
      return iter->get_balance();
    }
    return 0;
  }

  double get_client_balance(std::string client_name) {
    double balance = 0;

    for (std::vector<BankAccount>::iterator iter = bank_accounts.begin();
        iter != bank_accounts.end();
        ++iter
        ) {
      if (iter->get_client_name() == client_name) {
        balance += iter->get_balance();
      }
    }

    return balance;
  }
};

int main() {
  BankAccount bank_account("Georgi", "V7RG42NR");
  bank_account.print();
  bank_account.deposit(100);
  bank_account.print();
  bank_account.draw(70);
  bank_account.print();
  std::cout << bank_account.is_empty() << '\n';

  BankAccount account_of_ivan("Ivan", "1", 2000);
  BankAccount account_of_petar("Petar", "2", 500);
  BankAccount second_account_of_ivan("Ivan", "3", 400);

  std::vector<BankAccount> accounts = { account_of_ivan, account_of_petar };
  Bank bank(accounts);
  bank.add_account(second_account_of_ivan);

  std::cout << bank.get_account_balance("2") << '\n';
  bank.remove_account("2");
  std::cout << bank.get_account_balance("2") << '\n';

  std::cout << bank.get_client_balance("Ivan") << '\n';

  return 0;
}
