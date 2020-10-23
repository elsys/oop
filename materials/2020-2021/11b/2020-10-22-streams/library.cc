#include <iostream>
#include <fstream>
#include <list>

using namespace std;

class Book {
public:
  string title = "";
  string author = "";
  unsigned int pages = 0;
  float rating = 0.0f;

  Book() {}

  Book(string title, string author, unsigned int pages, float rating) {
    this->title = title;
    this->author = author;
    this->pages = pages;
    this->rating = rating;
  }
};

class Library {
  list<Book> books;
public:
  void add_book(Book book) {
    books.push_back(book);
  }

  void save_as_csv() {
    ofstream out = ofstream("./books.csv");

    for(list<Book>::iterator it = books.begin(); it != books.end(); it++) {
      Book book = *it;
      out << book.title << "," << book.author << "," << book.pages << "," << book.rating << endl;
    }

    out.close();
  }
};

int main() {
  Library lib;

  while(!cin.eof()) {
    Book new_book;

    cin >> new_book.title >> new_book.author >> new_book.pages >> new_book.rating;
    if(!cin.eof() && cin.good()) {
      lib.add_book(new_book);
    }
  }

  lib.save_as_csv();

  return 0;
}
