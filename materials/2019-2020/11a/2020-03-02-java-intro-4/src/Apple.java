public class Apple extends Product implements ISellable {
    Apple() {
        super(1);
    }

    Apple(int quantity) {
        super(quantity);
    }

    @Override
    void print_information() {
        System.out.println("It is I, Apple!");
    }

    @Override
    public void sell() {
        System.out.println("Selling " + quantity + " apples...");
    }
}
