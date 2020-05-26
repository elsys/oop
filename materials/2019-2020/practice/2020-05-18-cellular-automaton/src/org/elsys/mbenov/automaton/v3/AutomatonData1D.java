package org.elsys.mbenov.automaton.v3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public abstract class AutomatonData1D<T> implements IAutomatonData<T> {
    private T[] cells;
    private int fieldSize;

    public AutomatonData1D(T[] cells) {
        this.cells = cells;
        this.fieldSize = cells.length;
    }

    public List<T> getArea(int index) {
        List<T> area = new ArrayList<>();

        // Left neighbour
        area.add(index > 0 ? cells[index - 1] : cells[fieldSize - 1]);
        // Current item
        area.add(cells[index]);
        // Right neighbour
        area.add(index < fieldSize - 1 ? cells[index + 1] : cells[0]);

        return area;
    }

    @Override
    public String toString() {
        return Arrays.stream(cells)
                .map(v -> v.toString())
                .collect(Collectors.joining(" ", "(", ")"));
    }

    // Create a stream of areas for each element.
    @Override
    public Stream<List> stream() {
        return IntStream.range(0, fieldSize)
                .mapToObj((index) -> getArea(index));
    }

    @Override
    public void updateValues(List buffer) {
        buffer.toArray(cells);
    }
}
