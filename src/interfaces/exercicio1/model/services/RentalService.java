package interfaces.exercicio1.model.services;

import interfaces.exercicio1.model.entities.CarRental;
import interfaces.exercicio1.model.entities.Invoice;

import java.time.Duration;

public class RentalService {

    private Double pricePerHour;
    private Double pricePerDay;

    private TaxService taxService;

    public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental) {

        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        double hours = minutes / 60.0;

        double basicPayement;
        if (hours <= 12.0)
            basicPayement = pricePerHour * Math.ceil(hours);
        else
            basicPayement = pricePerDay * Math.ceil(hours / 24.0);

        double tax = taxService.tax(basicPayement);

        carRental.setInvoice(new Invoice(basicPayement, tax));
    }
}
