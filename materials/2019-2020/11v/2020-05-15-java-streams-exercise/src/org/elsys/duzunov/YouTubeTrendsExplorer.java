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

public class YouTubeTrendsExplorer {
    private final List<TrendingVideo> trendingVideos;

    /**
     * Loads the dataset from the given {@code dataInput} stream.
     */
    public YouTubeTrendsExplorer(InputStream dataInput) {
        try (
                BufferedReader reader =
                     new BufferedReader(new InputStreamReader(dataInput))
        ) {
            trendingVideos = reader.lines()
                    .skip(1)
                    .map(TrendingVideo::createTrendingVideo)
                    .collect(Collectors.toList());
        } catch (IOException exception) {
            throw new IllegalArgumentException(
                    "Could not load dataset",
                    exception
            );
        }
    }

    /**
     * Returns all videos loaded from the dataset.
     **/
    public Collection<TrendingVideo> getTrendingVideos() {
        return Collections.unmodifiableList(trendingVideos);
    }

    public String findIdOfLeastLikedVideo() {
        return trendingVideos.stream()
                .min(Comparator.comparingLong(TrendingVideo::getLikes))
                .get()
                .getId();
    }

    public String findIdOfMostLikedLeastDislikedVideo() {
        return trendingVideos.stream()
                .max(
                        Comparator.comparingLong(
                                video -> video.getLikes() - video.getDislikes()
                        )
                )
                .get()
                .getId();
    }

    public List<String> findDistinctTitlesOfTop3VideosByViews() {
        return trendingVideos.stream()
                .sorted(
                        Comparator.comparingLong(TrendingVideo::getViews)
                                .reversed()
                )
                .distinct()
                .map(TrendingVideo::getTitle)
                .limit(3)
                .collect(Collectors.toList());
    }

    public String findIdOfMostTaggedVideo() {
        return trendingVideos.stream()
                .max(Comparator.comparingInt(video -> video.getTags().size()))
                .get()
                .getId();
    }

    public String findTitleOfFirstVideoTrendingBefore100KViews() {
        return trendingVideos.stream()
                .filter(video -> video.getViews() < 100_000)
                .min(Comparator.comparing(TrendingVideo::getPublishDate))
                .get()
                .getTitle();
    }

    public String findIdOfMostTrendingVideo() {
        Map<String, Long> trendingVideosCountById = trendingVideos.stream()
                .collect(
                        Collectors.groupingBy(
                                TrendingVideo::getId,
                                Collectors.counting()
                        )
                );

        return trendingVideosCountById.entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .get()
                .getKey();
    }
}
