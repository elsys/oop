abstract class Animal {
  private String species;

  public Animal(String species) {
    this.species = species;
  }

  public String getSpecies() {
    return species;
  }

  public abstract void makeSound();
}