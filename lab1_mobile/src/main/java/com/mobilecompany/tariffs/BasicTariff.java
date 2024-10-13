package com.mobilecompany.tariffs;

public class BasicTariff extends Tariff {
    public BasicTariff(String name, double subscriptionFee, int minutes, int dataGB, int clients) {
        super(name, subscriptionFee, minutes, dataGB, clients);
    }
}

