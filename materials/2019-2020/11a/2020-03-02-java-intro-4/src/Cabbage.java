public class Cabbage extends Product implements ISellable {
    Cabbage() {
        super(1);
    }

    @Override
    void print_information() {
        System.out.println("I am tasty");
    }

    @Override
    public void sell() {
        System.out.println("Selling " + quantity + " cabbages...");
    }
}
