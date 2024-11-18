import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order {
    private List<Product> products;

    public Order(List<Product> products) {
        this.products = products;
    }

    public Order() {
        this.products = new ArrayList<>();
    }

    public void addProducts(Product... products) {
        this.products.addAll(Arrays.asList(products));
    }
    private double mySum(double e1, double e2) {
        return e1 + e2;
    }
    public double getTotal() {
        return products.stream()
                .map(Product::calculatePrice)
                .reduce(0d, this::mySum);
    }

    @Override
    public String toString() {
        return "Order{" +
                "products=" + products +
                '}';
    }
}
