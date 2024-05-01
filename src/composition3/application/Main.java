package composition3.application;

import composition3.model.entities.Client;
import composition3.model.entities.Order;
import composition3.model.entities.OrderItem;
import composition3.model.entities.Product;
import composition3.model.enums.OrderStatus;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter client data");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth Date (DD/MM/YYYY): ");
        String birthDate = sc.next();
        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order status: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());
        System.out.print("How many items to this order? ");
        int itemsQuantity = sc.nextInt();

        Order order = new Order(status, client);

        for(int i = 1; i <= itemsQuantity; i++) {
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            Product product = new Product(productName, productPrice);

            System.out.print("Quantity: ");
            Integer quantity = sc.nextInt();

            order.addItem(new OrderItem(quantity, productPrice, product));
        }

        System.out.println("\nORDER SUMMARY: ");
        System.out.println(order);
    }
}
