package org.elsys_bg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PersonServiceTest {
    @Spy
    DataProvider dataProvider;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void countPersons() {
        DataProvider provider = new DataProvider();
        PersonService personService = new PersonService(provider);

        int i = personService.countPersons();

        assertEquals(3, i);
    }

    @Test
    void countPersons_withCount0() {
        DataProvider provider = new DataProvider(){
            @Override
            public List<Person> getAllPersons() {
                return emptyList();
            }
        };
        PersonService personService = new PersonService(provider);

        int i = personService.countPersons();

        assertTrue(i == 0);
    }

    @Test
    void countPersons_mockito() {
        DataProvider dataProvider = mock(DataProvider.class);
        when(dataProvider.getAllPersons())
                .thenReturn(emptyList())
                .thenReturn(null);
        PersonService personService = new PersonService(dataProvider);

        int i = personService.countPersons();

        assertTrue(i == 0);

        assertThrows(NullPointerException.class, personService::countPersons);
    }

    @Test
    void countPersons_methodCalled() {
        PersonService personService = new PersonService(dataProvider);

        int i = personService.countPersons();

        assertTrue(i == 3);
        verify(dataProvider, times(1)).getAllPersons();
    }

}