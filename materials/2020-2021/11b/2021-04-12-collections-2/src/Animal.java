import java.util.Objects;

public class Animal {
    String species; // vid
    String family; // semeistvo
    String order; // rod
    String domain;

    public Animal(String species, String family, String order) {
        this.species = species;
        this.family = family;
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(species, animal.species) &&
                Objects.equals(family, animal.family) &&
                Objects.equals(order, animal.order) &&
                Objects.equals(domain, animal.domain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, family, order);
        //return 42;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", family='" + family + '\'' +
                ", order='" + order + '\'' +
                '}';
    }
}
