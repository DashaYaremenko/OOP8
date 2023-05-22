package org.example.lab7;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

public class Train implements Serializable {
    private int id;
    private String destination;
    private int trainNumber;
    private LocalTime shippingTime;
    private int numberOfSeats;
    public Train(int id, String destination, int trainNumber, LocalTime shippingTime, int numberOfSeats) {
        this.id = id;
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.shippingTime = shippingTime;
        this.numberOfSeats =numberOfSeats;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }
    public void setShippingTime(LocalTime shippingTime) {
        this.shippingTime = shippingTime;
    }
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
    public int getId(){return id;}
    public String getDestination() {
        return destination;
    }
    public LocalTime getShippingTime() {
        return shippingTime;
    }
    public int getNumberOfSeats() {
        return numberOfSeats;
    }
    public int getTrainNumber(){return trainNumber;}

    public String toString() {
        return "Потяг :" +
                "  id = " + id +
                "  Пунк призначення = '" + destination + '\'' +
                "\t Номер потяга = '" + trainNumber + '\'' + "\tЧас відправки  = " + shippingTime +
                "  \tЧисло місця = '" + numberOfSeats + '\'';
    }
    public boolean equals(Object a) {
        if (this == a) return true;
        if (a == null || getClass() != a.getClass()) return false;
        Train train = (Train) a;
        return
                id == train.id &&
                        trainNumber == train.trainNumber &&
                        numberOfSeats == train.numberOfSeats &&
                        Objects.equals(destination, train.destination);
    }

}
