#include <iostream>
#include <fstream>
#include <sstream>
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
    print_books(out);
    out.close();

    cout << "++ Saved to books.csv ++" << endl;
  }

  void print_books() {
    print_books(cout);
  }

  void print_books(ostream& out) {
    for(list<Book>::iterator it = books.begin(); it != books.end(); it++) {
      Book book = *it;
      out << book.title << "," << book.author << "," << book.pages << "," << book.rating << endl;
    }
  }
};

int main(int argc, char** argv) {
  Library lib;

  if(argc > 1 && string("read").compare(argv[1]) == 0) {
    cout << "++ Reading from books.csv ++" << endl;
    ifstream in = ifstream("books.csv");

    string line;
    while(getline(in, line)) {
      stringstream ss = stringstream(line);
      Book new_book;

      getline(ss, new_book.title, ',');
      getline(ss, new_book.author, ',');
      ss >> new_book.pages;  // Read an integer
      ss.seekg(1, ss.cur);   // Skip the next comma
      ss >> new_book.rating; // Read a float

      lib.add_book(new_book);
    }

    in.close();
  } else {
    while(!cin.eof()) {
      cout << "++ Enter a book ++" << endl;
      Book new_book;

      getline(cin, new_book.title);
      getline(cin, new_book.author);
      cin >> new_book.pages >> new_book.rating;
      if(!cin.eof() && cin.good()) {
        lib.add_book(new_book);
      }
    }
    lib.save_as_csv();
  }

  cout << "++ All books ++" << endl;
  lib.print_books();

  return 0;
}
