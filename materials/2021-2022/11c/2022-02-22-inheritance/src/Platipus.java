public class Platipus extends Animal implements IMilkable {
    private int milkQuantity;

    public Platipus(int age) {
        super("Platypus", age);
    }

    @Override
    public void milk() {
        milkQuantity -= 5;
        System.out.println("Milked 5 milk");
    }
}
