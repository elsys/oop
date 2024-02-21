import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FigureTest {
    private Figure testFig = null;

    @Mock
    public Game mockedGame;

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
        when(mockedGame.getAt("A2")).thenReturn(null);
//        when(mockedGame.getAt("A3")).thenReturn((Figure) new Object());

        testFig = createFigure("white", true);
        testFig.move("A2");

        verify(mockedGame).getAt("A2");
        verify(mockedGame).setAt("A2", testFig);
        verify(mockedGame).setAt("C5", null);
    }

    @Test
    void testToString() {
        assertEquals("w", testFig.toString());

        testFig = createFigure("black", false);
        assertEquals("b", testFig.toString());
    }

    private Figure createFigure(String owner, boolean canMove) {
        return new Figure(
                mockedGame, owner, new Game.Pos(2, 4), new char[]{'w', 'b'}
        ) {
            @Override
            protected boolean canMove(String pos) {
                return canMove;
            }
        };
    }
}