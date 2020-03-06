public abstract class Product {
    int quantity;
    Product() {
        this(0);
    }
    Product(int quantity) {
        this.quantity = quantity;
    }

    abstract void print_information();
}
