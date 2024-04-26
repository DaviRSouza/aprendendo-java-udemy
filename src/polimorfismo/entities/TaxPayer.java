package polimorfismo.entities;

public abstract class TaxPayer {

    private String name;
    private Double anualIncome;

    public TaxPayer() {
    }

    public TaxPayer(String name, Double anualIncome) {
        super();
        this.name = name;
        this.anualIncome = anualIncome;
    }

    public String getName() {
        return name;
    }

    public Double getAnualIncome() {
        return anualIncome;
    }

    public abstract double tax();
}
