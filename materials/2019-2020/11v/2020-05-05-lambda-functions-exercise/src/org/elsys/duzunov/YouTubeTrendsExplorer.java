package org.elsys.duzunov;

import java.io.InputStream;
import java.util.*;
import java.util.function.BiPredicate;

public class YouTubeTrendsExplorer {
    private final HashSet<TrendingVideo> trendingVideos = new HashSet<>();

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
        return findIdOfVideoExtremum(
                (video, extremum) -> video.getLikes() < extremum.getLikes()
        );
    }

    public String findIdOfMostLikedLeastDislikedVideo() {
        return findIdOfVideoExtremum(
                (video, extremum) ->
                        video.getLikes() - video.getDislikes() >
                                extremum.getLikes() - extremum.getDislikes()
        );
    }

    private String findIdOfVideoExtremum(
            BiPredicate<TrendingVideo, TrendingVideo> tester
    ) {
        Iterator<TrendingVideo> iterator = trendingVideos.iterator();
        TrendingVideo extrumum = iterator.next();
        while (iterator.hasNext()) {
            TrendingVideo currentVideo = iterator.next();
            if (tester.test(currentVideo, extrumum)) {
                extrumum = currentVideo;
            }
        }
        return extrumum.getId();
    }
}
