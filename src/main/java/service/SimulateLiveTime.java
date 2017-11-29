package service;

import defaulStation.Init;
import defaulStation.SaintPetersburgUndergroundBlue;
import defaulStation.SaintPetersburgUndergroundRed;
import model.Train;


/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public class SimulateLiveTime implements Runnable {

    public SimulateLiveTime() {

    }



    public void run() {
        new Init().initDefault();
        TrainOnline trainOnline = TrainOnline.getInstance();
        Train train = new Train(SaintPetersburgUndergroundBlue.PARNAS.getStation(), SaintPetersburgUndergroundRed.AKADEMICHESKAJA.getStation());
        trainOnline.subscribe(train);
        Train train1 = new Train(SaintPetersburgUndergroundRed.AKADEMICHESKAJA.getStation(), SaintPetersburgUndergroundBlue.PARNAS.getStation());
        trainOnline.subscribe(train1);
        while (true) {
            trainOnline.letsMove();
            if(train.accident(train1))break;
            try {
                Thread.currentThread().sleep(200);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
