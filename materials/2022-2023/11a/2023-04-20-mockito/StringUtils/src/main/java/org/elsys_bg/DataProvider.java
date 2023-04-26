package org.elsys_bg;

import java.util.List;

import static org.elsys_bg.Gender.*;

public class DataProvider {
    private final List<Person> persons = List.of(
            Person.builder().name("Ivan").gender(ANDROGYNOUS).build(),
            Person.builder().name("Petkan").gender(HELICOPTER).build(),
            Person.builder().name("Stoqn").gender(DEMIBOY).build()
    );
    public List<Person> getAllPersons() {
        return persons;
    }

    public List<Person> getAllWithName(String name) {
        return persons.stream()
                .filter(person -> person.getName().contains(name))
                .toList();
    }

    public List<Person> getGenders(Gender gender) {
        return persons.stream()
                .filter(person -> gender.equals(person.getGender()))
                .toList();
    }
}
