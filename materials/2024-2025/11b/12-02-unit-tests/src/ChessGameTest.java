import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessGameTest {

    ChessGame cg;

    @BeforeEach
    void setUp() {
        cg = new ChessGame();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAtWithValidPosition() {
        Object res = cg.getAt("A1");
        assertEquals(cg.board[0], res,
                "getAt should return the first object in board"
        );

//        assertEquals(new Figure("white", "K", "A1"), res);
    }

    @Test
    void getAtWIthInvalidPosition() {
//        Object res = cg.getAt("aaaaaa");
//        assertEquals(cg.board[0], res,
//                "getAt should throw an Exception"
//        );
//        try {
//            cg.getAt("aaaaaa");
//        } catch(Exception err) {
//            assertEquals(...);
//        }
        assertThrows(
                IllegalArgumentException.class,
                () -> cg.getAt("A2"),
                "getAt should throw an Exception"
        );
    }
}