import java.util.Objects;

public class Virus {
    String name;
    String countryOfOrigin;
    int infected;
    boolean hasTreatment;

    public Virus(String name, String countryOfOrigin, int infected, boolean hasTreatment) {
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;
        this.infected = infected;
        this.hasTreatment = hasTreatment;
    }

    @Override
    public String toString() {
        return "Virus{" +
                "name='" + name + '\'' +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                ", infected=" + infected +
                ", hasTreatment=" + hasTreatment +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Virus virus = (Virus) o;
        return infected == virus.infected &&
                hasTreatment == virus.hasTreatment &&
                Objects.equals(name, virus.name) &&
                Objects.equals(countryOfOrigin, virus.countryOfOrigin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, countryOfOrigin, infected, hasTreatment);
    }
}
