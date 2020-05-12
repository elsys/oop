package org.elsys.duzunov;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;

public class YouTubeTrendsExplorer {
    private final ArrayList<TrendingVideo> trendingVideos = new ArrayList<>();

    /**
     * Loads the dataset from the given {@code dataInput} stream.
     */
    public YouTubeTrendsExplorer(InputStream dataInput) {
        Scanner scanner = new Scanner(dataInput).useDelimiter("\n");
        scanner.next();
        while (scanner.hasNext()) {
            String line = scanner.next();
            trendingVideos.add(TrendingVideo.createTrendingVideo(line));
        }
    }

    /**
     * Returns all videos loaded from the dataset.
     **/
    public Collection<TrendingVideo> getTrendingVideos() {
        return trendingVideos;
    }

    public String findIdOfLeastLikedVideo() {
//        return findMinimum(
//                trendingVideos,
//                (video1, video2) ->
//                        Long.compare(video1.getLikes(), video2.getLikes())
//        ).getId();
//        return findMinimum(
//                trendingVideos,
//                Comparator.comparingLong(video -> video.getLikes())
//        ).getId();

        return findMinimum(
                trendingVideos,
                Comparator.comparingLong(TrendingVideo::getLikes)
        ).getId();
    }

    public String findIdOfMostLikedLeastDislikedVideo() {
        return findMaximum(
                trendingVideos,
                Comparator.comparingLong(
                        video -> video.getLikes() - video.getDislikes()
                )
        ).getId();
    }

    public List<String> findDistinctTitlesOfTop3VideosByViews() {
        Comparator<TrendingVideo> viewsComparator =
                Comparator.comparingLong(TrendingVideo::getViews);
        trendingVideos.sort(viewsComparator);
        HashSet<TrendingVideo> uniqueVideos = new HashSet<>(trendingVideos);
        ArrayList<TrendingVideo> sortedVideos = new ArrayList<>(uniqueVideos);
        sortedVideos.sort(viewsComparator);

        ArrayList<String> top3 = new ArrayList<>();
        Iterator<TrendingVideo> iterator = sortedVideos.iterator();
        for (int i = 0; iterator.hasNext() && i < 3; ++i) {
            top3.add(iterator.next().getTitle());
        }
        return top3;
    }

    private <T> T findMinimum(Iterable<T> elements, Comparator<T> comparator) {
        return findExtremum(
                elements,
                (element1, element2) ->
                        comparator.compare(element1, element2) < 0
        );
    }

    private <T> T findMaximum(Iterable<T> elements, Comparator<T> comparator) {
        return findMinimum(elements, comparator.reversed());
    }

    private String findIdOfVideoExtremum(
            BiPredicate<TrendingVideo, TrendingVideo> tester
    ) {
        return findExtremum(trendingVideos, tester).getId();
    }

    private static <T> T findExtremum(
            Iterable<T> elements,
            BiPredicate<T, T> tester
    ) {
        Iterator<T> iterator = elements.iterator();
        T extrumum = iterator.next();
        while (iterator.hasNext()) {
            T currentElement = iterator.next();
            if (tester.test(currentElement, extrumum)) {
                extrumum = currentElement;
            }
        }
        return extrumum;
    }
}
