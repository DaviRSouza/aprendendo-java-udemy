package precificacaoProdutos.application;

import precificacaoProdutos.entities.ImportedProduct;
import precificacaoProdutos.entities.Product;
import precificacaoProdutos.entities.UsedProduct;

import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char type = sc.next().toLowerCase().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            switch (type) {
                case 'c':
                    products.add(new Product(name, price));
                    break;
                case 'u':
                    System.out.print("Manufacture date (DD/MM/YYYY): ");
                    String manufactureDate = sc.next();
                    products.add(new UsedProduct(name, price, manufactureDate));
                    break;
                case 'i':
                    System.out.print("Customs fee: ");
                    double customsFee = sc.nextDouble();
                    products.add(new ImportedProduct(name, price, customsFee));
                    break;
                default:
                    System.out.println("Invalid type");
            }
        }
        System.out.println("\nPRICE TAGS:");
        for(Product product : products){
            System.out.println(product.priceTag());
        }
    }
}
