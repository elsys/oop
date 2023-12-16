import java.util.HashMap;
import java.util.Map;

public class Record {
    private Map<String ,String> values = new HashMap<>();

    public void set(String key, String value) {
        values.put(key, value);
    }
}
