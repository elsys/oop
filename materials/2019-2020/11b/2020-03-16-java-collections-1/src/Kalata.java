public class Kalata implements Comparable {
    public boolean hasPants;

    @Override
    public boolean equals(Object o) {
        if(o instanceof Kalata) {
            if(((Kalata) o).hasPants == hasPants) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Object o) {
        if(equals(o)) {
            return 0;
        }
        return 1;
    }

    @Override
    public int hashCode() {
        if(hasPants) {
            return 10;
        }
        return 5;
    }
}
