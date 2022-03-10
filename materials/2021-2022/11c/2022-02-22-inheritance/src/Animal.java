public abstract class Animal {
    private String species;
    private int age;

    public Animal(String species, int age) {
        this.species = species;
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }
}
