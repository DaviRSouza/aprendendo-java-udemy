package precificacaoProdutos.entities;

public class ImportedProduct extends Product{
    private final Double customsFee;

    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public Double getCustomsFee() {
        return customsFee;
    }

    public Double totalPrice() {
        return price + customsFee;
    }

    @Override
    public final String priceTag() {
        return getName() + " $ " + totalPrice() + " (Customs fee: $ " + getCustomsFee() + ")";
    }
}
