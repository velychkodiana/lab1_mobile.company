package com.mobilecompany.tariffs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UnlimitedTariffTest {

    private UnlimitedTariff unlimitedTariff;

    @BeforeEach
    public void setUp() {
        // ініціалізація UnlimitedTariff перед кожним тестом
        unlimitedTariff = new UnlimitedTariff("Unlimited", 420.0, 500, 50, 1200);
    }

    @Test
    public void testUnlimitedTariffInitialization() {
        // перевірка коректності ініціалізації тарифу
        assertEquals("Unlimited", unlimitedTariff.getName());
        assertEquals(420.0, unlimitedTariff.getSubscriptionFee());
        assertEquals(500, unlimitedTariff.getMinutes());
        assertEquals(50, unlimitedTariff.getDataGB());
        assertEquals(1200, unlimitedTariff.getClients());
    }

    @Test
    public void testToString() {
        // перевірка методу toString, чи правильно він відображає інформацію
        String expectedString = "Тариф: Unlimited [Абонплата: 420.0, Хвилини: 500, Інтернет: 50 ГБ, Клієнти: 1200]";
        assertEquals(expectedString, unlimitedTariff.toString());
    }
}
