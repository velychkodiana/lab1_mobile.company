import com.mobilecompany.tariffs.Tariff;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TariffTest {

    @Test
    void testTariffCreation() {
        // створюємо  Tariff
        Tariff tariff = new Tariff("Basic", 150.0, 100, 5, 17500);

        // перевірка значень властивостей
        assertEquals("Basic", tariff.getName());
        assertEquals(150.0, tariff.getSubscriptionFee());
        assertEquals(100, tariff.getMinutes());
        assertEquals(5, tariff.getDataGB());
        assertEquals(17500, tariff.getClients());
    }

    @Test
    void testToString() {
        // створення екземпляра Tariff
        Tariff tariff = new Tariff("Smart", 275.0, 200, 15, 21200);

        // перевірка правильності формату виведення toString()
        String expected = "Тариф: Smart [Абонплата: 275.0, Хвилини: 200, Інтернет: 15 ГБ, Клієнти: 21200]";
        assertEquals(expected, tariff.toString());
    }
}

