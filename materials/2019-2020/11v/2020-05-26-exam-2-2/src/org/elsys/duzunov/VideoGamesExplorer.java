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

public class VideoGamesExplorer {
    private final List<VideoGame> videoGames;

    /**
     * Loads the dataset from the given {@code dataInput} stream.
     */
    public VideoGamesExplorer(InputStream dataInput) {
        try (
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(dataInput))
        ) {
            videoGames = reader.lines()
                    .skip(1)
                    .map(VideoGame::createVideoGame)
                    .collect(Collectors.toList());
        } catch (IOException exception) {
            throw new IllegalArgumentException(
                    "Could not load dataset",
                    exception
            );
        }
    }

    /**
     * Returns all video games loaded from the dataset.
     **/
    public Collection<VideoGame> getVideoGames() {
        return Collections.unmodifiableList(videoGames);
    }

    public String findNameOfLeastSoldVideoGameInJapan() {
        return videoGames.stream()
                .min(Comparator.comparingInt(VideoGame::getJpSales))
                .get()
                .getName();
    }

    public String findNameOfVideoGameWithLargestSaleDifference() {
        return videoGames.stream()
                .max(
                        Comparator.comparingInt(
                                videoGame -> videoGame.getNaSales() +
                                        videoGame.getEuSales() +
                                        videoGame.getJpSales() -
                                        videoGame.getOtherSales()
                        )
                )
                .get()
                .getName();
    }

    public List<String> findNamesOfTopNVideoGamesBySalesInEurope(int n) {
        return videoGames.stream()
                .sorted(
                        Comparator.comparingInt(VideoGame::getEuSales)
                                .reversed()
                )
                .map(VideoGame::getName)
                .limit(n)
                .collect(Collectors.toList());
    }

    public double findAverageSoldCopiesByPublisher(String publisher) {
//        return videoGames.stream()
//                .filter(videoGame -> videoGame.getPublisher().equals(publisher))
//                .mapToInt(VideoGame::getGlobalSales)
//                .average()
//                .orElse(0);

        return videoGames.stream()
                .filter(videoGame -> videoGame.getPublisher().equals(publisher))
                .collect(Collectors.averagingInt(VideoGame::getGlobalSales));
    }

    public int findRankOfMostSoldVideoGameByPlatformAndGenre(String platform,
                                                             String genre) {
        return videoGames.stream()
                .filter(
                        videoGame -> videoGame.getPlatform().equals(platform) &&
                                videoGame.getGenre().equals(genre)
                )
                .max(Comparator.comparingInt(VideoGame::getNaSales))
                .orElseThrow(IllegalArgumentException::new)
                .getRank();
    }

    public String findPublisherWithMostVideoGamesInYear(int year) {
        Map<String, Long> gamesCountForYearByPublisher = videoGames.stream()
                .filter(
                        videoGame -> !videoGame.getPublisher().equals("N/A") &&
                                !videoGame.getPublisher().equals("Unknown") &&
                                videoGame.getReleaseYear() == year
                )
                .collect(
                        Collectors.groupingBy(
                                VideoGame::getPublisher,
                                Collectors.counting()
                        )
                );

        return gamesCountForYearByPublisher.entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .orElseThrow(IllegalArgumentException::new)
                .getKey();
    }
}
