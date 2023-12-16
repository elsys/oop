import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Database myDb = new Database();

        try {
            myDb.loadFromFile("schema.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Failed to open file");
            return;
        }

        System.out.println(myDb);

        myDb.performQuery("INSERT INTO table1 column1=asd column2=qwe column3=123");
    }
}
