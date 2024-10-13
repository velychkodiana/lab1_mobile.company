package com.mobilecompany.utils;

import com.mobilecompany.tariffs.BasicTariff;
import com.mobilecompany.tariffs.ProTariff;
import com.mobilecompany.tariffs.UnlimitedTariff;
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
                String type = parts[0];
                String name = parts[1];
                double fee = Double.parseDouble(parts[2]);
                int minutes = Integer.parseInt(parts[3]);
                int dataGB = Integer.parseInt(parts[4]);
                int clients = Integer.parseInt(parts[5]);

                Tariff tariff;
                switch (type) {
                    case "Basic":
                        tariff = new BasicTariff(name, fee, minutes, dataGB, clients);
                        break;
                    case "Pro":
                        tariff = new ProTariff(name, fee, minutes, dataGB, clients);
                        break;
                    case "Unlimited":
                        tariff = new UnlimitedTariff(name, fee, minutes, dataGB, clients);
                        break;
                    default:
                        throw new IllegalArgumentException("Невідомий тип тарифу: " + type);
                }

                tariffs.add(tariff);
            }
        }
        return tariffs;
    }
}
/*
package com.mobilecompany.utils;

import com.mobilecompany.tariffs.BasicTariff;
import com.mobilecompany.tariffs.ProTariff;
import com.mobilecompany.tariffs.UnlimitedTariff;
import com.mobilecompany.tariffs.Tariff;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    // Метод для завантаження тарифів з файлу
    public static List<Tariff> loadTariffsFromFile(String filePath) throws IOException {
        List<Tariff> tariffs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[0];
                String name = parts[1];
                double fee = Double.parseDouble(parts[2]);
                int minutes = Integer.parseInt(parts[3]);
                int dataGB = Integer.parseInt(parts[4]);
                int clients = Integer.parseInt(parts[5]);

                Tariff tariff;
                switch (type) {
                    case "Basic":
                        tariff = new BasicTariff(name, fee, minutes, dataGB, clients);
                        break;
                    case "Pro":
                        tariff = new ProTariff(name, fee, minutes, dataGB, clients);
                        break;
                    case "Unlimited":
                        tariff = new UnlimitedTariff(name, fee, minutes, dataGB, clients);
                        break;
                    default:
                        throw new IllegalArgumentException("Невідомий тип тарифу: " + type);
                }

                tariffs.add(tariff);
            }
        }
        return tariffs;
    }

    // Метод для збереження тарифів у файл
    public static void saveTariffsToFile(String filePath, List<Tariff> tariffs) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Tariff tariff : tariffs) {
                String type = "";
                if (tariff instanceof BasicTariff) {
                    type = "Basic";
                } else if (tariff instanceof ProTariff) {
                    type = "Pro";
                } else if (tariff instanceof UnlimitedTariff) {
                    type = "Unlimited";
                }
                // Записуємо тариф у файл у форматі: type,name,fee,minutes,dataGB,clients
                writer.write(type + "," + tariff.getName() + "," + tariff.getSubscriptionFee() + "," +
                        tariff.getMinutes() + "," + tariff.getData() + "," + tariff.getClients());
                writer.newLine(); // Переходимо на новий рядок
            }
        }
    }
}*/