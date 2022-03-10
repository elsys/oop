public class Cow extends Animal implements IMilkable {
    private int milkQuantity;

    public Cow(int age) {
        super("cow", age);
    }

    public void milk() {
        milkQuantity -= 10;
        System.out.println("Milked 10 milk");
    }
}
