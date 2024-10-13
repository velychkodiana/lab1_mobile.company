package com.mobilecompany.utils;

import com.mobilecompany.tariffs.Tariff;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileHandlerTest {

    @Test
    public void testLoadTariffsFromFile() throws IOException {
        // створення тестового файлу
        Path testFile = Files.createTempFile("tariffs", ".txt");
        String content = "Basic,150.0,100,5,17500\n" +
                "Pro,200.0,200,10,3550\n" +
                "Unlimited,420.0,500,50,1200\n";
        Files.write(testFile, content.getBytes());

        // завантаження тарифів з файлу
        List<Tariff> tariffs = FileHandler.loadTariffsFromFile(testFile.toString());

        // перевірка результатів
        assertEquals(3, tariffs.size());

        Tariff basicTariff = tariffs.get(0);
        assertEquals("Basic", basicTariff.getName());
        assertEquals(150.0, basicTariff.getSubscriptionFee());
        assertEquals(100, basicTariff.getMinutes());
        assertEquals(5, basicTariff.getDataGB());
        assertEquals(17500, basicTariff.getClients());

        // видаляємо файлл
        Files.deleteIfExists(testFile);
    }
}
