package com.mobilecompany.tariffs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProTariffTest {

    private ProTariff proTariff;

    @BeforeEach
    public void setUp() {
        // ініціалізуємо ProTariff перед кожним тестом
        proTariff = new ProTariff("Pro", 200.0, 200, 25, 7000);
    }

    @Test
    public void testProTariffInitialization() {
        // перевіряємо коректність ініціалізації тарифу
        assertEquals("Pro", proTariff.getName());
        assertEquals(200.0, proTariff.getSubscriptionFee());
        assertEquals(200, proTariff.getMinutes());
        assertEquals(25, proTariff.getDataGB());
        assertEquals(7000, proTariff.getClients());
    }

    @Test
    public void testToString() {
        // перевіряємо метод toString, чи правильно він відображає інформацію
        String expectedString = "Тариф: Pro [Абонплата: 200.0, Хвилини: 200, Інтернет: 25 ГБ, Клієнти: 7000]";
        assertEquals(expectedString, proTariff.toString());
    }
}