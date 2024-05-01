package composition3.model.entities;

import composition3.model.enums.OrderStatus;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Instant moment;
    private OrderStatus status;
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private Client client;

    private final List<OrderItem> items = new ArrayList<>();

    public Order() {
    }

    public Order(OrderStatus status, Client client) {
        this.status = status;
        this.client = client;
        this.moment = Instant.now();
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public Double total() {
        Double sum = 0.0;
        for (OrderItem c : items) {
            sum += c.subtotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ").append(dtf.format(moment.atZone(ZoneId.systemDefault())));
        sb.append("\nOrder Status: ").append(getStatus());
        sb.append("\nClient: ").append(client);
        sb.append("\nOrder items: ");
        for (OrderItem c : items) {
            sb.append("\n").append(c);
        }
        sb.append("\nTotal price: $").append(String.format("%.2f", total()));

        return sb.toString();
    }
}
