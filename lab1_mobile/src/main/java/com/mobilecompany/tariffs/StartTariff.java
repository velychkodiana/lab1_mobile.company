package com.mobilecompany.tariffs;

public class StartTariff extends Tariff {
    public StartTariff(String name, double subscriptionFee, int minutes, int dataGB, int clients) {
        super(name, subscriptionFee, minutes, dataGB, clients);
    }
}