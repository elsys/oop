package org.elsys.mbenov.automaton.v3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AutomatonData2D<T> implements IAutomatonData<T> {
    private T[][] cells;
    private int columnCount;
    private int rowCount;

    public AutomatonData2D(T[][] cells) {
        this.cells = cells;
        this.columnCount = cells[0].length;
        this.rowCount = cells.length;
    }


    // Return a 3x3 area wrapping around edges.
    @Override
    public List getArea(int index) {
        int x = index % columnCount;
        int y = index / columnCount;

        List<List<T>> area = new ArrayList<>(){
            {
                add(new ArrayList<>(3));
                add(new ArrayList<>(3));
                add(new ArrayList<>(3));
            }
        };

        for(int xInner = x - 1; xInner <= x +1; xInner++) {
            for(int yInner = y - 1; yInner <= y +1; yInner++) {
                int xReal = xInner;
                int yReal = yInner;

                if(xReal < 0) xReal = columnCount - 1;
                if(xReal >= columnCount) xReal = 0;
                if(yReal < 0) yReal = rowCount - 1;
                if(yReal >= rowCount) yReal = 0;

                area.get(yInner - y + 1).add(cells[yReal][xReal]);
            }
        }

        return area;
    }

    @Override
    public String toString() {
        return Arrays.stream(cells)
                .map((row) -> Arrays.stream(row)
                        .map((v) -> v.toString())
                        .collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n ", "(", ")"));
    }

    // Convert to a 1-dimensional stream.
    @Override
    public Stream<List> stream() {
        return IntStream.range(0, rowCount * columnCount)
                .mapToObj((index) -> getArea(index));
    }

    // Update cells from a 1-dimensional list.
    @Override
    public void updateValues(List buffer) {
        for(int y = 0; y < rowCount; y++) {
            buffer.subList(y * columnCount, (y+1) * columnCount).toArray(cells[y]);
        }
    }
}
