/*package com.mobilecompany.company;

import com.mobilecompany.tariffs.BasicTariff;
import com.mobilecompany.tariffs.ProTariff;
import com.mobilecompany.tariffs.UnlimitedTariff;
import com.mobilecompany.tariffs.Tariff;
import com.mobilecompany.tariffs.StartTariff;
import com.mobilecompany.tariffs.SmartTariff;

import java.util.ArrayList;
import java.util.List;

public class TariffDatabase {
    private List<Tariff> tariffs = new ArrayList<>();

    // Конструктор, що ініціалізує стартові тарифи
    public TariffDatabase() {
        tariffs.add(new BasicTariff("Basic", 150.0, 100, 5, 17500));
        tariffs.add(new SmartTariff("Smart", 275.0, 200, 15, 21200));
        tariffs.add(new ProTariff("Pro", 200.0, 200, 10, 3550));
        tariffs.add(new UnlimitedTariff("Unlimited", 420.0, 500, 50, 1200));
        tariffs.add(new StartTariff("Start", 80.0, 80, 1, 13200));
    }

    // Додавання тарифу з перевіркою на унікальність
    public boolean addTariff(Tariff tariff) {
        for (Tariff t : tariffs) {
            if (t.getName().equalsIgnoreCase(tariff.getName())) {
                System.out.println("Тариф з назвою \"" + tariff.getName() + "\" вже існує.");
                return false; // Не додаємо тариф
            }
        }
        tariffs.add(tariff);
        System.out.println("Тариф \"" + tariff.getName() + "\" успішно додано.");
        return true; // Успішне додавання
    }

    // Отримати список всіх тарифів
    public List<Tariff> getTariffs() {
        return tariffs;
    }

    // Метод для пошуку тарифів у вказаному діапазоні абонентської плати
    public List<Tariff> findTariffByRange(double minFee, double maxFee) {
        List<Tariff> result = new ArrayList<>();
        for (Tariff tariff : tariffs) {
            if (tariff.getSubscriptionFee() >= minFee && tariff.getSubscriptionFee() <= maxFee) {
                result.add(tariff);
            }
        }
        if (result.isEmpty()) {
            System.out.println("Тарифи в діапазоні від " + minFee + " до " + maxFee + " не знайдено.");
        }
        return result;
    }

    // Пошук кількості клієнтів за назвою тарифу
    public int getClientsByTariffName(String name) {
        for (Tariff tariff : tariffs) {
            if (tariff.getName().equalsIgnoreCase(name)) {
                return tariff.getClients();
            }
        }
        System.out.println("Тарифу з назвою \"" + name + "\" не знайдено.");
        return 0;
    }

    // Видалення тарифу за назвою
    public void removeTariff(String name) {
        if (tariffs.removeIf(tariff -> tariff.getName().equalsIgnoreCase(name))) {
            System.out.println("Тариф \"" + name + "\" успішно видалено.");
        } else {
            System.out.println("Тарифу з назвою \"" + name + "\" не знайдено.");
        }
    }
}*/
package com.mobilecompany.company;

import com.mobilecompany.tariffs.Tariff;

import java.util.ArrayList;
import java.util.List;

public class TariffDatabase {
    private List<Tariff> tariffs = new ArrayList<>();

    public TariffDatabase() {
        // Ініціалізація стартових тарифів
        tariffs.add(new Tariff("Basic", 150.0, 100, 5, 17500));
        tariffs.add(new Tariff("Smart", 275.0, 200, 15, 21200));
        tariffs.add(new Tariff("Pro", 200.0, 200, 10, 3550));
        tariffs.add(new Tariff("Unlimited", 420.0, 500, 50, 1200));
        tariffs.add(new Tariff("Start", 80.0, 80, 1, 13200));
    }

    // Додавання тарифу
    public boolean addTariff(Tariff tariff) {
        for (Tariff t : tariffs) {
            if (t.getName().equalsIgnoreCase(tariff.getName())) {
                System.out.println("Тариф з назвою \"" + tariff.getName() + "\" вже існує.");
                return false;
            }
        }
       tariffs.add(tariff);
        System.out.println("Тариф \"" + tariff.getName() + "\" успішно додано.");
        return true;
    }

    public List<Tariff> getTariffs() {
        return tariffs;
    }

    public List<Tariff> findTariffByRange(double minFee, double maxFee) {
        List<Tariff> result = new ArrayList<>();
        for (Tariff tariff : tariffs) {
            if (tariff.getSubscriptionFee() >= minFee && tariff.getSubscriptionFee() <= maxFee) {
                result.add(tariff);
            }
        }
        return result;
    }

    public int getClientsByTariffName(String name) {
        for (Tariff tariff : tariffs) {
            if (tariff.getName().equalsIgnoreCase(name)) {
                return tariff.getClients();
            }
        }
        return 0;
    }

    public void removeTariff(String name) {
        tariffs.removeIf(tariff -> tariff.getName().equalsIgnoreCase(name));
    }
}
