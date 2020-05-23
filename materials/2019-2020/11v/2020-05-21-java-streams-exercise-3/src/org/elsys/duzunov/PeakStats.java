package org.elsys.duzunov;

import java.io.InputStream;
import java.util.Collection;
import java.util.List;

public class PeakStats {
    /**
     * Loads the dataset from the given {@code dataInput} stream.
     */
    public PeakStats(InputStream dataInput) {
        throw new UnsupportedOperationException("Method not yet implemented");
    }

    /**
     * Returns all peaks loaded from the dataset.
     **/
    public Collection<Peak> getPeaks() {
        return null;
    }

    /**
     * @return - the height of the shortest peak that has never been ascended
     */
    public double shortestNotAscended() {
        throw new UnsupportedOperationException("Method not yet implemented");
    }

    /**
     * How many times in average was a peak in Top N ascended. For example,
     * averageAscentsInTopN(10) should return the average number of times a peak
     * from the highest 10 has been ascended.
     *
     * @return - the first n peaks to include in the statistics
     */
    public double averageAscentsInTopN(int n) {
        throw new UnsupportedOperationException("Method not yet implemented");
    }

    /**
     * If there are peaks with equal prominence, we consider the supplied one as
     * higher.
     *
     * @param prominence - the prominence in meters
     * @return - the position where a peak with the given prominence would rank
     */
    public long getPositionByProminence(double prominence) {
        throw new UnsupportedOperationException("Method not yet implemented");
    }

    /**
     * @param year - year of ascent
     * @return - the highest peak ascended in the given year
     * @throws IllegalArgumentException if there are no peaks ascended in the
     * given year
     */
    public Peak getHighestAscentByYear(int year) {
        throw new UnsupportedOperationException("Method not yet implemented");
    }

    /**
     * @return - the list of peaks that are not part of the Himalayas
     */
    public List<String> getNonHimalayaNamesByProminence() {
        throw new UnsupportedOperationException("Method not yet implemented");
    }

    /**
     * Returns the name of the mountain range that has the most peaks in Top N.
     */
    public String getRangeWithMostPeaks(int n) {
        throw new UnsupportedOperationException("Method not yet implemented");
    }
}
