package com.mobilecompany.menu;

import com.mobilecompany.company.TariffDatabase;
import com.mobilecompany.tariffs.BasicTariff;
import com.mobilecompany.tariffs.Tariff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleMenuTest {
    private TariffDatabase database;
    private ConsoleMenu menu;

    @BeforeEach
    public void setUp() {
        database = new TariffDatabase();
        menu = new ConsoleMenu();
    }

    @Test
    public void testAddTariff() {
        // перевіряємо початкову кількість тарифів
        int initialSize = database.getTariffs().size();

        // додаємо новий тариф
        Tariff newTariff = new BasicTariff("NewTariff", 300.0, 100, 10, 5000);
        boolean isAdded = database.addTariff(newTariff);

        // перевіряємо, чи тариф успішно додано
        assertTrue(isAdded);
        assertEquals(initialSize + 1, database.getTariffs().size());
    }

    @Test
    public void testRemoveTariff() {
        // додаємо тариф для видалення
        Tariff tariffToRemove = new BasicTariff("RemoveMe", 250.0, 200, 5, 3000);
        database.addTariff(tariffToRemove);

        // видаляємо тариф
        int initialSize = database.getTariffs().size();
        database.removeTariff("RemoveMe");

        // перевіряємо, чи тариф видалено
        assertEquals(initialSize - 1, database.getTariffs().size());
        assertNull(database.findTariffByRange(250.0, 250.0).stream()
                .filter(tariff -> "RemoveMe".equals(tariff.getName()))
                .findFirst()
                .orElse(null));
    }

    @Test
    public void testFindTariffByRange() {
        // знаходимо тарифи в діапазоні
        List<Tariff> foundTariffs = database.findTariffByRange(100.0, 300.0);

        // перевіряємо, що знайдено більше одного тарифу
        assertFalse(foundTariffs.isEmpty());
        for (Tariff tariff : foundTariffs) {
            assertTrue(tariff.getSubscriptionFee() >= 100.0 && tariff.getSubscriptionFee() <= 300.0);
        }
    }

    @Test
    public void testCountClientsByTariff() {
        // додаємо новий тариф
        Tariff newTariff = new BasicTariff("PopularTariff", 100.0, 150, 5, 10000);
        database.addTariff(newTariff);

        // перевіряємо кількість клієнтів за тарифом
        int clients = database.getClientsByTariffName("PopularTariff");
        assertEquals(10000, clients);
    }

    @Test
    public void testRemoveNonExistingTariff() {
        int initialSize = database.getTariffs().size();

        // спробуємо видалити тариф, якого немає
        database.removeTariff("NonExistingTariff");

        // перевіряємо, що кількість тарифів не змінилася
        assertEquals(initialSize, database.getTariffs().size());
    }
}
