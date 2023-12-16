import com.sun.source.tree.ArrayAccessTree;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private String name;
    private List<Column> columns = new ArrayList<>();
    private List<Record> records = new ArrayList<>();

    public Table(String name) {
        this.name = name;
    }

    public void addColumn(Column col) {
        columns.add(col);
    }

    public void addRecord(Record record) {
        records.add(record);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Table{" +
                "name='" + name + '\'' +
                ", columns=" + columns +
                ", records=" + records +
                '}';
    }
}
