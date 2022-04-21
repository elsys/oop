import java.util.Objects;

public class Package {
    public String sender;
    public long data;

    public Package(String sender, long data) {
        this.sender = sender;
        this.data = data;
    }

    // Generated with alt+insert -> equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package aPackage = (Package) o;
        return data == aPackage.data && Objects.equals(sender, aPackage.sender);
    }
}
