import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MainTest {
    @Test
    void forEach() {
        Main testMain = new Main();
        Consumer testFn = spy(
                new Consumer() {
                    @Override
                    public void accept(Object o) {
                        System.out.println(o);
                    }
                }
        );
        Consumer testFn2 = mock(Consumer.class);

        testMain.forEach(testFn2);

//        assertCalled(testFn.accept, 123);
        verify(testFn2).accept(123);
        verify(testFn2).accept(456);
        verify(testFn2).accept(789);
    }

    @Test
    void foo() {
        Main testMain = new Main();

        Function testfn = spy(new Function() {
            @Override
            public Object apply(Object o) {
                System.out.println("Spy called with " + o);
                return 200;
            }
        });
        Function testFn2 = mock(Function.class);

        doReturn(100).when(testfn).apply(123);
//        Mockito.when(testfn.apply(13)).thenReturn(100);
        doReturn(100).when(testFn2).apply(anyInt());
//        Mockito.when(testFn2.apply(123)).thenReturn(100);

        assertEquals(200, testMain.foo(testFn2));
        verify(testFn2).apply(123);
    }
}