import java.util.Scanner;

public class OrderManagement {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        Order order = new Order();
        for (String productString : args) {
            String[] product = productString.split(",");
            Product product1 = new Product(product[0], Double.parseDouble(product[1]), Integer.parseInt(product[2]));
            order.addProducts(product1);
        }
        int i = scanner.nextInt(16);
        scanner.skip();
        System.out.println(i);
        System.out.println(order);
        System.out.printf("Total: %.1f ", order.getTotal());
    }


}
