public class Dog implements Comparable {
    public String name;
    public int age;
    public boolean hasLegs;

    public Dog(String name, int age, boolean hasLegs) {
        this.name = name;
        this.age = age;
        this.hasLegs = hasLegs;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isHasLegs() {
        return hasLegs;
    }

    @Override
    public int compareTo(Object o) {
        if(o.getClass() != getClass()) return -1;
        Dog d = (Dog)o;

//        if(this.age > d.age) return 1;
//        if(this.age < d.age) return -1;

//        return 0;

//        return this.age - d.age;
//        return Integer.compare(this.age, d.age);
        int ageComparison = Integer.compare(this.age, d.age);
        if(ageComparison != 0) return ageComparison;

        return this.name.compareTo(d.name);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hasLegs=" + hasLegs +
                '}';
    }
}
