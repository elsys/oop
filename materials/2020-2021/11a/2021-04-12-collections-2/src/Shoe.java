import java.util.Objects;

public class Shoe implements Comparable {
    int size;
    String brand;
    String colour;

    public Shoe(int size, String brand, String colour) {
        this.size = size;
        this.brand = brand;
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Shoe{" +
                "size=" + size +
                ", brand='" + brand + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shoe shoe = (Shoe) o;
        return size == shoe.size && Objects.equals(brand, shoe.brand) && Objects.equals(colour, shoe.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, brand, colour);
    }

    @Override
    public int compareTo(Object o) {
        if(o == null) return -1;

        return o.hashCode() - hashCode();
    }
}
