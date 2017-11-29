package service;

import model.Movable;
import model.Train;

import java.util.*;

/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public class TrainOnline {

    private volatile ArrayList<Movable> movables = new ArrayList<Movable>();
    private final static TrainOnline instance = new TrainOnline();

    private TrainOnline() {

    }

    public static TrainOnline getInstance() {
        return instance;
    }

    public synchronized void subscribe(Movable movable) {
        movables.add(movable);
    }

    public synchronized void unsubscribe(Movable movable) {
        movables.remove(movable);
    }

    public synchronized void letsMove() {
        if (!movables.isEmpty()) {
            for (int i = 0; i < movables.size() ; i++) {
                System.out.println(movables.get(i));
                movables.get(i).move();
            }
        }else {
            System.out.println("Нету поездов в сети");
            Thread.currentThread().interrupt();
        }
    }
}


