package org.elsys.mbenov.automaton.v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AutomatonData<T> {
    protected T[] values;

    public AutomatonData(T[] values) {
        this.values = values;
    }

    protected AutomatonData() { }

    @Override
    public String toString() {
        return Arrays.stream(values)
                .map(v -> v.toString())
                .collect(Collectors.joining(" ", "(", ")"));
    }

    protected List<T> getArea(int index) {
        List<T> area = new ArrayList<>();

        // Left neighbour
        area.add(index > 0 ? values[index - 1] : values[values.length - 1]);
        // Current item
        area.add(values[index]);
        // Right neighbour
        area.add(index < values.length - 1 ? values[index + 1] : values[0]);

        return area;
    }

    public Stream<List<T>> stream() {
        return IntStream.range(0, values.length)
                .mapToObj((index) -> getArea(index));
    }

    public void updateValues(List<T> buffer) {
        buffer.toArray(values);
    }
}
