package org.elsys_bg;

import lombok.Data;

import java.util.List;
import java.util.spi.CalendarDataProvider;

@Data
public class PersonService {
    private final DataProvider dataProvider;

    public int countPersons() {
        return dataProvider.getAllPersons().size();
    }
}
