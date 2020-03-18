public class Virus implements Comparable {
    public String name;

    @Override
    public boolean equals(Object o) {
        if(o instanceof Virus) {
            if(((Virus) o).name.equals(name)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Virus) {
            return ((Virus)o).name.compareTo(name);
        }
        return -1;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    /*public boolean equals(Virus v) {
        return true;
    }*/
}
