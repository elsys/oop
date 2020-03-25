import java.util.Objects;

public class Temple {
    public String templeName;
    public String religion;
    public int followers;
    public boolean needsCandles;

    public Temple(String templeName, String religion, int followers, boolean needsCandles) {
        this.templeName = templeName;
        this.religion = religion;
        this.followers = followers;
        this.needsCandles = needsCandles;
    }

    @Override
    public String toString() {
        return "Temple{" +
                "templeName='" + templeName + '\'' +
                ", religion='" + religion + '\'' +
                ", followers=" + followers +
                ", needsCandles=" + needsCandles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Temple temple = (Temple) o;
        return followers == temple.followers &&
                needsCandles == temple.needsCandles &&
                Objects.equals(templeName, temple.templeName) &&
                Objects.equals(religion, temple.religion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(templeName, religion, followers, needsCandles);
    }
}
