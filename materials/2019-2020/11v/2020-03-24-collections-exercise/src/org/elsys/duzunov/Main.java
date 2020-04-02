package org.elsys.duzunov;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> operatorsList = Arrays.asList(
                "a1", "telenor", "mtel", "vivacom"
        );
        LengthRating lengthRating = new LengthRating(operatorsList);
        var top3 = lengthRating.top(3);
        for (var candidate : top3) {
            System.out.println(candidate);
        }
        for (var candidate : operatorsList) {
            System.out.println(candidate);
        }

        List<String> preferredCandidates = Arrays.asList("telenor", "a1");
        BiasedRating biasedRating = new BiasedRating(
                operatorsList, preferredCandidates
        );
        var biasedTop3 = biasedRating.top(3);
        for (var candidate : biasedTop3) {
            System.out.println(candidate);
        }
    }
}
