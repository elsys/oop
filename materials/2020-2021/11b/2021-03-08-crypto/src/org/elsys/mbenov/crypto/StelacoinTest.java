package org.elsys.mbenov.crypto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

// Добавяме имплементацията на Mockito за jUnit от Maven с име и версия org.mockito:mockito-junit-jupiter:3.8.0
// Extend-ваме класа с добавките от Mockito за да може mock-овете да се инициализират и работят
@ExtendWith(MockitoExtension.class)
class StelacoinTest {
    // rand ще бъде фалшива инстанция на Random. Ще има всички негови методи,
    // но можем в тестовете да обявим как да се държат и какво да връщат.
    @Mock
    private Random rand;

    private Stelacoin coin;

    // За да може тестваната инстанция да ползва нашия mock той трябва да може да се подаде отвън.
    // За нашите цели използваме най-опростения вариант на dependency injection - подаване на
    // нужните инстанции като аргументи на конструктура.
    @BeforeEach
    void setUp() {
        coin = new Stelacoin(10, rand);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void initialPrice() {
        assertEquals("Stelacoin", coin.getName());
        assertEquals(10.0, coin.getBasePrice());
        assertEquals(10.0, coin.getPrice());
    }

    @Test
    void invalidBasePrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Stelacoin(-10, rand);
        });
    }

    @Test
    void updatePriceAllowedValues() {
        coin.updatePrice(0, 0);
        assertEquals(10.0, coin.getPrice());

        // Когато бъде извикан методът nextDouble на rand той ще връща 7.0.
        // Така можем да определим очаквания резултат от изпълнението на
        // метода на нашия клас(ако той е имплементиран правилно).
        Mockito.when(rand.nextDouble()).thenReturn(7.0);

        coin.updatePrice(1, 0);
        assertEquals(3.0, coin.getPrice()); // 10 - 1*7 + 0*7 = 3

        Mockito.when(rand.nextDouble()).thenReturn(5.0);

        coin.updatePrice(0, 1);
        assertEquals(8.0, coin.getPrice()); // 3 - 0*5 + 1*5 = 8

        coin.updatePrice(1, 2);
        assertEquals(13.0, coin.getPrice()); // 8 - 1*5 + 2*5 = 13
    }
}