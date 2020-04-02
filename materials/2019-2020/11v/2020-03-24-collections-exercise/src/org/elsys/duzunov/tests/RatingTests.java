package org.elsys.duzunov.tests;

import org.elsys.duzunov.BiasedRating;
import org.elsys.duzunov.LengthRating;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@DisplayName("Rating")
public class RatingTests {
    @Test
    @DisplayName("returns top candidates based on length")
    public void topByLength() {
        var operators = Arrays.asList("a1", "vivacom", "mtel", "telenor");
        var lengthRating = new LengthRating(operators);
        var top3 = new String[] { "a1", "mtel", "vivacom" };
        Assertions.assertArrayEquals(top3, lengthRating.top(3).toArray());
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> lengthRating.top(10));
    }

    @Test
    @DisplayName("returns top candidates based on preference list")
    public void topByPreferenceList() {
        var operators = Arrays.asList("a1", "vivacom", "mtel", "telenor");
        var preferenceList = Arrays.asList("telenor", "vivacom");
        var biasedRating = new BiasedRating(operators, preferenceList);
        var top3 = new String[] { "telenor", "vivacom", "a1" };
        Assertions.assertArrayEquals(top3, biasedRating.top(3).toArray());
    }
}
