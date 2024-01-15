import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Main {
    private static class User {
        public String name;
        public String id;

        public User(String name, String id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }
    }

    private static class Book {
        public String title;
        public String id;
        public String ownerId;

        public Book(String title, String id, String ownerId) {
            this.title = title;
            this.id = id;
            this.ownerId = ownerId;
        }

        public String getTitle() {
            return title;
        }

        public String getId() {
            return id;
        }

        public String getOwnerId() {
            return ownerId;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "title='" + title + '\'' +
                    ", id='" + id + '\'' +
                    ", ownerId='" + ownerId + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
//        Stream
//            .of(1,2,3,4,5,6,7)
//            .parallel()
//            .peek(a -> System.out.println("peek1: " + a))
//            .map(a -> a * 2)
////            .filter(a -> a > 10)
//            .peek(a -> System.out.println("peek2: " + a))
////            .sequential()
//            .sorted()
//            .forEach(a -> System.out.println("forEach: " + a));

//        Stream
//            .iterate(0, a -> a + 1)
//            .limit(50)
//            .sorted()
//            .forEach(a -> System.out.println("forEach: " + a));

//        Stream
//            .iterate(0, (a) -> {
//                System.out.println("iterate: " + a);
//                return a + 1;
//            })
////            .limit(5)
//            .sorted();
////            .forEach(a -> System.out.println("forEach: " + a));

        List<User> users = Stream
            .iterate(1, i -> i + 1)
            .limit(5)
            .map(i -> new User("User" + i, i.toString()))
            .toList();

        Random rand = new Random();
        List<Book> books = Stream
                .iterate(1, i -> i + 1)
                .limit(20)
                .map(i -> new Book(
                        "Book" + i,
                        i.toString(),
                        (rand.nextInt() % 6) + ""
                ))
                .toList();

//        select * from books
//        where ownerId = select id from users where name = "user2"

        //List<Book> foundBooks = users
        users
            .stream()
            .filter(u -> u.name.equals("User2"))
            .flatMap(u ->
                books
                    .stream()
                    .filter(b -> b.ownerId.equals(u.id))
//                    .toList()
//            ).toList();
            ).forEach(a -> System.out.println("forEach: " + a));
//            .map(u ->
//                books
//                    .stream()
//                    .filter(b -> b.ownerId.equals(u.id))
////                    .toList()
//            ).collect(a -> {
//
//                })
    }
}
