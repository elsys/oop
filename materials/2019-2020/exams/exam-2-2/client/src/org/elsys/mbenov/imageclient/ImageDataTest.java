package org.elsys.mbenov.imageclient;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ImageDataTest {
    private ImageData id;
    @BeforeEach
    void setUp() {
        ArrayList<Long> testList = new ArrayList(){{add(1); add(2); add(3); add(4);}};
        id = new ImageData(1, 1, testList, "Test");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testToString() {
        //ArrayList<Long> testList = new ArrayList(){{add(1); add(2); add(3); add(4);}};
        //id = new ImageData(1, 1, testList, "Test");
        id.width = 5;

        String result = id.toString();

        assertEquals("ImageData{width=1, height=1, data=[1, 2, 3, 4], name='Test'}", result);
    }

    @org.junit.jupiter.api.Test
    void toJSONString() {
        //ArrayList<Long> testList = new ArrayList(){{add(1); add(2); add(3); add(4);}};
        //id = new ImageData(1, 1, testList, "Test");
        String result = id.toJSONString();
        assertEquals("asdf", result);
    }

    @org.junit.jupiter.api.Test
    void fromJSONString() {
    }
}