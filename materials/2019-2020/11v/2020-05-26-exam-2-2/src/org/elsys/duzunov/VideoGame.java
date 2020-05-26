package org.elsys.duzunov;

public final class VideoGame {
    private static final int RANK = 0;
    private static final int NAME = 1;
    private static final int PLATFORM = 2;
    private static final int RELEASE_YEAR = 3;
    private static final int GENRE = 4;
    private static final int PUBLISHER = 5;
    private static final int NA_SALES = 6;
    private static final int EU_SALES = 7;
    private static final int JP_SALES = 8;
    private static final int OTHER_SALES = 9;
    private static final int GLOBAL_SALES = 10;

    private final int rank;
    private final String name;
    private final String platform;
    private final int releaseYear;
    private final String genre;
    private final String publisher;
    private final int naSales;
    private final int euSales;
    private final int jpSales;
    private final int otherSales;
    private final int globalSales;

    private VideoGame(int rank,
                      String name,
                      String platform,
                      int releaseYear,
                      String genre,
                      String publisher,
                      int naSales,
                      int euSales,
                      int jpSales,
                      int otherSales,
                      int globalSales) {
        this.rank = rank;
        this.name = name;
        this.platform = platform;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.publisher = publisher;
        this.naSales = naSales;
        this.euSales = euSales;
        this.jpSales = jpSales;
        this.otherSales = otherSales;
        this.globalSales = globalSales;
    }

    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public String getPlatform() {
        return platform;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getNaSales() {
        return naSales;
    }

    public int getEuSales() {
        return euSales;
    }

    public int getJpSales() {
        return jpSales;
    }

    public int getOtherSales() {
        return otherSales;
    }

    public int getGlobalSales() {
        return globalSales;
    }

    public static VideoGame createVideoGame(String line) {
        String[] tokens = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

        int rank = Integer.parseInt(tokens[RANK]);
        String name = tokens[NAME];
        String platform = tokens[PLATFORM];

        String releaseYearString = tokens[RELEASE_YEAR];
        int releaseYear = releaseYearString.equals("N/A") ?
                0 :
                Integer.parseInt(releaseYearString);

        String genre = tokens[GENRE];
        String publisher = tokens[PUBLISHER];
        int naSales = parseSales(tokens[NA_SALES]);
        int euSales = parseSales(tokens[EU_SALES]);
        int jpSales = parseSales(tokens[JP_SALES]);
        int otherSales = parseSales(tokens[OTHER_SALES]);
        int globalSales = parseSales(tokens[GLOBAL_SALES]);

        return new VideoGame(
                rank,
                name,
                platform,
                releaseYear,
                genre,
                publisher,
                naSales,
                euSales,
                jpSales,
                otherSales,
                globalSales
        );
    }

    private static int parseSales(String sales) {
        return (int) (Double.parseDouble(sales) * 1_000_000);
    }
}
