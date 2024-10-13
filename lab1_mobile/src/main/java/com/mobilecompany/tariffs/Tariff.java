package com.mobilecompany.tariffs;

import java.util.ArrayList;
import java.util.List;

public abstract class Tariff {
    private String name;
    private double subscriptionFee;
    private int minutes;
    private int dataGB;
    private int clients;

    // Конструктор
    public Tariff(String name, double subscriptionFee, int minutes, int dataGB, int clients) {
        this.name = name;
        this.subscriptionFee = subscriptionFee;
        this.minutes = minutes;
        this.dataGB = dataGB;
        this.clients = clients;
    }

    // Геттери та сеттери
    public String getName() {
        return name;
    }

    public double getSubscriptionFee() {
        return subscriptionFee;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getDataGB() {
        return dataGB;
    }

    public int getClients() {
        return clients;
    }

    // toString метод для відображення інформації
    @Override
    public String toString() {
        return "Тариф: " + name + " [Абонплата: " + subscriptionFee + ", Хвилини: " + minutes + ", Інтернет: " + dataGB + " ГБ, Клієнти: " + clients + "]";
    }

    // пошук тарифів у діапазоні вартості
    public static List<Tariff> findTariffsInRange(List<Tariff> tariffs, double minPrice, double maxPrice) {
        List<Tariff> result = new ArrayList<>();
        for (Tariff tariff : tariffs) {
            if (tariff.getSubscriptionFee() >= minPrice && tariff.getSubscriptionFee() <= maxPrice) {
                result.add(tariff);
            }
        }
        if (result.isEmpty()) {
            System.out.println("Тарифи в діапазоні від " + minPrice + " до " + maxPrice + " не знайдено");
        }
        return result;
    }

    // Метод для перевірки наявності тарифу з такою ж назвою
    public static boolean addTariffIfNotExists(List<Tariff> tariffs, Tariff newTariff) {
        for (Tariff t : tariffs) {
            if (t.getName().equalsIgnoreCase(newTariff.getName())) {
                System.out.println("Тариф з цією назвою вже існує");
                return false;
            }
        }
        tariffs.add(newTariff);
        return true;
    }

    // Метод для пошуку тарифу за назвою
    public static Tariff findTariffByName(List<Tariff> tariffs, String name) {
        for (Tariff tariff : tariffs) {
            if (tariff.getName().equalsIgnoreCase(name)) {
                return tariff;
            }
        }
        System.out.println("Тарифу з такою назвою не знайдено");
        return null;
    }
}
/*  package com.mobilecompany.tariffs;

import java.util.ArrayList;
import java.util.List;

public abstract class Tariff {
    private String name;
    private double subscriptionFee;
    private int minutes;
    private int dataGB; // Змінимо назву поля на dataGB
    private int clients;

    // Конструктор
    public Tariff(String name, double subscriptionFee, int minutes, int dataGB, int clients) {
        this.name = name;
        this.subscriptionFee = subscriptionFee;
        this.minutes = minutes;
        this.dataGB = dataGB;
        this.clients = clients;
    }

    // Геттери та сеттери
    public String getName() {
        return name;
    }

    public double getSubscriptionFee() {
        return subscriptionFee;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getDataGB() { // Замість getData() використовуємо getDataGB()
        return dataGB;
    }

    public int getClients() {
        return clients;
    }

    // toString метод для відображення інформації
    @Override
    public String toString() {
        return "Тариф: " + name + " [Абонплата: " + subscriptionFee + ", Хвилини: " + minutes + ", Інтернет: " + dataGB + " ГБ, Клієнти: " + clients + "]";
    }

    // Метод для пошуку тарифів у діапазоні вартості
    public static List<Tariff> findTariffsInRange(List<Tariff> tariffs, double minPrice, double maxPrice) {
        List<Tariff> result = new ArrayList<>();
        for (Tariff tariff : tariffs) {
            if (tariff.getSubscriptionFee() >= minPrice && tariff.getSubscriptionFee() <= maxPrice) {
                result.add(tariff);
            }
        }
        if (result.isEmpty()) {
            System.out.println("Тарифи в діапазоні від " + minPrice + " до " + maxPrice + " не знайдено");
        }
        return result;
    }

    // Метод для перевірки наявності тарифу з такою ж назвою
    public static boolean addTariffIfNotExists(List<Tariff> tariffs, Tariff newTariff) {
        for (Tariff t : tariffs) {
            if (t.getName().equalsIgnoreCase(newTariff.getName())) {
                System.out.println("Тариф з цією назвою вже існує");
                return false;
            }
        }
        tariffs.add(newTariff);
        return true;
    }

    // Метод для пошуку тарифу за назвою
    public static Tariff findTariffByName(List<Tariff> tariffs, String name) {
        for (Tariff tariff : tariffs) {
            if (tariff.getName().equalsIgnoreCase(name)) {
                return tariff;
            }
        }
        System.out.println("Тарифу з такою назвою не знайдено");
        return null;
    }
}*/

