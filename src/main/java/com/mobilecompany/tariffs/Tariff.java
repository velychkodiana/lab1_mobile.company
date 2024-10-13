package com.mobilecompany.tariffs;

public class Tariff {
    private String name;
    private double subscriptionFee;
    private int minutes;
    private int dataGB;
    private int clients;

    public Tariff(String name, double subscriptionFee, int minutes, int dataGB, int clients) {
        this.name = name;
        this.subscriptionFee = subscriptionFee;
        this.minutes = minutes;
        this.dataGB = dataGB;
        this.clients = clients;
    }

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

    @Override
    public String toString() {
        return "Тариф: " + name + " [Абонплата: " + subscriptionFee + ", Хвилини: " + minutes + ", Інтернет: " + dataGB + " ГБ, Клієнти: " + clients + "]";
    }
}
