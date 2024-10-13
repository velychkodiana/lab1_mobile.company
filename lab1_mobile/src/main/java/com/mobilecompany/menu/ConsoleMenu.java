package com.mobilecompany.menu;

import com.mobilecompany.company.TariffDatabase;
import com.mobilecompany.tariffs.BasicTariff;
import com.mobilecompany.tariffs.Tariff;
import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {
    private final TariffDatabase database = new TariffDatabase();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> addTariff();
                case 2 -> showTariffs();
                case 3 -> findTariffByRange();
                case 4 -> countClientsByTariff();
                case 5 -> removeTariff();
                case 6 -> running = false;
                default -> System.out.println("Неправильний вибір. Спробуйте знову.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\n--- Мобільна компанія ---");
        System.out.println("1. Додати тариф");
        System.out.println("2. Показати тарифи");
        System.out.println("3. Знайти тариф за діапазоном");
        System.out.println("4. Порахувати клієнтів за тарифом");
        System.out.println("5. Видалити тариф");
        System.out.println("6. Вихід");
        System.out.print("Ваш вибір: ");
    }

    private void addTariff() {
        System.out.println("Введіть назву тарифу:");
        String name = scanner.nextLine();
        System.out.println("Введіть абонентську плату:");
        double fee = scanner.nextDouble();
        System.out.println("Введіть кількість хвилин:");
        int minutes = scanner.nextInt();
        System.out.println("Введіть кількість інтернету (ГБ):");
        int data = scanner.nextInt();
        System.out.println("Введіть кількість клієнтів:");
        int clients = scanner.nextInt();
        scanner.nextLine();
        Tariff tariff = new BasicTariff(name, fee, minutes, data, clients);
        database.addTariff(tariff);
        System.out.println("Тариф додано.");
    }

    private void showTariffs() {
        database.getTariffs().forEach(System.out::println);
    }

   /* private void findTariffByRange() {
        System.out.println("Введіть мінімальну абонентську плату:");
        double minFee = scanner.nextDouble();
        System.out.println("Введіть максимальну абонентську плату:");
        double maxFee = scanner.nextDouble();
        List <Tariff> foundTariffs  = database.findTariffByRange(minFee, maxFee);
        if (tariff != null) {
            System.out.println("Знайдений тариф: " + tariff);
        } else {
            System.out.println("Тариф не знайдений.");
        }
    }*/

    private void findTariffByRange() {
        System.out.println("Введіть мінімальну абонентську плату:");
        double minFee = scanner.nextDouble();
        System.out.println("Введіть максимальну абонентську плату:");
        double maxFee = scanner.nextDouble();

       List<Tariff> foundTariffs = database.findTariffByRange(minFee, maxFee);
        if (!foundTariffs.isEmpty()) {
            System.out.println("Знайдені тарифи:");
            for (Tariff tariff : foundTariffs) {
                System.out.println(tariff);
            }
        } else {
            System.out.println("Тарифів у заданому діапазоні не знайдено.");
        }
    }

    private void countClientsByTariff() {
        System.out.println("Введіть назву тарифу:");
        String name = scanner.nextLine();
        int clients = database.getClientsByTariffName(name);
        System.out.println("Кількість клієнтів за тарифом: " + clients);
    }

    private void removeTariff() {
        System.out.println("Введіть назву тарифу для видалення:");
        String name = scanner.nextLine();
        database.removeTariff(name);
        System.out.println("Тариф видалено.");
    }

    public static void main(String[] args) {
        ConsoleMenu menu = new ConsoleMenu();
        menu.start();
    }
}
