package interfaces.exercicio1.application;

import interfaces.exercicio1.model.entities.CarRental;
import interfaces.exercicio1.model.entities.Vehicle;
import interfaces.exercicio1.model.services.BrazilTaxService;
import interfaces.exercicio1.model.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import static java.util.FormatProcessor.FMT;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Entre com os dados do aluguel");
        System.out.print("Modelo do carro: ");
        String carModel = sc.nextLine();

        System.out.print("Retirada (dd/MM/yyy hh:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);

        System.out.print("Retorno (dd/MM/yyy hh:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);

        CarRental cr = new CarRental(start, finish, new Vehicle(carModel));

        System.out.print("Entre com o preço por hora: ");
        double pricePerHour = sc.nextDouble();
        System.out.print("Entre com o preço por dia: ");
        double pricePerDay = sc.nextDouble();

        RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());

        rentalService.processInvoice(cr);

        System.out.println("FATURA:");
        System.out.println(FMT."Pagamento basico: %.2f\{cr.getInvoice().getBasicPayment()}");
        System.out.println(FMT."Imposto: %.2f\{cr.getInvoice().getTax()}");
        System.out.println(FMT."Pagamento total: %.2f\{cr.getInvoice().getTotalPayment()}");

        sc.close();
    }
}