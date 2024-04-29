package composition1.application;

import composition1.model.entities.Department;
import composition1.model.entities.HourContract;
import composition1.model.entities.Worker;
import composition1.model.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter departments name: ");
        String departmentName = sc.nextLine();
        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base salary: ");
        double baseSalary  = sc.nextDouble();
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
        try {
            System.out.println("How many contracts to this worker?");
            int n = sc.nextInt();

            for (int i = 1; i <= n; i++) {
                System.out.println("Enter contract #" + i + " data:");
                System.out.println("Date (DD/MM/YYYY): ");
                Date contractDate = sdf.parse(sc.next());
                System.out.print("Value per hour: ");
                double valuePerHour = sc.nextDouble();
                System.out.print("Duration(hours): ");
                int hours = sc.nextInt();
                HourContract contract = new HourContract(contractDate, valuePerHour, hours);
                worker.addContract(contract);
            }
        } catch (ParseException e) {
            System.out.println("Invalid date");
        }

        System.out.print("\nEnter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f%n",worker.income(year, month)));
        sc.close();
    }
}
