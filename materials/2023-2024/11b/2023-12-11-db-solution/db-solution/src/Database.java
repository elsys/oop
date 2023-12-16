import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database {
    private List<Table> tables = new ArrayList<>();

    public void loadFromFile(String filename) throws FileNotFoundException {
        Scanner fileIn = new Scanner(new FileInputStream(filename));
        while(fileIn.hasNext()) {
            String token = fileIn.next();
            if(token.equals("table")) {
                Table newTable = new Table(fileIn.next());

                token = fileIn.next();
                while(fileIn.hasNext() && !token.equals("table")) {
                    Column newCOlumn = new Column(token, fileIn.next());
                    newTable.addColumn(newCOlumn);
                    if(fileIn.hasNext())
                        token = fileIn.next();
                }

                tables.add(newTable);
            }
        }
    }

    @Override
    public String toString() {
        return "Database{" +
                "tables=" + tables +
                '}';
    }

    public void performQuery(String query) {
        Scanner qIn = new Scanner(query);

        String token = qIn.next();
//        switch (true) {
//            case token.equals("INSERT"): {
//
//            }
//        }
        if(token.equals("INSERT")) {
            qIn.next();
            String tableName = qIn.next();
//            tables.stream().filter(t -> t.getName().equals(tableName)).findFirst();
            Table table = null;
            for(Table t : tables) {
                if(t.getName().equals(tableName)) {
                    table = t;
                    break;
                }
            }

            Record newRecord = new Record();
            while(qIn.hasNext()) {
//                newRecord.set(..., ...);
                System.out.println(qIn.next());
            }
            table.addRecord(newRecord);
        }
    }
}
