package com.mobilecompany.tariffs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TariffTest {

    private List<Tariff> tariffs;

    @BeforeEach
    public void setUp() {
        tariffs = new ArrayList<>();
        tariffs.add(new BasicTariff("Basic", 150.0, 100, 1, 13000));
        tariffs.add(new ProTariff("Pro", 200.0, 200, 25, 7000));
        tariffs.add(new UnlimitedTariff("Unlimited", 420.0, 500, 50, 1200));
    }

    @Test
    public void testFindTariffsInRange() {
        List<Tariff> result = Tariff.findTariffsInRange(tariffs, 100.0, 250.0);
        assertEquals(2, result.size(), "Повинно бути 2 тарифи в цьому діапазоні");
    }

    @Test
    public void testFindTariffByName() {
        Tariff result = Tariff.findTariffByName(tariffs, "Pro");
        assertNotNull(result, "Тариф 'Pro' повинен існувати");
        assertEquals("Pro", result.getName(), "Ім'я тарифу повинно бути 'Pro'");
    }

    @Test
    public void testAddTariffIfNotExists() {
        Tariff newTariff = new StartTariff("Start", 150.0, 150, 15, 150);
        boolean added = Tariff.addTariffIfNotExists(tariffs, newTariff);
        assertTrue(added, "Тариф повинен бути доданий");

        // спробуємо додати той самий тариф вдруге
        boolean addedAgain = Tariff.addTariffIfNotExists(tariffs, newTariff);
        assertFalse(addedAgain, "Тариф не повинен бути доданий вдруге");
    }
}
