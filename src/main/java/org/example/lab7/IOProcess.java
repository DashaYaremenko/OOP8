package org.example.lab7;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOProcess implements IO {
    @Override
    public List<Train> readObject(String filePath) {
        List<Train> trains = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            trains = (List<Train>) ois.readObject();
            System.out.println("Вітаю! Файл прочитано");
            return trains;
        } catch (IOException e) {
            System.out.println("О ні! Помилка читання файлу");
        } catch (ClassNotFoundException e) {
            System.out.println("Нажаль файл не знайдено");
        }
        return trains;
    }
    @Override
    public void writeObject(TrainList trains, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(trains.getTrains());
            System.out.println("Запис файлу успішний");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void writeObjectJSON(TrainList trains, String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            List<Train> trains1 = trains.getTrains();
            objectMapper.writeValue(new File(filePath), trains1);
            System.out.println("Запис файлу успішний");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Train> readObjectJSON(String filePath)  {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.findAndRegisterModules();
        try {
            System.out.println("Вітаю! Файл прочитано");
            return objectMapper.readValue(new File(filePath), new TypeReference<List<Train>>(){});
        } catch (FileNotFoundException e) {
            System.out.println("О ні! Помилка читання файлу");
        } catch (IOException e) {
            System.out.println("Нажаль файл не знайдено");
        }
        return null;
    }
}


