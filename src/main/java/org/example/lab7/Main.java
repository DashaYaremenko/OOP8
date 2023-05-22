package org.example.lab7;

import java.io.Serializable;
import java.util.Scanner;

public class Main implements Serializable {
    public static void main(String[] args) {new Main().run();}
    private void run() {
        TrainList trains= new TrainList();
        IO io= new IOProcess();
        TrainFunction function= new TrainFunctionProcess();
        Scanner scanner=new Scanner(System.in);
        boolean status=true;
        option();
        while (status){
            int o=scanner.nextInt();
            switch (o){
                case 0 -> function.createTrainArr(trains);
                case 1 -> function.printTrainList(trains.getTrains());
                case 2 -> function.printSortShippingTime(trains,scanner);
                case 3 -> function.printDestinAndTime(trains,scanner);
                case 4 -> function.printDestinAndNumSeats(trains,scanner);
                case 5 -> function.printSortDestinNumberAlpha(trains);
                case 6 -> function.printListTrainDestin(trains,scanner);
                case 7 -> function.addTrain(trains,scanner);
                case 8 -> function.deleteTrainID(trains,scanner);
                case 9 -> io.writeObject(trains,"Choo-Choo.dat");
                case 10 -> trains.setTrainList(io.readObject("Choo-Choo.dat"));
                case 11-> io.writeObjectJSON(trains,"Choo-Choo.json");
                case 12-> trains.setTrainList(io.readObjectJSON("Choo-Choo.json"));
                case 13 -> status=false;
            }
        }
    }
    private void option() {
        System.out.println("""
                0-Створити список потягів.
                1-Вивести весь список потягів.
                2-Список потягів, які прямують до заданого пункту призначення в порядку зростання часу
                  відправки, якщо час однаковий – за зростанням номеру потягів.
                3-Список потягів, які прямують до заданого пункту призначення та відправляються після
                  заданої години.
                4-Список потягів, які відправляються до заданого пункту призначення та мають загальні
                  місця.
                5-Список пунктів призначення (без повторів) в порядку зростання кількості поїздів,
                  що до них прямують, якщо кількість однакова – в порядку алфавіту.
                6-Для кожного пункта призначення вивести список поїздів, які до нього прямують.
                7-Додати новий потяг.
                8-Видалити потяг через id.
                9-Зберегти у форматі dat.
                10-Прочитати файл у форматі dat.
                11-Зберегти у форматі JSON.
                12-Прочитати у форматі JSON.
                13-Завершити програму;
                """);

    }
}
