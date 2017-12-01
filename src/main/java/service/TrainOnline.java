package service;

import model.Train;

import java.util.*;

/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public class TrainOnline {

    private volatile ArrayList<Train> trains = new ArrayList<>();
    private final static TrainOnline instance = new TrainOnline();

    private TrainOnline() {

    }

    public static TrainOnline getInstance() {
        return instance;
    }

    public synchronized void subscribe(Train train) {
        trains.add(train);
    }

    public synchronized void unsubscribe(Train train) {
        trains.remove(train);
    }

    public synchronized void letsMove() {
        if (trains.size() > 0) {
            for (int i = 0; i < trains.size(); i++) {
                System.out.println(trains.get(i));
                trains.get(i).move();
            }

            for (int i = 0; i < trains.size(); i++) {
                for (int j = 0; j < trains.size(); j++) {
                    Train firstTrain = trains.get(i);
                    Train secondTrain = trains.get(j);
                    if (!(firstTrain == secondTrain)) {
                        firstTrain.checkAccident(secondTrain);
                    }
                }
            }
        } else {
            System.out.println("Нету поездов в сети");
            Thread.currentThread().interrupt();
        }
    }
}



