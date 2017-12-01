package service;

import defaulStation.Initializer;
import defaulStation.SaintPetersburgUndergroundBlue;
import defaulStation.SaintPetersburgUndergroundRed;
import model.Train;


/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public class LiveTimeSimulation implements Runnable {

    public LiveTimeSimulation() {
    }

    public void run() {
        TrainOnline trainOnline = TrainOnline.getInstance();
        while (true) {
            trainOnline.letsMove();
            try {
                Thread.currentThread().sleep(200);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
