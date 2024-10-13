package com.mobilecompany.tariffs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StartTariffTest {

    private StartTariff startTariff;

    @BeforeEach
    public void setUp() {
        // ініціалізуємо StartTariff перед кожним тестом
        startTariff = new StartTariff("Start", 100.0, 100, 5, 1000);
    }

    @Test
    public void testStartTariffInitialization() {
        // перевіряємо коректність ініціалізації тарифу
        assertEquals("Start", startTariff.getName());
        assertEquals(100.0, startTariff.getSubscriptionFee());
        assertEquals(100, startTariff.getMinutes());
        assertEquals(5, startTariff.getDataGB());
        assertEquals(1000, startTariff.getClients());
    }

    @Test
    public void testToString() {
        // перевіряємо метод toString, чи правильно він відображає інформацію
        String expectedString = "Тариф: Start [Абонплата: 100.0, Хвилини: 100, Інтернет: 5 ГБ, Клієнти: 1000]";
        assertEquals(expectedString, startTariff.toString());
    }
}
