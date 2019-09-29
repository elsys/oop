public class Value implements Comparable<Value> {
    private Integer value;

    public Value(int value) {
        this.value = value;
    }

    public Value() {
        this.value = -1;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Value o) {
        return this.value.compareTo(o.value);
    }
}
