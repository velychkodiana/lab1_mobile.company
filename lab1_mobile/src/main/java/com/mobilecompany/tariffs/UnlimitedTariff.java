package com.mobilecompany.tariffs;

public class UnlimitedTariff extends Tariff {
    public UnlimitedTariff(String name, double subscriptionFee, int minutes, int dataGB, int clients) {
        super(name, subscriptionFee, minutes, dataGB, clients);
    }
}

