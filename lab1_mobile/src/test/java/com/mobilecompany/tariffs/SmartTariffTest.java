package com.mobilecompany.tariffs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SmartTariffTest {

    private SmartTariff smartTariff;

    @BeforeEach
    public void setUp() {
        // ініціалізуємо SmartTariff перед кожним тестом
        smartTariff = new SmartTariff("Smart", 275.0, 200, 15, 21200);
    }

    @Test
    public void testSmartTariffInitialization() {
        // перевіряємо коректність ініціалізації тарифу
        assertEquals("Smart", smartTariff.getName());
        assertEquals(275.0, smartTariff.getSubscriptionFee());
        assertEquals(200, smartTariff.getMinutes());
        assertEquals(15, smartTariff.getDataGB());
        assertEquals(21200, smartTariff.getClients());
    }

    @Test
    public void testToString() {
        // перевіряємо метод toString, чи правильно він відображає інформацію
        String expectedString = "Тариф: Smart [Абонплата: 275.0, Хвилини: 200, Інтернет: 15 ГБ, Клієнти: 21200]";
        assertEquals(expectedString, smartTariff.toString());
    }
}
