Задача
======
Да се напише програма, симулираща работата с книги в книжарница.

Книга
-----
Да се дефинира клас `Book`, представящ книга в книжарница. Една книга в
книжарницата съдържа следната информация:
* `title` – заглавие (`std::string`)
* `author` – име на автора (`std::string`)
* `price` – цена (`double`)

Член-данните на класа трябва да бъдат скрити (`private`).

Дефинирайте следните селектори (getter методи):
* `get_title()` – връща заглавието
* `get_author()` – връща името на автора
* `get_price()` – връща цената

### Конструиране
Книгата трябва да може да се конструира по заглавие, автор и цена.
Конструкторът трябва да хвърля изключение в следните случаи:
* когато заглавието или авторът е празен низ
* когато цената е отрицателно число

Пример:
```cpp
Book book("Game Of Thrones", "George R. R. Martin", 24.99); // конструира книга със заглавие "Game Of Thrones", автор "George R. R. Martin" и цена 24.99 лева
```

### Информация за книга
Да се напише метод `to_string()`, който:
* използва поток от тип `std::ostringstream`, за да генерира низ с инфомацията
за книгата
* връща генерирания низ (не потока)
* генерираният низ има следния формат: `<заглавие> - <автор> - <цена> leva`

Пример:
```cpp
Book book("Game Of Thrones", "George R. R. Martin", 24.99);
std::string book_information = book.to_string();
std::cout << book_information; // извежда на стандартния изход "Game Of Thrones - George R. R. Martin - 24.99 leva"
```

Книжарница
----------
Да се дефинира клас `Bookshop`, представящ наличните книги в книжарница. Класът
да съдържа член-даннa `books`, която да представлява колекцията от налични книги
в книжарницата. За целта използвайте колекция от стандартната библиотека
(`std::vector`, `std::list`).

### Конструиране
Книжарницата трябва да може да се конструира по следните начини:
* `Bookshop()` – празна книжарница (книжарница без налични книги)
* `Bookshop(<тип_колекция> books)` – по колекция от книги

### Функционалности
Да се дефинират следните методи:
* `add_book(Book book)` – добавя книга `book` към колекцията от налични книги в
книжарницата
* `remove_book(std::string title)` – премахва книга със заглавие `title` от
колекцията с налични книги в книжарницата; хвърля изключение, ако няма налична
книга със заглавие `title`
* `is_book_available(std::string title)` – проверява дали книга със заглавие
`title` е налична в книжарницата
* `get_available_copies(std::string title)` – връща броя на наличните екземпляри
на книга със заглавие `title` в книжарницата
* `get_most_expensive_book()` – връща най-скъпата книга в книжарницата; хвърля
изключение, ако няма нито една налична книга в книжарницата
* `get_cheapest_book()` – връща най-евтината книга в книжарницата; хвърля
изключение, ако няма нито една налична книга в книжарницата

Пример:
```cpp
Book game_of_thrones("Game Of Thrones", "George R. R. Martin", 24.99);
Book harry_potter("Harry Potter", "J. K. Rowling", 19.99);
Book war_and_peace("War And Peace", "Tolstoy", 9.99);

std::vector<Book> books = { game_of_thrones, game_of_thrones, harry_potter };
Bookshop bookshop(books);
bookshop.add_book(war_and_peace);

bookshop.is_book_available("Game Of Thrones"); // връща true
bookshop.remove_book("Harry Potter");
bookshop.is_book_available("Harry Potter"); // връща false

bookshop.get_available_copies("Harry Potter"); // връща 0
bookshop.get_available_copies("Game Of Thrones"); // връща 2

bookshop.get_most_expensive_book().to_string(); // връща "Game Of Thrones - George R. R. Martin - 24.99 leva"
bookshop.get_cheapest_book().to_string(); // връща "War And Peace - Tolstoy - 9.99 leva"
```
