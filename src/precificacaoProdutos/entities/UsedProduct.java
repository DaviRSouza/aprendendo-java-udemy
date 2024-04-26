package precificacaoProdutos.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product {

    private final LocalDate manufactureDate;

    public UsedProduct(String name, Double price, String manufactureDate) {
        super(name, price);
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.manufactureDate = LocalDate.parse(manufactureDate, inputFormatter);
    }

    public String getManufactureDate() {
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return manufactureDate.format(outputFormatter);
    }

    @Override
    public final String priceTag() {
        return getName() + " (used) $ " + String.format("%.2f", getPrice()) + " (Manufacture date: " + getManufactureDate() + ")";
    }
}
