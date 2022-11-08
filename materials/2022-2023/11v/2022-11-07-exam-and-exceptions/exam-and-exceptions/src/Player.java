public abstract class Player extends Object {
    protected String name;
    protected int age;
    protected String country;
    protected int points;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public int getPoints() {
        return points;
    }

    public Player(String name, int age, String country, int points) {
        this.name = name;
        this.age = age;
        this.country = country;
        this.points = points;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + "'" +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", points=" + points +
                '}';
    }
}
