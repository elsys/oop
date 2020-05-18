package org.elsys.duzunov;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

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
                Comparator.comparingLong(TrendingVideo::getViews).reversed();
        trendingVideos.sort(viewsComparator);
        HashSet<TrendingVideo> uniqueVideos = new HashSet<>(trendingVideos);
        ArrayList<TrendingVideo> sortedVideos = new ArrayList<>(uniqueVideos);
        sortedVideos.sort(viewsComparator);

        List<TrendingVideo> top3 = take(sortedVideos, 3);
        return map(top3, TrendingVideo::getTitle);
    }

    public String findIdOfMostTaggedVideo() {
        return findMaximum(
                trendingVideos,
                Comparator.comparingInt(video -> video.getTags().size())
        ).getId();
    }

    public String findTitleOfFirstVideoTrendingBefore100KViews() {
        var lessThan100KViews =
                filter(trendingVideos, video -> video.getViews() < 100_000);

        return findMinimum(
                lessThan100KViews,
                Comparator.comparing(TrendingVideo::getPublishDate)
        ).getTitle();
    }

    public String findIdOfMostTrendingVideo() {
        HashMap<String, Integer> trendingVideosCountById =
                groupBy(
                        trendingVideos,
                        TrendingVideo::getId,
                        video -> 1,
                        Integer::sum
                );

        return findMaximum(
                trendingVideosCountById.entrySet(),
                Comparator.comparingInt(Map.Entry::getValue)
        ).getKey();
    }

    private <T, K, V> HashMap<K, V> groupBy(Iterable<T> elements,
                                            Function<T, K> keyMapper,
                                            Function<T, V> valueMapper,
                                            BiFunction<V, V, V> combiner) {
        HashMap<K, V> groups = new HashMap<>();
        for (T element : elements) {
            K key = keyMapper.apply(element);
            V value = valueMapper.apply(element);
            groups.merge(key, value, combiner);
        }
        return groups;
    }

    private <T> List<T> filter(Iterable<T> elements, Predicate<T> tester) {
        ArrayList<T> filtered = new ArrayList<>();
        for (T element : elements) {
            if (tester.test(element)) {
                filtered.add(element);
            }
        }
        return filtered;
    }

    private <T, R> List<R> map(Iterable<T> elements, Function<T, R> mapper) {
        ArrayList<R> mapped = new ArrayList<>();
        for (T element : elements) {
            mapped.add(mapper.apply(element));
        }
        return mapped;
    }

    private <T> List<T> take(Iterable<T> elements, int n) {
        ArrayList<T> firstN = new ArrayList<>();
        Iterator<T> iterator = elements.iterator();
        for (int i = 0; iterator.hasNext() && i < n; ++i) {
            firstN.add(iterator.next());
        }
        return firstN;
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
