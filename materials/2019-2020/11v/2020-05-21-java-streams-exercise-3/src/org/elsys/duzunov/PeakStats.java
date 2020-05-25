package org.elsys.duzunov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PeakStats {
    private final List<Peak> peaks;

    /**
     * Loads the dataset from the given {@code dataInput} stream.
     */
    public PeakStats(InputStream dataInput) {
        try (
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(dataInput))
        ) {
            peaks = reader.lines()
                    .map(Peak::createPeak)
                    .collect(Collectors.toList());
        } catch (IOException exception) {
            throw new IllegalArgumentException(
                    "Could not load dataset",
                    exception
            );
        }
    }

    /**
     * Returns all peaks loaded from the dataset.
     **/
    public Collection<Peak> getPeaks() {
        return Collections.unmodifiableList(peaks);
    }

    /**
     * @return - the height of the shortest peak that has never been ascended
     */
    public double shortestNotAscended() {
//        return peaks.stream()
//                .filter(peak -> peak.getYearOfFirstAscent() == 0)
//                .min(Comparator.comparingDouble(Peak::getHeight))
//                .get()
//                .getHeight();

        return peaks.stream()
                .filter(peak -> peak.getYearOfFirstAscent() == 0)
                .mapToDouble(Peak::getHeight)
                .min()
                .getAsDouble();
    }

    /**
     * How many times in average was a peak in top N ascended. For example,
     * averageAscentsInTopN(10) should return the average number of times a peak
     * from the highest 10 has been ascended.
     *
     * @param n - the first n peaks to include in the statistics
     */
    public double averageAscentsInTopN(int n) {
//        return peaks.stream()
//                .sorted(Comparator.comparingInt(Peak::getPosition))
//                .mapToInt(Peak::getTotalAscents)
//                .limit(n)
//                .average()
//                .getAsDouble();

        return peaks.stream()
                .sorted(Comparator.comparingInt(Peak::getPosition))
                .limit(n)
                .collect(Collectors.averagingInt(Peak::getTotalAscents));
    }

    /**
     * If there are peaks with equal prominence, we consider the supplied one as
     * higher.
     *
     * @param prominence - the prominence in meters
     * @return - the position where a peak with the given prominence would rank
     */
    public long getPositionByProminence(double prominence) {
        return peaks.stream()
                .sorted(
                        Comparator.comparingDouble(Peak::getProminence)
                                .reversed()
                )
                .takeWhile(peak -> peak.getProminence() != prominence)
                .count() + 1;
    }

    /**
     * @param year - year of ascent
     * @return - the highest peak ascended in the given year
     * @throws IllegalArgumentException if there are no peaks ascended in the
     * given year
     */
    public Peak getHighestAscentByYear(int year) {
        return peaks.stream()
                .filter(peak -> peak.getYearOfFirstAscent() == year)
                .max(Comparator.comparingDouble(Peak::getHeight))
                .orElseThrow(IllegalArgumentException::new);
    }

    /**
     * @return - the list of names of all peaks that are not part of the
     * Himalayas sorted by prominence in descending order
     */
    public List<String> getNonHimalayaNamesByProminence() {
        return peaks.stream()
                .filter(peak -> !peak.getRange().contains("Himalaya"))
                .sorted(
                        Comparator.comparingDouble(Peak::getProminence)
                                .reversed()
                )
                .map(Peak::getName)
                .collect(Collectors.toList());
    }

    /**
     * Returns the name of the mountain range that has the greatest number of
     * peaks in top N.
     */
    public String getRangeWithGreatestNumberOfPeaks(int n) {
        Map<String, Long> peaksCountByRange = peaks.stream()
                .sorted(Comparator.comparingInt(Peak::getPosition))
                .limit(n)
                .collect(
                        Collectors.groupingBy(
                                Peak::getRange,
                                Collectors.counting()
                        )
                );

        return peaksCountByRange.entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .get()
                .getKey();
    }
}
