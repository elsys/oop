import java.util.Comparator;
import java.util.Objects;

public class Book implements Comparable {
    public String isbn;
    public int year;
    public String author;
    public int size;

    public String getIsbn() {
        return isbn;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public int getSize() {
        return size;
    }

    @Override
    public int compareTo(Object o) {
        if(o == null) return 1;
        if(!(o instanceof  Book)) return 1;
        if(o == this) return 0;

        Book oo = (Book)o;
//        Comparator.comparingInt(Book::getYear)
        return size - oo.size;
    }

    public static Comparator<Book> compareByYear = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.year - o2.year;
        }
    };
}
