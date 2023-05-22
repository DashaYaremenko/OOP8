package org.example.lab7;

import java.util.List;

public interface IO {
    public List<Train> readObject(String filePath);
    public void writeObject(TrainList trains, String filePath);
    public void writeObjectJSON(TrainList trains, String filePath);

    public List<Train> readObjectJSON(String filePath) ;
}
