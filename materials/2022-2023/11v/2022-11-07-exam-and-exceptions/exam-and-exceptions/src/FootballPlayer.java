public class FootballPlayer extends Player {
    private int games;
    private int goals;
    private String preferredPosition;

    public int getGames() {
        return games;
    }

    public int getGoals() {
        return goals;
    }

    public String getPreferredPosition() {
        return preferredPosition;
    }

    public FootballPlayer(String name, int age, String country, int points, int games, int goals, String preferredPosition) {
        super(name, age, country, points);
        this.games = games;
        this.goals = goals;
        this.preferredPosition = preferredPosition;
    }

    @Override
    public String toString() {
        return "FootballPlayer{" +
                "games=" + games +
                ", goals=" + goals +
                ", preferredPosition='" + preferredPosition + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", points=" + points +
                '}';
    }
}
