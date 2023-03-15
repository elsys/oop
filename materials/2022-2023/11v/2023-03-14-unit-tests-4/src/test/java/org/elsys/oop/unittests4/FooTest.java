package org.elsys.oop.unittests4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FooTest {
    @Mock
    PrintStream ps;

    @InjectMocks
    Foo f;

    @BeforeEach
    void setup() {
//        MockitoAnnotations.openMocks(this);
//        ps = mock(PrintStream.class);
//        f = new Foo(ps);
    }

    @Test
    void test1() {
        ps.println(5);
        verify(ps).println(5);

        when(ps.checkError()).thenReturn(true);
        assertEquals(true, ps.checkError());
    }

    @Test
    void test2() {
        int result = f.bar(15);

        verify(ps).println(15);
        assertEquals(30, result);
    }
}