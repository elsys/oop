import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    @InjectMocks
    private UserController uc;

    @Mock
    private UserHandler uh;

    @BeforeEach
    void setUp() {
        uc = new UserController();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void usernameTooShort() {
        assertEquals(
                false,
                uc.createUser("abc", "testPass")
        );
    }

    @Test
    void passwordTooShort() {
        assertEquals(
                false,
                uc.createUser("testUser", "abc")
        );
    }

    @Test
    void createUserThroughHandler() throws Exception {
//        UserHandler uh = Mockito.mock(UserHandler.class);
        Mockito
            .when(
                uh.createUser(
                    Mockito.anyString(),
                    Mockito.anyString()
                )
            )
            .thenReturn(true)
            .thenThrow(new Exception())
            .thenReturn(false)
            .thenReturn(false);

        Mockito
            .when(
                uh.createUser(
                    "ERROR USER",
                    "testPass"
                )
            )
            .thenThrow(new RuntimeException());

        uc.userHandler = uh;
        boolean res = uc.createUser("testUser", "testPass");

        Mockito.verify(uh)
            .createUser("testUser", "testPass");
        assertEquals(true, res);



        assertThrows(
            RuntimeException.class,
            new Executable() {
                public void execute() throws Throwable {
                    uc.createUser("ERROR USER", "testPass");
                }
            }
        );
    }
}