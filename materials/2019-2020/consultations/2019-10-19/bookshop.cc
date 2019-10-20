#include <iostream>
#include <string>
#include <sstream>
#include <vector>

class Book {
  std::string title;
  std::string author;
  double price;

public:
  class InvalidInputError {
  public:
    std::string message;

    InvalidInputError() {
      message = "Invalid input";
    }
  };

  Book(std::string title, std::string author, double price) {
    if (title == "" || author == "" || price < 0) {
      throw InvalidInputError();
    }

    this->title = title;
    this->author = author;
    this->price = price;
  }

  std::string get_title() {
    return title;
  }

  std::string get_author() {
    return author;
  }

  double get_price() {
    return price;
  }

  std::string to_string() {
    std::ostringstream oss;
    oss
      << get_title() << " - "
      << get_author() << " - "
      << get_price() << " leva";

    return oss.str();
  }
};

class Bookshop {
  std::vector<Book> books;

public:
  class BookNotAvailableError {
  public:
    std::string message;

    BookNotAvailableError(std::string message) {
      this->message = message;
    }
  };

  Bookshop() {}

  Bookshop(std::vector<Book> books) {
    this->books = books;
  }

  void add_book(Book book) {
    books.push_back(book);
  }

  void remove_book(std::string title) {
    if (!is_book_available(title)) {
      throw BookNotAvailableError("Book not available");
    }

    for (std::vector<Book>::iterator iter = books.begin();
        iter != books.end();
        ++iter) {
      if (iter->get_title() == title) {
        books.erase(iter);
      }
    }
  }

  bool is_book_available(std::string title) {
    for (std::vector<Book>::iterator iter = books.begin();
        iter != books.end();
        ++iter) {
      if (iter->get_title() == title) {
        return true;
      }
    }

    return false;
  }

  int get_available_copies(std::string title) {
    int count = 0;

    for (std::vector<Book>::iterator iter = books.begin();
        iter != books.end();
        ++iter) {
      if (iter->get_title() == title) {
        ++count;
      }
    }

    return count;
  }

  Book get_most_expensive_book() {
    if (books.empty()) {
      throw BookNotAvailableError("Empty bookshop");
    }

    std::vector<Book>::iterator max = books.begin();
    for (std::vector<Book>::iterator iter = ++books.begin();
        iter != books.end();
        ++iter) {
      if (max->get_price() < iter->get_price()) {
        max = iter;
      }
    }

    return *max;
  }

  Book get_cheapest_book() {
    if (books.empty()) {
      throw BookNotAvailableError("Empty bookshop");
    }

    std::vector<Book>::iterator min = books.begin();
    for (std::vector<Book>::iterator iter = ++books.begin();
        iter != books.end();
        ++iter) {
      if (min->get_price() > iter->get_price()) {
        min = iter;
      }
    }

    return *min;
  }
};

int main() {
  Book game_of_thrones("Game Of Thrones", "George R. R. Martin", 0);

  try {
    Book invalid_book("", "author", 0);
  } catch (Book::InvalidInputError error) {
    std::cout << "Cannot create book: " << error.message << '\n';
  }

  std::string book_information = game_of_thrones.to_string();
  std::cout << book_information << '\n';

  Bookshop bookshop;
  std::cout << bookshop.is_book_available("Game Of Thrones") << '\n';

  try {
    bookshop.remove_book("Game Of Thrones");
  } catch (Bookshop::BookNotAvailableError error) {
    std::cout << "Cannot remove book: " << error.message << '\n';
  }

  try {
    bookshop.get_cheapest_book();
  } catch (Bookshop::BookNotAvailableError error) {
    std::cout << "Cannot get cheapest book: " << error.message << '\n';
  }

  bookshop.add_book(Book("Harry Potter", "J. K. Rowling", 9.99));
  bookshop.add_book(Book("Harry Potter", "J. K. Rowling", 9.99));
  std::cout << bookshop.get_available_copies("Harry Potter") << '\n';

  bookshop.add_book(game_of_thrones);

  std::cout << bookshop.get_most_expensive_book().to_string() << '\n';
  std::cout << bookshop.get_cheapest_book().to_string() << '\n';

  return 0;
}
