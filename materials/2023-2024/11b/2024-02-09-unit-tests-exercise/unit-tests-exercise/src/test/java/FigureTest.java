import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FigureTest {
    private Figure testFig = null;

    @BeforeEach
    void setup() {
        testFig = createFigure("white", false);
    }

    @Test
    void moveInvalidPos() {
        assertThrows(
            IllegalArgumentException.class,
            () -> testFig.move("-2"),
            "Negative position"
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> testFig.move("K2"),
                "Position too big"
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> testFig.move("A2"),
                "Cannot move to position"
        );
    }

    @Test
    void moveTargetPos() {
        testFig = createFigure("white", true);
        testFig.move("A2");
    }

    @Test
    void testToString() {
        assertEquals("w", testFig.toString());

        testFig = createFigure("black", false);
        assertEquals("b", testFig.toString());
    }

    private Figure createFigure(String owner, boolean canMove) {
        return new Figure(
                null, owner, null, new char[]{'w', 'b'}
        ) {
            @Override
            protected boolean canMove(String pos) {
                return canMove;
            }
        };
    }
}