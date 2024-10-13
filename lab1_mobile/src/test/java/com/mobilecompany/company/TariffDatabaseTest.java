package com.mobilecompany.company;

import com.mobilecompany.tariffs.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TariffDatabaseTest {

    private TariffDatabase tariffDatabase;

    @BeforeEach
    public void setUp() {
        tariffDatabase = new TariffDatabase(); // ініціалізуємо базу перед кожним тестом
    }

    @Test
    public void testAddTariff_Successful() {
        Tariff newTariff = new StartTariff("NewStart", 90.0, 100, 2, 5000);
        boolean added = tariffDatabase.addTariff(newTariff);
        assertTrue(added, "Тариф має бути успішно доданий");
    }

    @Test
    public void testAddTariff_ExistingName() {
        Tariff duplicateTariff = new BasicTariff("Basic", 150.0, 100, 5, 17500);
        boolean added = tariffDatabase.addTariff(duplicateTariff);
        assertFalse(added, "Тариф з такою назвою вже існує, не повинен бути доданий вдруге");
    }

    @Test
    public void testFindTariffByRange() {
        List<Tariff> tariffsInRange = tariffDatabase.findTariffByRange(100.0, 300.0);
        assertEquals(3, tariffsInRange.size(), "В діапазоні повинно бути 3 тарифи");
    }

    @Test
    public void testGetClientsByTariffName_ExistingTariff() {
        int clients = tariffDatabase.getClientsByTariffName("Pro");
        assertEquals(3550, clients, "Кількість клієнтів повинна бути 3550 для тарифу 'Pro'");
    }

    @Test
    public void testGetClientsByTariffName_NonExistingTariff() {
        int clients = tariffDatabase.getClientsByTariffName("NonExisting");
        assertEquals(0, clients, "Для неіснуючого тарифу має бути повернено 0 клієнтів");
    }

    @Test
    public void testRemoveTariff_Successful() {
        tariffDatabase.removeTariff("Basic");
        List<Tariff> tariffs = tariffDatabase.getTariffs();
        assertEquals(4, tariffs.size(), "Після видалення тарифу 'Basic', в базі має залишитися 4 тарифи");
    }

    @Test
    public void testRemoveTariff_NonExisting() {
        tariffDatabase.removeTariff("NonExisting");
        List<Tariff> tariffs = tariffDatabase.getTariffs();
        assertEquals(5, tariffs.size(), "Кількість тарифів не повинна змінитися при видаленні неіснуючого тарифу");
    }
}
