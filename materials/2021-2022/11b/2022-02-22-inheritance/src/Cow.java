public class Cow
        extends Animal
        implements IMilkable
{
    private int milkQuantity = 100;

    public Cow(int age) {
        super("cow", age);
    }

    @Override
    public void milk() {
        milkQuantity -= 10;
        System.out.println("Milked 10 milk from the cow");
    }
}
