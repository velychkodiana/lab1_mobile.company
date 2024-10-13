package com.mobilecompany.utils;

import com.mobilecompany.tariffs.Tariff;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public static List<Tariff> loadTariffsFromFile(String filePath) throws IOException {
        List<Tariff> tariffs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                double fee = Double.parseDouble(parts[1]);
                int minutes = Integer.parseInt(parts[2]);
                int dataGB = Integer.parseInt(parts[3]);
                int clients = Integer.parseInt(parts[4]);

                // створюємо універсальний тариф
                Tariff tariff = new Tariff(name, fee, minutes, dataGB, clients);
                tariffs.add(tariff);
            }
        }
        return tariffs;
    }
}
