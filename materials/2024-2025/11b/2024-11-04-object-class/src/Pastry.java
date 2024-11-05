import java.util.Objects;

public class Pastry {
    private String name;
    private boolean hasCheese;

    public Pastry(String name, boolean hasCheese) {
        this.name = name;
        this.hasCheese = hasCheese;
    }

    public String getName() {
        return name;
    }

    public boolean getHasCheese() {
        return hasCheese;
    }

    @Override
    public String toString() {
        return "Pastry{" +
                "name='" + name + '\'' +
                ", hasCheese=" + hasCheese +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pastry pastry = (Pastry) o;
        return hasCheese == pastry.hasCheese &&
//                Objects.equals(name, pastry.name);
                name.equals(pastry.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hasCheese);
    }
}
