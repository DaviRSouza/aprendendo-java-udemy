package manipulacaoDeArquivo.exercicio7.entities;

import java.util.Objects;

public record Products(String name, double price, int quantity) {

    public double totalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return name + "," + totalPrice();
    }
}
