package com.mobilecompany.tariffs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BasicTariffTest {

    private BasicTariff basicTariff;

    @BeforeEach
    public void setUp() {
        // ініціалізуємо BasicTariff перед кожним тестом
        basicTariff = new BasicTariff("Basic", 150.0, 100, 1, 13000);
    }

    @Test
    public void testBasicTariffInitialization() {
        // перевіряємо коректність ініціалізації тарифу
        assertEquals("Basic", basicTariff.getName());
        assertEquals(150.0, basicTariff.getSubscriptionFee());
        assertEquals(100, basicTariff.getMinutes());
        assertEquals(1, basicTariff.getDataGB());
        assertEquals(13000, basicTariff.getClients());
    }

    @Test
    public void testToString() {
        //перевіряємо метод toString, чи правильно він відображає інформацію
        String expectedString = "Тариф: Basic [Абонплата: 150.0, Хвилини: 100, Інтернет: 1 ГБ, Клієнти: 13000]";
        assertEquals(expectedString, basicTariff.toString());
    }
}
