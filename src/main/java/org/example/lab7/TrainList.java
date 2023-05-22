package org.example.lab7;

import java.time.LocalTime;
import java.util.*;

public class TrainList {
    private List<Train> trains = new ArrayList<>();
    private int size=0;
    public List<Train> getTrains(){return trains;}
    public int getSize() {return size;}
    public void setSize(int size) {this.size = size;}
    public void setTrainList(List<Train> train1) {
        trains=train1;
    }
    public void addTrain(Train train){
        trains.add(train);
    }
    public void deleteTrainID(int id) {
        trains.removeIf(e -> (e.getId() == id));
    }
    public ArrayList<Train> sortShippingTime(String destination){
        ArrayList<Train> destinationList= new ArrayList<>();
        for (Train train:trains){
            if (train!=null){
                if (train.getDestination().equals(destination)){
                    destinationList.add(train);
                }
            }
        }
        destinationList.sort(Comparator.comparing(Train::getShippingTime).thenComparing(Train::getTrainNumber));
        return destinationList;
    }
    public List<Train> printTrainDestinAndTime(List<Train> trains, String destination1, LocalTime time) {
        ArrayList<Train> trains1 = new ArrayList<>();
        for (Train train : trains) {
            if(train==null)continue;
            if(train.getDestination().equals(destination1)){System.out.println(train);}
             if (train.getShippingTime().isAfter(time)){System.out.println(train);}
                trains1.add(train);
        }
        return trains1;
    }

    public List<Train> printTrainDestinAndNumSeats(String destination2, int numberoOfsets) {
        ArrayList<Train> trains2=new ArrayList<>();
        for (Train train:trains){
            if(train==null)continue;
            if (train.getDestination().equals(destination2)){System.out.println(train);}
            if (train.getNumberOfSeats()<= numberoOfsets){System.out.println(train);}
        }
        return trains2;
    }
    public List<String> sortDestinNumberAlpha() {
        Map<String, Integer> destinCount = new HashMap<>();
        for (Train train : trains) {
            String destination = train.getDestination();
            destinCount.put(destination, destinCount.getOrDefault(destination, 0) + 1);
        }
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(destinCount.entrySet());
        entryList.sort((i, j) -> {
            int count = Integer.compare(i.getValue(), j.getValue());
            if (count == 0) {
                return i.getKey().compareTo(j.getKey());
            }
            return count;
        });
        List<String> sortedDestinations = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedDestinations.add(entry.getKey());
        }
        return sortedDestinations;
    }

    public HashMap<String, List<Train>> printListTrainsDestin() {
        HashMap<String, List<Train>> ListTrainsDestin = new HashMap<>();
        for (Train train : trains) {
            String destination = train.getDestination();

            if (ListTrainsDestin.containsKey(destination)) {
                ListTrainsDestin.get(destination).add(train);
            } else {
                List<Train> arr = new ArrayList<>();
                arr.add(train);
                ListTrainsDestin.put(destination, arr);
            }
        }
        return ListTrainsDestin;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(trains).append(",\n");
        }
        return sb.toString();
    }
}

